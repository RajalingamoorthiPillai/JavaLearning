package in.conceptarchitect.bookmanagement.services;

import java.util.List;

import in.conceptarchitect.bookmanagement.entities.Author;

public interface AuthorService {
	
	Author addAuthor(Author author);
	List<Author> getAllAuthors();
	Author getAuthorById(String id);
	void deleteAuthor(String id);
	Author updateAuthor(Author author);
	List<Author> searchAuthorsByTag(String tag);	

}
