package com.spring.bm.common;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class ArrayTypeHandler implements TypeHandler<String[]> {

	@Override
	public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		//스트링 형식으로 값을 넣어주게 세팅
		if(parameter!=null) {
			ps.setString(i, String.join(",", parameter));
		}
		else {
			ps.setString(i, "");
		}
	}

	@Override
	public String[] getResult(ResultSet rs, String columnName) throws SQLException {
		String temp=rs.getString(columnName);
		return temp.split(",");
	}

	@Override
	public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {
		String temp=rs.getString(columnIndex);
		return temp.split(",");
	}

	@Override
	public String[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
		String temp=cs.getString(columnIndex);
		return temp.split(",");
	}

}
