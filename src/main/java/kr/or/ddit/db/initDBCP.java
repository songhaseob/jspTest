package kr.or.ddit.db;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(value="/initDBCP", loadOnStartup = 1)
public class initDBCP extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(initDBCP.class);
	
	
	@Override
	public void init() throws ServletException {
		logger.debug("InitDBCP.init()");
		
		// connection pool 생성
		// application scope에 coonection pool을 저장
		BasicDataSource bs = new BasicDataSource();
		bs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bs.setUsername("hssong");
		bs.setPassword("java");
		bs.setInitialSize(20);
		
		// dbcp.jsp에서는 application scope에 저장된 connection pool을 사용하여 connection 객체를
		// 얻고 해제 하는 과정을 반복 - 시간체크
		
//		Application == ServletContext
		
		ServletContext sc = getServletContext();
		sc.setAttribute("bs", bs);
		
	}
}
