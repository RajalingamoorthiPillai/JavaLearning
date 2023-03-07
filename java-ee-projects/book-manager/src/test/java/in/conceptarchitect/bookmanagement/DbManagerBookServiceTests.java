package in.conceptarchitect.bookmanagement;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import in.conceptarchitect.dbutils.DbManager;
import in.conceptarchitect.dbutils.JdbcException;




public class DbManagerBookServiceTests {

	String url="jdbc:mysql://localhost/booksdb_test";
	String userName="root";
	String password="@DM1n.";
	BookService bookManager;
	
	String id1="111", id2="222";
	String title1="The Accursed God", title2="Kane And Abel";
	
	//@Before
	@BeforeEach
	public void init() throws SQLException
	{
		//db=new BookDbManager(url, userName, password);
		var dbManager=new DbManager(url, userName, password);
		bookManager=new DbManagerBookService(dbManager);
		
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
		
		
		var result=bookManager.getAllBooks();
		
		
		
		assertEquals(2, result.size());
	}
	
	@Test
	public void getByValidIdReturnsValidBook() {
		var book= bookManager.getBookById(id1);
		
		
		assertEquals(title1, book.getTitle());
	}
	
	@Test  //(expected = EntityNotFoundException.class)
	public void getByInvalidIdThrowsEntityNotFoundException() {
		
		assertThrows(EntityNotFoundException.class, ()->{
			bookManager.getBookById("invalid-id");
		});
		
	}
	
	 
	@Test
	public void removeBookRemovesTheBookWithValidId() {
		var result=bookManager.removeBook(id1);
		assertTrue(result);
		
		assertThrows(EntityNotFoundException.class, ()->{
			bookManager.getBookById(id1);	
		});
	}
	
	
	public void faultyFunction() {
		throw new RuntimeException();
	}
	
	
	@Test
	public void faultyFunctionThrowsRuntimeException() {
		
		//assertThrows(RuntimeException.class, () -> faultyFunction());
		
		assertThrows(RuntimeException.class, this::faultyFunction);
		
	}
	
	@Test
	public void getAllBooksMayThrowJdbcExceptionOnWrongPassword() {
		BookService db=new DbManagerBookService(new DbManager(url, userName, "wrong-password"));
		
		//assertThrows(JdbcException.class, ()->db.getAllBooks());
		assertThrows(JdbcException.class, db::getAllBooks);
		
		
	}
	
	
	
	
	@Test
	public void removeBookReturnsFalseForBookWithInvalidId() {
		assertFalse( bookManager.removeBook("invalidId"));
	}
	
	@Test
	public void udpateBookUpdatesBookWithValidId() {
		var book= bookManager.getBookById(id1);
		
		var newTitle="New Title";
		book.setTitle(newTitle);
		
		bookManager.updateBook(book);
		
		var book2=bookManager.getBookById(id1);
		
		assertEquals(newTitle, book2.getTitle());
		
	}
	
	

}
