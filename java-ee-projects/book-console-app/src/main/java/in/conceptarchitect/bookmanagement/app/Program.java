package in.conceptarchitect.bookmanagement.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.AppConfig;
import in.conceptarchitect.bookmanagement.BookService;
import in.conceptarchitect.bookmanagement.DbManagerBookRepostiory;
import in.conceptarchitect.bookmanagement.SimpleBookService;
import in.conceptarchitect.dbutils.DbManager;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var service = getBookService();
		
		displayAllBooks(service);
	}

	
	private static BookService getBookService() {
		// TODO Auto-generated method stub
		
		var context= new AnnotationConfigApplicationContext(AppConfig.class);
		
		BookService service=context.getBean(BookService.class);
		System.out.println(service);
		return service;
	}
	
	private static BookService getBookService1() {
		// TODO Auto-generated method stub
		
		var context= new ClassPathXmlApplicationContext("classpath:config/appconfig.xml");
		
		BookService service=context.getBean(BookService.class);
		System.out.println(service);
		return service;
	}



	private static BookService getBookService0() {
		var service=new SimpleBookService();
		String url="jdbc:mysql://localhost/booksdb";
		String userName="root";
		String password="@DM1n."; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		var db=new DbManager(url, userName, password);
		var repository= new DbManagerBookRepostiory(db);
		service.setRepository(repository);
		
		return service;
	}

	private static void displayAllBooks(BookService service) {
		for(var book : service.getAllBooks())
			System.out.println(book.getTitle());
	}

}
