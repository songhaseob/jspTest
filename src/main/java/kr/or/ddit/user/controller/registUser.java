package kr.or.ddit.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;


public class registUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceI userService = new UserService();
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);   
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String userid = req.getParameter("userid");
		
		UserVo uservo = userService.selectUser(userid);
		
		req.setAttribute("userid", uservo);
		
		req.getRequestDispatcher("user/result.jsp").forward(req, resp);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String pass = request.getParameter("pass");
		String alias = request.getParameter("alias");
		String zipcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		UserVo uservo = new UserVo(userid,usernm,pass,new Date(),alias,addr1,addr2,zipcode);
		
		int insertCnt = 0;
		
		try {
			insertCnt = userService.insertUser(uservo);
			
		} catch (Exception e) {
			
			insertCnt = 0;
			
		}
		
		if(insertCnt == 1) {
//			response.sendRedirect(request.getContextPath()+"/pagingUser");
			request.getRequestDispatcher(request.getContextPath()+"/pagingUser").forward(request, response);
		}else {
			request.getRequestDispatcher(request.getContextPath()+"/user/registUser.jsp").forward(request, response);
		}
		
		
		
	}
	}


