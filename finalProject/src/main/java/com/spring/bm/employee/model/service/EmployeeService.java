package com.spring.bm.employee.model.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

	/* 사원 리스트 불러오기 */
	List<Map<String, String>> selectEmpList(int cPage, int numPerPage);
	int selectEmpCount();
	/* 사원 리스트 불러오기 끝 */
	/* 사원등록 */
	int insertEmp(Map<String, String> param, List<Map<String, String>> fileList) throws Exception;
	/* 사원상세보기 */
	Map<String, String> selectEmpOne(int empNo);
}

