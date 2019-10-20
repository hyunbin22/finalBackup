package com.spring.bm.empjob.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public interface EmpJobDao {

	/* 직급등록 */
	int insertEmpJob(SqlSessionTemplate session, Map<String, String> param);
	/* 직급리스트출력 */
	List<Map<String, String>> empJobList(SqlSessionTemplate session);
	/* 직급수정 */
	int updateEmpJob(SqlSessionTemplate session, Map<String, String> param);
	/* 직급하나출력 */
	Map<String, Object> selectEmpJobOne(SqlSessionTemplate session, int jobNo);

}
