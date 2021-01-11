package kr.or.ddit.user.respository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MyBatisUtil;
import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.model.UserVo;

public class EmpDao implements EmpDaoI{

	@Override
	public List<EmpVo> selectAllEmp() {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
	
		List<EmpVo> userList = sqlSession.selectList("emp.selectAllEmp");
		
		//사용한 자원 반환
		sqlSession.close();
		
		return userList;

	
}
}
