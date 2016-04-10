package edu.csus.datascience.cleanbackend;

import com.auth0.Auth0User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by merrillm on 4/9/16.
 */
@WebServlet
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n" +
                "    <title>Login</title>\n" +
                "  </head>\n" +
                "  <body>\n");

        // This is the same as Request.getSession().getAttribute("user");
        Auth0User user = Auth0User.get(request);

        resp.getWriter().println("<h1>Welcome</h1>");
        resp.getWriter().println("<img src=\"" + user.getPicture() + "\" />");
        resp.getWriter().println("<p>Hello " + user.getName() + "!</p>");
        resp.getWriter().println("  </body>\n" +
                "</html>");
    }
}
