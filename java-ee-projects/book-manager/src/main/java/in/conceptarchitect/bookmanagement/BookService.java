package in.conceptarchitect.bookmanagement;

import java.util.List;

public interface BookService {

	List<Book> getAllBooks();

	Book getBookById(String id);

	void addBook(Book book);

	boolean removeBook(String id);

	void updateBook(Book book);

}