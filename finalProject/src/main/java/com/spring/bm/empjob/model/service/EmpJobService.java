package com.spring.bm.empjob.model.service;

import java.util.List;
import java.util.Map;

public interface EmpJobService {

	/* 직급등록 */
	int insertEmpJob(Map<String, String> param) throws Exception;
	/* 직급리스트출력 */
	List<Map<String, String>> empJobList();
	/* 직급수정 */
	int updateEmpJob(Map<String, String> param) throws Exception;
	/* 직급하나출력 */
	Map<String, Object> selectEmpJobOne(int jobNo);

}
