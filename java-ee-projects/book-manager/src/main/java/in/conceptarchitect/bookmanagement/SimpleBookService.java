package in.conceptarchitect.bookmanagement;

import java.util.List;

public class SimpleBookService  implements BookService{
	
	BookRepository repository;
	

	public BookRepository getRepository() {
		return repository;
	}

	//depdendency injection
	public void setRepository(BookRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return repository.getAll();
	}

	@Override
	public Book getBookById(String id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		
		repository.add(book);
		
	}

	@Override
	public boolean removeBook(String id) {
		// TODO Auto-generated method stub
		return repository.remove(id);
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		repository.update(book);
		
	}

}
