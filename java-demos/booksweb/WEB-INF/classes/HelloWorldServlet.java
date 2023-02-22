import java.io.IOException;

import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class HelloWorldServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        var writer = new PrintWriter( response.getWriter() );

        writer.printf("Hello World From Java Servlet. Today is %s", new Date());

        writer.close();

    }

}