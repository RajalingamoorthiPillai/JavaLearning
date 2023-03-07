package in.conceptarchitect.bookmanagement;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookRepository implements BookRepository {

	List<Book> books=new ArrayList<Book>();
	
	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return books;
	}

	@Override
	public Book getById(String id) {
		// TODO Auto-generated method stub
		for(var book:books)
			if(book.getId().equalsIgnoreCase(id))
				return book;
		
		throw new EntityNotFoundException("Invalid Id:"+id);
	}

	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub
		books.add(book);

	}

	@Override
	public boolean remove(String id) {
		// TODO Auto-generated method stub
		var book= getById(id);
		books.remove(book);
		return true;
		
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		var dbBook=getById(book.getId());
		var index=books.indexOf(dbBook);
		books.set(index, book);
		
	}

}
