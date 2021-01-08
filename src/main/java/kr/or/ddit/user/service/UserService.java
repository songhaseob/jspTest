package kr.or.ddit.user.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MyBatisUtil;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;

public class UserService implements UserServiceI{
	
	UserDaoI userDao = new UserDao();
	@Override
	public List<UserVo> selectAllUser() {
		return userDao.selectAllUser();
	}

	@Override
	public UserVo selectUser(String userid) {
		return userDao.selectUser(userid);
	}

	@Override
	public List<UserVo> selectPagingUser(PageVo vo) {
		return userDao.selectPagingUser(vo);
	}
	
}