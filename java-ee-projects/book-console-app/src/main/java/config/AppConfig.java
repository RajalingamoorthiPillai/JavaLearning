package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.conceptarchitect.bookmanagement.BookRepository;
import in.conceptarchitect.bookmanagement.BookService;
import in.conceptarchitect.bookmanagement.DbManagerBookRepostiory;
import in.conceptarchitect.bookmanagement.SimpleBookService;
import in.conceptarchitect.dbutils.DbManager;

@Configuration
public class AppConfig {
	
	@Bean
	public DbManager dbManager() {
		String url="jdbc:mysql://localhost/booksdb";
		String userName="root";
		String password="@DM1n."; 
		return new DbManager(url, userName, password);
	}

	@Bean
	public BookRepository repository() {
		return new DbManagerBookRepostiory(dbManager());
	}
	
	@Bean
	public BookService bookService() {
		var service=new SimpleBookService();
		service.setRepository(repository());
		return service;
	}
}
