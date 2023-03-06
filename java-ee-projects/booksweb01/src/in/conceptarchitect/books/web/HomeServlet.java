package in.conceptarchitect.books.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.conceptarchitect.bookmanagement.BookDbManager;
import in.conceptarchitect.jdbc.DbManager;



public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HomeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		var writer=new PrintWriter(response.getWriter(),true);
		
//		String url="jdbc:mysql://localhost/booksdb";
//		String userName="root";
//		String password="@DM1n.";
//		var bookManager= new BookDbManager(new DbManager(url,userName,password));
		
//		var books= bookManager.getAllBooks();
//		writer.println("<ul>");
//		for(var book : books) {
//			writer.printf("<li>%s</li>", book.getTitle());
//		}
		writer.println("<h1>Welcome</h1>");
		writer.close();
	}

}
