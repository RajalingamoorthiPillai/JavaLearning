import java.io.IOException;

import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class BookListServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        var writer = new PrintWriter( response.getWriter() );

        writer.printf("<h1>Our Recommended Books</h1>", new Date());

        writer.close();

    }

}