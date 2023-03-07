package in.conceptarchitect.bookmanagement;

import java.util.ArrayList;
import java.util.List;

import in.conceptarchitect.dbutils.DbManager;

public class DbManagerBookRepostiory implements BookRepository {
	
	//dependency inversion
	DbManager db;
	

	//dependency injection
	public DbManagerBookRepostiory(DbManager db) {
		super();
		this.db=db;
		
	}

	@Override
	public List<Book> getAll(){
		
		return db.executeCommand(connection->{
			
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
		});
		
		
			
			
		
		
		
	}

	@Override
	public Book getById(String id) {
		
		return db.executeCommand(connection->{
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
		});
			
			
	}
	
	@Override
	public void add(Book book) {
		
		db.executePrepared("insert into books "
				+ "		  (isbn,title,author,price,rating,cover,description,tags)"
				+ " values(?,?,?,?,?,?,?,?)", statement->{
					statement.setString(1, book.getId());
					statement.setString(2, book.getTitle());
					statement.setString(3, book.getAuthor());
					statement.setInt(4, book.getPrice());
					statement.setDouble(5, book.getRating());
					statement.setString(6, book.getCover());
					statement.setString(7, book.getDescription());
					statement.setString(8, book.getTags());
					
				});
		
		
		
	}
	
	@Override
	public boolean remove(String id) {
		
		return db.executeUpdate("delete from books where isbn='"+id+"'")==1;
		
	}
	
	@Override
	public void update(Book book) {
		
		db.executePrepared( " update books "					
				+ "		  set title=?,author=?,price=?,rating=?,cover=?,description=?,tags=?"
				+ " where isbn=?;", 
				
				statement->{
					statement.setString(1, book.getTitle());
					statement.setString(2, book.getAuthor());
					statement.setInt(3, book.getPrice());
					statement.setDouble(4, book.getRating());
					statement.setString(5, book.getCover());
					statement.setString(6, book.getDescription());
					statement.setString(7, book.getTags());
					statement.setString(8, book.getId());
			
		});
		
			
	}
	
}
