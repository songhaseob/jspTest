package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/scope")
public class Scope extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/scope.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String scope = req.getParameter("scope");
		
		req.setAttribute("request", scope + "_request");
		
		HttpSession ss = req.getSession();
		
		ss.setAttribute("session", scope+"_session");
		
		ServletContext application =  getServletContext();
		application.setAttribute("application", scope + "_application");
		
		req.getRequestDispatcher(req.getContextPath()+"/jsp/scopeResult.jsp").forward(req, resp);
		
	}

}
