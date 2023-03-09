package JNDI_example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JNDIBind")
public class JNDIBind extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        try {
            PrintWriter out = res.getWriter();
            String[] JNDI = {"J", "N", "D", "II"};
            Context ctx = new InitialContext();
            ctx.bind("myString", JNDI);
            out.println("bind myString Success");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

    }
}
