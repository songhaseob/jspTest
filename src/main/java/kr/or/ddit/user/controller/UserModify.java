package kr.or.ddit.user.controller;

import java.io.IOException;
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


public class UserModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserServiceI userService = new UserService();
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid = req.getParameter("userid");
		
		UserVo uservo = userService.selectUser(userid);
		
		req.setAttribute("uservo", uservo);
		
		req.getRequestDispatcher(req.getContextPath()+"/user/userModify.jsp").forward(req, resp);
		
	}

	// 사용자 정보 수정 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터를 읽기 전에 실행
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String pass = request.getParameter("pass");
		String alias = request.getParameter("alias");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date reg_dt = null;
		try {
			reg_dt = sdf.parse(request.getParameter("reg_dt"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String zipcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		UserVo uservo = new UserVo(userid,usernm,pass,reg_dt,alias,addr1,addr2,zipcode);
		
		int updateCnt = userService.modifyUser(uservo);
		
		if(updateCnt == 1) {
			response.sendRedirect(request.getContextPath()+"/user?userid="+userid);
		}else {
			doGet(request,response);
		}
		
		
	}
}
