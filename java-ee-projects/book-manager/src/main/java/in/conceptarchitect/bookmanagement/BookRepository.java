package in.conceptarchitect.bookmanagement;

import java.util.List;

public interface BookRepository {

	List<Book> getAll();

	Book getById(String id);

	void add(Book book);

	boolean remove(String id);

	void update(Book book);

}