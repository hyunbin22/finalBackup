package com.spring.bm.department.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	/* 부서등록 */
	@Override
	public int insertDept(SqlSessionTemplate session, Map<String, String> param) {
		// TODO Auto-generated method stub
		return session.insert("dept.insertDept", param);
	}

	/* 부서리스트 출력 */
	@Override
	public List<Map<String, String>> selectDeptList(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("dept.selectDeptList");
	}

	/* 부서수정 */
	@Override
	public int updateDept(SqlSessionTemplate session, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return session.update("dept.updateDept", map);
	}

	/* 부서상세 */
	@Override
	public Map<String, String> selectDeptOne(SqlSessionTemplate session, int deptNo) {
		// TODO Auto-generated method stub
		return session.selectOne("dept.selectDeptOne", deptNo);
	}
	
	


}
