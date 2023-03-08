package in.conceptarchitect.bookmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.conceptarchitect.bookmanagement.entities.Author;

public interface AuthorRepository 
	extends JpaRepository<Author, String> {

}
