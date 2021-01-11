package kr.or.ddit.etx;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;

public class PaginationTest {

	@Test
	public void paginationTest() {
		/***Given***/
		int userTotCnt = 32;
		int pageSize = 5;
		/***When***/
		int pagination =  (int)Math.ceil(userTotCnt/(double)pageSize);
		/***Then***/
		assertEquals(7, pagination);
	}
	
	@Test
	public void selectAlluserCntTest() {
		/***Given***/
		UserDaoI userDao = new UserDao();
		/***When***/
		int userCnt = userDao.selectAlluserCnt();
		/***Then***/
		assertEquals(16, userCnt);
	}
}
