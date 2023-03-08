package in.conceptarchitect.bookmanagement.services;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.conceptarchitect.bookmanagement.entities.Author;
import in.conceptarchitect.bookmanagement.entities.EntityNotFoundException;
import in.conceptarchitect.bookmanagement.repositories.AuthorRepository;

@Service
public class JpaAuthorService implements AuthorService {
	
	@Autowired //automatically get me the repository implementation of this type
	AuthorRepository repository; //dependency injection

	@Override
	public Author addAuthor(Author author) {
		// TODO Auto-generated method stub
		return repository.save(author);
	}

	@Override
	public List<Author> getAllAuthors() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Author getAuthorById(String id) {
		// TODO Auto-generated method stub
		return repository
					.findById(id)
					.orElseThrow(()->new EntityNotFoundException("No Author with id :"+id));
		
	}

	@Override
	public void deleteAuthor(String id) {
		// TODO Auto-generated method stub
		var author= getAuthorById(id);
		repository.delete(author);
	}

	@Override
	public Author updateAuthor(Author author) {
		
		var dbAuthor= getAuthorById(author.getId());
		dbAuthor.setName(author.getName());
		dbAuthor.setBiography(author.getBiography());
		dbAuthor.setPhotoUrl(author.getPhotoUrl());
		dbAuthor.setTags(author.getTags());
		
		return repository.save(dbAuthor);
		

	}

	@Override
	public List<Author> searchAuthorsByTag(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

}
