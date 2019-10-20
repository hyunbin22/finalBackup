
package com.spring.bm.employee.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bm.employee.model.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao dao;
	@Autowired
	SqlSessionTemplate session;
	
	/* 사원리스트불러오기 */
	@Override
	public List<Map<String, String>> selectEmpList(int cPage, int numPerPage) {
		
		return dao.selectEmpList(session, cPage, numPerPage);
	}
	@Override
	public int selectEmpCount() {
		// TODO Auto-generated method stub
		return dao.selectEmpCount(session);
	}
	/* 사원리스트불러오기끝 */
	/* 사원등록 */
	@Override
	public int insertEmp(Map<String, String> param, List<Map<String, String>> fileList) throws Exception{
		int result = 0;
		result = dao.insertEmp(session, param);
		if(result == 0) throw new Exception();
		if(fileList.size()>0) {
			for(Map<String,String> m : fileList) {
				m.put("empNo", param.get("empNo"));
				result = dao.insertEmpFile(session, m);
				if(result == 0) throw new Exception();
			}
		}
		return result;
	}
	
	/* 사원상세보기 */
	@Override
   public Map<String, String> selectEmpOne(int empNo) {
      return dao.selectEmpOne(session, empNo);
   }
	
	
}

