package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TimesTablesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public TimesTablesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>TimesTablesServlet</title>");
		pw.println("</head>");
		pw.println("<style>");
		pw.println("table{");
		pw.println("width : 100%");
		pw.println("}");
		pw.println("</style>");
		pw.println("<body>");
		pw.println("<table border='1'>");
		for(int i = 1; i <= 9; i++) {
			pw.println("<tr>");
			for(int j= 2; j <= 9; j++) { 
		pw.println("<td>"+ j + " * " + i + " = " + i * j+"</td>");
				} 
			pw.println("</tr>");
			}
		pw.println("</table>");
		pw.println("</body>");
		pw.println("</html>");
		
		pw.flush();
		pw.close();
	}

	

}
