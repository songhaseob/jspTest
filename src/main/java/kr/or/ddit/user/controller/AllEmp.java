package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.service.EmpService;
import kr.or.ddit.user.service.EmpServiceI;

public class AllEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpServiceI empService = new EmpService();
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<EmpVo> emplist = empService.selectAllEmp();
		
		req.setAttribute("list", emplist);
		
		req.getRequestDispatcher(req.getContextPath()+"/emp/allEmp.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
