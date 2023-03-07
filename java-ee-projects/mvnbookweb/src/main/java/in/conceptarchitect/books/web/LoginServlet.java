package in.conceptarchitect.books.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.conceptarchitect.bookmanagement.Book;
import in.conceptarchitect.bookmanagement.DbManagerBookService;
import in.conceptarchitect.dbutils.DbManager;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, 
							HttpServletResponse resp) throws ServletException, IOException {
		
		
		req
			.getRequestDispatcher("/WEB-INF/jsps/signin.jsp")
			.forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email= req.getParameter("email");
		String password=req.getParameter("password");
		int index= email.indexOf("@");
		String user=email.substring(0,index);
		System.out.println("user name "+user);
		if(user.length()==password.length() && !user.equals(password)) {
			//login is success
			resp.sendRedirect("/mvnbookweb/book/list");
		} else {
			//login failed
			req.setAttribute("error", "Invalid credentials");
			req
				.getRequestDispatcher("/WEB-INF/jsps/signin.jsp")
				.forward(req, resp);
						
		}
	}
	
	

}
