package in.conceptarchitect.bookmanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.jdbc.DbManager;

public class BookDbManagerTests {

	String url="jdbc:mysql://localhost/booksdb_test";
	String userName="root";
	String password="@DM1n.";
	BookDbManagerV0 db;
	
	String id1="111", id2="222";
	String title1="The Accursed God", title2="Kane And Abel";
	
	@Before
	public void init() throws SQLException
	{
		//db=new BookDbManager(url, userName, password);
		
		db=new BookDbManagerV0(url, userName, password);
		
		setupDb();
		
		
	}
	
	private void setupDb() throws SQLException{
		// TODO Auto-generated method stub
		Connection con=null;
		
			con=DriverManager.getConnection(url,userName,password);
			var statement=con.createStatement();
			
			
			
			statement.executeUpdate("drop table if exists books");
			
			
			statement.executeUpdate("CREATE TABLE `books` (\r\n"
					+ "  `isbn` varchar(255) NOT NULL,\r\n"
					+ "  `author` varchar(255) DEFAULT NULL,\r\n"
					+ "  `cover` varchar(255) DEFAULT NULL,\r\n"
					+ "  `description` varchar(255) DEFAULT NULL,\r\n"
					+ "  `price` int NOT NULL,\r\n"
					+ "  `rating` double NOT NULL,\r\n"
					+ "  `tags` varchar(255) DEFAULT NULL,\r\n"
					+ "  `title` varchar(255) DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`isbn`)\r\n"
					+ ") ");
			
			
			
			var insert1= con.prepareStatement(
					"insert into books "
					+ "		  (isbn,title,author,price,rating,cover,description,tags)"
					+ " values(?,?, 'Vivek Dutta Mishra', 299,4.3,'the-accursed-god.jpg','description','tags1tag2');");
			
			insert1.setString(1, id1);
			insert1.setString(2, title1);
			insert1.executeUpdate();
			
			
			
			
			var insert2=con.prepareStatement("insert into books "
					+ "		  (isbn,title,author,price,rating,cover,description,tags)"
					+ " values(?,?, 'Jeffrey Archer', 299,4.3,'the-accursed-god.jpg','description','tags1,tag2');");

			
			insert2.setString(1, id2);
			insert2.setString(2, title2);
			insert2.executeUpdate();
			
			
			con.close();
	}

	@Test
	public void getAllBooksReturnsListOfAllBooks() {
		
		
		var result=db.getAllBooks();
		
		assertEquals(2, result.size());
	}
	
	@Test
	public void getByValidIdReturnsValidBook() {
		var book= db.getBookById(id1);
		
		assertEquals(title1, book.getTitle());
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void getByInvalidIdThrowsEntityNotFoundException() {
		
		db.getBookById("invalid-id");
	}
	
	 
	@Test
	public void removeBookRemovesTheBookWithValidId() {
		var result=db.removeBook(id1);
		assertTrue(result);
		
		assertThrows(EntityNotFoundException.class, ()->db.getBookById(id1));
	}
	
	@Test
	public void removeBookReturnsFalseForBookWithInvalidId() {
		assertFalse( db.removeBook("invalidId"));
	}
	
	@Test
	public void udpateBookUpdatesBookWithValidId() {
		var book= db.getBookById(id1);
		
		var newTitle="New Title";
		book.setTitle(newTitle);
		
		db.updateBook(book);
		
		var book2=db.getBookById(id1);
		
		assertEquals(newTitle, book2.getTitle());
		
	}
	
	

}
