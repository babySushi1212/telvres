
import java.io.*;                                                    
import javax.servlet.*;                                              

public class ServerSnoop_Tempdir extends GenericServlet {

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/plain; charset=Big5");
		PrintWriter out = res.getWriter();

		ServletContext context = getServletContext();
		out.println("Server Container TempDir");
		// javax.servlet.context.tempdir
		out.println("context.TEMPDIR " + context.TEMPDIR);
		// :\Users\Tibame_T14\AppData\Local\JetBrains\IntelliJIdea2022.3\tomcat\cd4c3c98-020f-4e31-9c89-e166d47374c6\work\Catalina\localhost\SL314-intellij
		out.println(context.getAttribute("javax.servlet.context.tempdir"));
		out.println(context.getAttribute(context.TEMPDIR));
		out.println(context.getAttribute(ServletContext.TEMPDIR));
	}
}