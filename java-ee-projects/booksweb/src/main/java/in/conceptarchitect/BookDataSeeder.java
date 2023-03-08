package in.conceptarchitect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.conceptarchitect.bookmanagement.entities.Author;
import in.conceptarchitect.bookmanagement.entities.DuplicateEntityException;
import in.conceptarchitect.bookmanagement.services.AuthorService;

@Configuration
public class BookDataSeeder {

	Logger logger=LoggerFactory.getLogger(BookDataSeeder.class);
	
	
	@Bean
	public CommandLineRunner addAuthors(AuthorService authorService) {
		return args->{
			logger.info("adding new records");
			
			Author [] authors= {
				new Author("vivek-dutta-mishra", "Vivek Dutta Mishra", "The Author of the The Accursed God", "mahabharata,fiction", "vivek.jpg"),
				new Author("dinkar", "Ramdhari Singh Dinkar", "The National Poet of India", "poet,classic", "dinkar.jpg"),
				new Author("jeffrey-archer", "Jeffrey Archer", "Leading best-seller of English fiction", "best-seller,fiction", "archer.jpg")
			};
			
			for(var author:authors) {
				try {
					logger.info("added "+authorService.addAuthor(author));
					
				}catch(DuplicateEntityException ex) {
					//ignore
					logger.warn("skipping "+author);
				}
			}
			
			
		};
	}
	
}
