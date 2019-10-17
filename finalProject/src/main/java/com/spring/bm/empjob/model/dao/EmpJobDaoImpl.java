package com.spring.bm.empjob.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpJobDaoImpl implements EmpJobDao {

	@Override
	public int insertEmpJob(SqlSessionTemplate session, Map<String, String> param) {
		// TODO Auto-generated method stub
		return session.insert("empJob.insertEmpJob", param);
	}

	@Override
	public List<Map<String, String>> empJobList(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("empJob.empJobList");
	}

	@Override
	public int updateEmpJob(SqlSessionTemplate session, Map<String, String> param) {
		// TODO Auto-generated method stub
		return session.update("empJob.updateEmpJob", param);
	}
	
	

}
