package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.model.UserVo;

public interface EmpServiceI {
	
	//전체 사용자 정보 조회
		List<EmpVo> selectAllEmp();
		
		
}
