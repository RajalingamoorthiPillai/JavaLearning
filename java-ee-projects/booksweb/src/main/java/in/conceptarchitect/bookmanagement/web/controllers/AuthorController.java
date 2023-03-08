package in.conceptarchitect.bookmanagement.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.conceptarchitect.bookmanagement.entities.Author;
import in.conceptarchitect.bookmanagement.services.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
	
	@Autowired
	AuthorService service;
	
	

	@GetMapping()
	public List<Author> getAll(){
		return service.getAllAuthors();
	}
	

	@PostMapping()
	public Author addNew(@RequestBody Author author) {
		return service.addAuthor(author);
	}
	
	
	@GetMapping("/{id}")
	public Author getById(@PathVariable String id) {
		return service.getAuthorById(id);
	}
	
	@PutMapping("/{id}")
	public Author updateAuthor(@PathVariable String id, @RequestBody Author author) {
		return service.updateAuthor(author);
	}
	
	@DeleteMapping("/{id}")
	public void  deleteAuthor(@PathVariable String id) {
		service.deleteAuthor(id);
		
	}
	

}
