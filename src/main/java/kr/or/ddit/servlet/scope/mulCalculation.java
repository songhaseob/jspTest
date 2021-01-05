package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/mulcalculation")
public class mulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/calculation.jsp").forward(req, resp);
	}

	private static final Logger logger = LoggerFactory.getLogger(mulCalculation.class);
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int num1 = Integer.parseInt(req.getParameter("gob1"));
		int num2 = Integer.parseInt(req.getParameter("gob2"));
		
		int result = num1 * num2;
		
		logger.debug(Integer.toString(result));
		
		HttpSession ss = req.getSession();
		
		ss.setAttribute("gob1", num1);
		ss.setAttribute("gob2", num2);
		ss.setAttribute("result", result);
		
		req.getRequestDispatcher(req.getContextPath()+"/jsp/mulResult.jsp").forward(req, resp);
		
	}

}
