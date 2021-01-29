package kr.or.ddit.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;
import kr.or.ddit.utill.FileUtil;

@MultipartConfig
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
		
		// 사용자가 profile을 업로드 한경우
		// 전송한 파일이름 (filename)
		// 파일 확장자
		// 서버에 저장할 파일 이름(realfilename)
		// 서버에 지정된 공간에 저장
		Part profile = request.getPart("profile");
		
		String filename="";
		String realfilename ="";
		
		if(profile.getSize() > 0) {
			 filename = FileUtil.getFileName(profile.getHeader("Content-Disposition"));
			 String fileExtension = FileUtil.getFileExtension(filename);
			 realfilename = UUID.randomUUID().toString()+fileExtension;
			
			profile.write("d:\\upload\\" + realfilename);
			
		}
		
		
		UserVo uservo = new UserVo(userid,usernm,pass,new Date(),alias,addr1,addr2,zipcode,filename,realfilename);
		
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


