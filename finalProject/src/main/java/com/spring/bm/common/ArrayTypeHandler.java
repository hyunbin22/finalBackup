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
		// 배열을 스트링 형식으로 디비에 값을 넣어주게 세팅
		if(parameter !=null) {
			ps.setString(i, String.join(",", parameter));			
		}else {
			ps.setString(i, "");
		}
	}


	@Override
	public String[] getResult(ResultSet rs, String columnName) throws SQLException {
		// DB 에 있는 스트링 (, 로 나눠진 긴 스트링)을 배열로 바꿔주는것
		String temp = rs.getString(columnName);
		return temp.split(",");
	}

	@Override
	public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {
		// DB 에 있는 스트링 ( "," 로 나눠진 긴 스트링)을 배열 (인덱스 번호)로 바꿔 원하는 값을 가지고 오는 메소드
		String temp = rs.getString(columnIndex);
		return temp.split(",");
	}

	@Override
	public String[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
