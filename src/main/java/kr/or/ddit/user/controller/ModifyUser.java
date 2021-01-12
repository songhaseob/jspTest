package kr.or.ddit.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;


public class ModifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserServiceI userService = new UserService();
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		
		UserVo uservo = userService.selectUser(userid);
		
		req.setAttribute("uservo", uservo);
		
		req.getRequestDispatcher(req.getContextPath()+"/user/userModify.jsp").forward(req, resp);
		
		logger.debug("uservo");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
