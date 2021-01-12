package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;


public class pagingUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserServiceI userService = new UserService();
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// left.jsp : /pagingUser?page=1&pageSize=5
		// ==>        /pagingUser
		
		// doGet 메소드에서 page, pageSzie 파라미터가 request 객체에 존재 하지 않을 때
		// page는 1로, pageSize 5로 생각을 코드로 작성
		// 파라미터가 존재하면 해당 파라미터를 이용
		
		PageVo vo = new PageVo();
		
		// 삼항연산자
		// int page = req.getParameter("page") == null ? 1: Integer.parseInt(req.getParameter("page"));
		// int pageSize = req.getParameter("pageSize") == null ? 5: Integer.parseInt(req.getParameter("pageSize"));
		
		// refactoring : 코드를 (깔끔하게)바꾸는데 기존 동작방식을 유지한채로 변경하는 기법
		
		int page = 0;
		int pageSize = 0;
		
	
		if(req.getParameter("page") != null) {
			
			page = Integer.parseInt(req.getParameter("page"));
		}else {
			page = 1;
		}
		if(req.getParameter("pageSize") != null) {
			
			pageSize = Integer.parseInt(req.getParameter("pageSize"));
		}else {
			pageSize = 5;
		}
		
		vo.setPage(page);
		vo.setPageSize(pageSize);
		
		Map<String, Object> map = userService.selectPagingUser(vo);
		
		List<UserVo> list = (List<UserVo>) map.get("userList");
		
		int userCnt= (int)map.get("userCnt");
		int pagination = (int)Math.ceil((double)userCnt/pageSize); 
		
		
		req.setAttribute("list", list);
		req.setAttribute("pagination", pagination);
		

		req.getRequestDispatcher(req.getContextPath()+"/user/pagingUser.jsp").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
