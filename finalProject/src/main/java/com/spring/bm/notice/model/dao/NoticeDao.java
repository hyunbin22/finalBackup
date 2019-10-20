package com.spring.bm.notice.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.bm.notice.model.vo.Notice;
import com.spring.bm.notice.model.vo.UploadNotice;

public interface NoticeDao {

	Notice selectNoticeOne(SqlSessionTemplate sqlSession, String nName);

	int selectNoticeCount(SqlSessionTemplate sqlSession);

	List<Map<String, String>> selectNoticeList(SqlSessionTemplate sqlSession, int cPage, int numPerPage);

	int updateReadCount(SqlSessionTemplate sqlSession, int nReadCount);

	int insertNotice(SqlSessionTemplate sqlSession, Map<String, Object> param);

	int insertUploadNotice(SqlSessionTemplate sqlSession, UploadNotice n);

}
