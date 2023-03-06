import java.io.IOException;

import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class BookDetailsServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        var writer = new PrintWriter( response.getWriter() );

        String[] url=request.getRequestURL().toString().split("/");

        var title= url[url.length - 1];

        writer.printf("<h1>About: %s</h1>", title.toUpperCase());

        writer.close();

    }

}