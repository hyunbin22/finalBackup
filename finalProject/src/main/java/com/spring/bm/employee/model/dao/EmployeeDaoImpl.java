
package com.spring.bm.employee.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.bm.employee.model.vo.EmpFile;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	/* 사원리스트불러오기 */
	@Override
	public List<Map<String, String>> selectEmpList(SqlSessionTemplate session, int cPage, int numPerPage) {
		RowBounds rows = new RowBounds((cPage-1) * numPerPage, numPerPage);
		return session.selectList("emp.selectEmpList", rows);
	}

	@Override
	public int selectEmpCount(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectOne("emp.selectEmpCount");
	}
	/* 사원리스트불러오기끝 */

	/* 사원등록 */
	@Override
	public int insertEmp(SqlSessionTemplate session, Map<String, String> param) {
		// TODO Auto-generated method stub
		return session.insert("emp.insertEmp", param);
	}
	
	/* 사원첨부파일등록 */
	@Override
	public int insertEmpFile(SqlSessionTemplate session, EmpFile e) {
		// TODO Auto-generated method stub
		return session.insert("emp.insertEmpFile", e);
	}
	/* 사원등록끝 */
	
	/* 사원상세보기 */
    @Override
    public Map<String, String> selectEmpOne(SqlSessionTemplate sqlSession, int empNo) {
       return sqlSession.selectOne("emp.selectEmpOne",empNo);
    }
	

}

