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

@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/calculation.jsp").forward(req, resp);
	}

	private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int num1 = Integer.parseInt(req.getParameter("start"));
		int num2 = Integer.parseInt(req.getParameter("end"));
		
		int sum = 0;
		for(int i = num1;  i <= num2; i++) {
			sum += i;
		}
		
		logger.debug(Integer.toString(sum));
		//logger.debug("{}",sum);
		
		HttpSession ss = req.getSession();
		
		ss.setAttribute("start", num1);
		ss.setAttribute("end", num2);
		ss.setAttribute("result", sum);
		
		req.getRequestDispatcher(req.getContextPath()+"/jsp/sumResult.jsp").forward(req, resp);
		
	
	}

}
