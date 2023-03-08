package in.conceptarchitect.bookmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.conceptarchitect.bookmanagement.entities.Book;

public interface BookRepository 
	extends JpaRepository<Book, String> {

}
