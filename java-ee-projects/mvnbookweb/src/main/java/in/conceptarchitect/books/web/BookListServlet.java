package in.conceptarchitect.books.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.conceptarchitect.bookmanagement.Book;
import in.conceptarchitect.bookmanagement.BookDbManager;
import in.conceptarchitect.dbutils.DbManager;

public class BookListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url="jdbc:mysql://localhost/booksdb";
		String userName="root";
		String password="@DM1n."; 
		DbManager dbManager= new DbManager(url, userName, password);
		
		BookDbManager bookManager= new BookDbManager(dbManager);
		
		List<Book> books = bookManager.getAllBooks();
		
		
		
		resp.getWriter().append("Total Books "+books.size());
	}

}
