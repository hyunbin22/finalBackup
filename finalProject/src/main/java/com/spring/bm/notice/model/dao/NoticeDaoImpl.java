package com.spring.bm.notice.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.bm.notice.model.vo.Notice;
import com.spring.bm.notice.model.vo.UploadNotice;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Override
	public int insertNotice(SqlSessionTemplate sqlSession, Map<String, Object> param) {
		return sqlSession.insert("notice.insertNotice",param);
	}

	@Override
	public int insertUploadNotice(SqlSessionTemplate sqlSession, UploadNotice n) {
		return sqlSession.insert("board.insertUploadNotice",n);
	}

	@Override
	public Notice selectNoticeOne(SqlSessionTemplate sqlSession, String nName) {
		return sqlSession.selectOne("notice.selectNoticeOne", nName);
	}

	@Override
	public int selectNoticeCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("notice.selectNoticeCount");
	}

	@Override
	public List<Map<String, String>> selectNoticeList(SqlSessionTemplate sqlSession, int cPage, int numPerPage) {
		RowBounds rows=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("notice.selectNoticeList",null,rows);
	}

	@Override
	public int updateReadCount(SqlSessionTemplate sqlSession, int nReadCount) {
		return sqlSession.update("notice.updateReadCount", nReadCount);
	}
	
	
	
	
	
	

}
