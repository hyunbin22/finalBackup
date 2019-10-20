package com.spring.bm.department.model.service;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

	/* 부서등록 */
	int insertDept(Map<String, String> param) throws Exception;
	/* 부서리스트출력 */
	List<Map<String, String>> selectDeptList();
	/* 부서수정 */
	int updateDept(Map<String, Object> map) throws Exception;
	/* 부서상세 */
	Map<String, String> selectDeptOne(int deptNo);


}
