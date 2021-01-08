package kr.or.ddit.user.respository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MyBatisUtil;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoI{

	@Override
	public List<UserVo> selectAllUser() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		// select : 리턴되는 값의 복수 유무를 판단
		// 			1. 단 건  : 일반객체를 반환 (UserVo) select One()
		//			2. 여러 건 : List<UserVo> selectList()
		// insert, update, delete : insert,update, delete
		
		// 메소드 이름과 실행할 sql id를 동일하게 맞추자(유지보수-다른 개발자의 가독성)
		
		List<UserVo> userList = sqlSession.selectList("users.selectAllUser");
		
		//사용한 자원 반환
		sqlSession.close();
		
		return userList;
	}

	@Override
	public UserVo selectUser(String userid) {
		SqlSession sqlsession = MyBatisUtil.getSqlSession();
		
		UserVo user = sqlsession.selectOne("users.selectUser",userid);
		
		sqlsession.close();
		
		return user;
	}

	@Override
	public List<UserVo> selectPagingUser(PageVo vo) {
		SqlSession sqlsession = MyBatisUtil.getSqlSession();
		
		List<UserVo> page = sqlsession.selectList("users.selectPagingUser", vo);
		sqlsession.close();
		return page;
	}
	
}
