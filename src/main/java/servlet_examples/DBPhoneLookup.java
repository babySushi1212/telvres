package servlet_examples;

import java.io.*;
import java.sql.*;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;

public class DBPhoneLookup extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {

            Context ctx = new javax.naming.InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB2");
            con = ds.getConnection();

            // Create a Statement object
            stmt = con.createStatement();

            // Execute an SQL query, get a ResultSet
//      rs = stmt.executeQuery("SELECT NAME, PHONE FROM EMPLOYEES");
            rs = stmt.executeQuery("SELECT * FROM EMP2");


            // Display the result set as a list
            out.println("<HTML><HEAD><TITLE>Phonebook</TITLE></HEAD>");
            out.println("<BODY>");
            out.println("<UL>");
            while (rs.next()) {
                out.println("<LI>" + rs.getString("EMPNO") + " " + rs.getString("ENAME"));
            }
            out.println("</UL>");
            out.println("</BODY></HTML>");
        } catch (SQLException e) {
            out.println("SQLException caught: " + e.getMessage());
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } finally {
            // Always close the database connection.
            try {
              if (con != null) {
                con.close();
              }
            } catch (SQLException ignored) {
            }
        }
    }
}
