package in.conceptarchitect.bookmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDbManagerV0 {
	
	String url;
	String userName;
	String password;
	
	
	
	public BookDbManagerV0(String url, String userName, String password) {
		super();
		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	public List<Book> getAllBooks(){
		
		
		Connection connection=null;
		try {			
			connection=DriverManager.getConnection(url,userName,password);
			var statement=connection.createStatement();
			var rs= statement.executeQuery("select * from books");
			var books=new ArrayList<Book>();
			while(rs.next()) {
				
				var book=new Book();
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setRating(rs.getDouble("rating"));
				book.setDescription(rs.getString("description"));
				book.setTags(rs.getString("tags"));
				book.setCover(rs.getString("cover"));
				book.setId(rs.getString("isbn"));
				
				
				books.add(book);
			}
			
			return books;
			
		}catch(SQLException ex) {
			throw new JdbcException(ex.getMessage(),ex);
			
		}finally {
			try { 
				if(connection!=null)
					connection.close();
			}catch(Exception ex) {
				throw new JdbcException(ex.getMessage(),ex);
			}
		}
		
		
	}

	public Book getBookById(String id) {
		Connection connection=null;
		try {			
			connection=DriverManager.getConnection(url,userName,password);
			var statement=connection.createStatement();
			var rs= statement.executeQuery("select * from books where isbn='"+id+"'");
			if(rs.next()) {
				
				var book=new Book();
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setRating(rs.getDouble("rating"));
				book.setDescription(rs.getString("description"));
				book.setTags(rs.getString("tags"));
				book.setCover(rs.getString("cover"));
				book.setId(rs.getString("isbn"));
				
				return book;
				
			}else
				throw new EntityNotFoundException("No Book with isbn: "+id);//return null;
			
			
			
		}catch(SQLException ex) {
			throw new JdbcException(ex.getMessage(),ex);
			
		}finally {
			try { 
				if(connection!=null)
					connection.close();
			}catch(Exception ex) {
				throw new JdbcException(ex.getMessage(),ex);
			}
		}
	}
	
	public void addBook(Book book) {
		Connection connection=null;
		try {			
			connection=DriverManager.getConnection(url,userName,password);
			
			var statement= connection.prepareStatement("insert into books "
					+ "		  (isbn,title,author,price,rating,cover,description,tags)"
					+ " values(?,?,?,?,?,?,?,?)");
			
			statement.setString(1, book.getId());
			statement.setString(2, book.getTitle());
			statement.setString(3, book.getAuthor());
			statement.setInt(4, book.getPrice());
			statement.setDouble(5, book.getRating());
			statement.setString(6, book.getCover());
			statement.setString(7, book.getDescription());
			statement.setString(8, book.getTags());
			
			statement.executeUpdate();
			
		
			
			
			
		}catch(SQLException ex) {
			throw new JdbcException(ex.getMessage(),ex);
			
		}finally {
			try { 
				if(connection!=null)
					connection.close();
			}catch(Exception ex) {
				throw new JdbcException(ex.getMessage(),ex);
			}
		}
		
	}
	
	public boolean removeBook(String id) {
		Connection connection=null;
		try {			
			connection=DriverManager.getConnection(url,userName,password);
			
			var statement= connection.prepareStatement("delete from books where isbn=?");
			
			statement.setString(1, id);
			
			
			var row=statement.executeUpdate();
			
			return row==1;
			
		
			
			
			
		}catch(SQLException ex) {
			throw new JdbcException(ex.getMessage(),ex);
			
		}finally {
			try { 
				if(connection!=null)
					connection.close();
			}catch(Exception ex) {
				throw new JdbcException(ex.getMessage(),ex);
			}
		}
		
		
	}
	
	public void updateBook(Book book) {
		Connection connection=null;
		try {			
			connection=DriverManager.getConnection(url,userName,password);
			
			var statement= connection.prepareStatement(
					  " update books "					
					+ "		  set title=?,author=?,price=?,rating=?,cover=?,description=?,tags=?"
					+ " where isbn=?;");
					
			
			
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setInt(3, book.getPrice());
			statement.setDouble(4, book.getRating());
			statement.setString(5, book.getCover());
			statement.setString(6, book.getDescription());
			statement.setString(7, book.getTags());
			statement.setString(8, book.getId());
			
			statement.executeUpdate();
			
		
			 
			
			
		}catch(SQLException ex) {
			throw new JdbcException(ex.getMessage(),ex);
			
		}finally {
			try { 
				if(connection!=null)
					connection.close();
			}catch(Exception ex) {
				throw new JdbcException(ex.getMessage(),ex);
			}
		}
		
	}
	
}
