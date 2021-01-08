package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.respository.EmpDao;
import kr.or.ddit.user.respository.EmpDaoI;

public class EmpService implements EmpServiceI{
	
	EmpDaoI EmpDao = new EmpDao();

	@Override
	public List<EmpVo> selectAllEmp() {
		
		return EmpDao.selectAllEmp();
	}
	
	
	
}