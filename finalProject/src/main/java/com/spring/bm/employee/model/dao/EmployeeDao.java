package com.spring.bm.employee.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public interface EmployeeDao {
	
	/* 사원리스트불러오기 */
	List<Map<String, String>> selectEmpList(SqlSessionTemplate session, int cPage, int numPerPage);
	int selectEmpCount(SqlSessionTemplate session);
	/* 사원리스트불러오기끝 */
	
	/* 사원등록 */
	int insertEmp(SqlSessionTemplate session, Map<String, String> param);
	/* 사원첨부파일등록 */
	int insertEmpFile(SqlSessionTemplate session, Map<String, String> m);
	/* 사원등록끝 */
	/* 사원상세보기 */
	Map<String, String> selectEmpOne(SqlSessionTemplate session, int empNo);
}
