package in.conceptarchitect.books.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.conceptarchitect.bookmanagement.BookDbManager;
import in.conceptarchitect.bookmanagement.EntityNotFoundException;
import in.conceptarchitect.jdbc.DbManager;

/**
 * Servlet implementation class BookDetailsServlet
 */

//"com.mysql.jdbc.Driver"
//"com.mysql.cj.jdbc.Driver"
		

public class BookDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String [] paths=request.getRequestURI().split("/");
		String id= paths[paths.length-1];
		String url="jdbc:mysql://localhost/booksdb";
		String userName="root";
		String password="@DM1n."; 
		var writer=new PrintWriter(response.getWriter());
				
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			var dbManager=new DbManager(url, userName, password);
			var bookManager=new BookDbManager(dbManager);
			
			var book= bookManager.getBookById(id);
			
			
			
			writer.printf("<h1>%s</h1>",book.getTitle());
			writer.printf("<h2>by %s</h2>",book.getAuthor());
			writer.printf("<ul>");
			writer.printf("<li>Price: Rs %d</li>",book.getPrice());
			writer.printf("<li>Rating: Rs %f / 5</li>",book.getRating());
			
			writer.println("</ul>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			response.setStatus(500);
			writer.printf("<h1>Internal Server Error</h1><p>Don't worry we are working on it</p>");
		}
		catch(EntityNotFoundException ex) {
			response.setStatus(404);
			writer.printf("<h1>No Book with isbn: %s</h1>", id);
		}
		
		
		writer.flush();
		
				
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
