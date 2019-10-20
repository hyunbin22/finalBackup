package com.spring.bm.empjob.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.bm.empjob.model.dao.EmpJobDao;

@Service
public class EmpJobServiceImpl implements EmpJobService {

	@Autowired
	EmpJobDao dao;
	@Autowired
	SqlSessionTemplate session;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertEmpJob(Map<String, String> param) throws Exception{
		int result = dao.insertEmpJob(session, param);
		if(result == 0) throw new Exception();
		
		return result;
	}

	@Override
	public List<Map<String, String>> empJobList() {
		return dao.empJobList(session);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateEmpJob(Map<String, String> param) throws Exception{
		int result = dao.updateEmpJob(session, param);
		if(result == 0) throw new Exception();
		
		return result;
	}

	@Override
	public Map<String, Object> selectEmpJobOne(int jobNo) {
		// TODO Auto-generated method stub
		return dao.selectEmpJobOne(session, jobNo);
	}
	
	
	
	

}
