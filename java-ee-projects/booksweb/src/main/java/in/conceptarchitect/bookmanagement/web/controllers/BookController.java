package in.conceptarchitect.bookmanagement.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.conceptarchitect.bookmanagement.entities.Book;
import in.conceptarchitect.bookmanagement.services.BookService;
import in.conceptarchitect.bookmanagement.viewmodel.NewBook;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping
	public List<Book> getAll(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable String id) {
		return bookService.getBookById(id);
	}
	
	@PostMapping
	public Book addBook(@RequestBody NewBook book) {
		return bookService.addBook(book);
	}

}
