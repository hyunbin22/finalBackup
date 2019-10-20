package com.spring.bm.notice.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.bm.notice.model.dao.NoticeDao;
import com.spring.bm.notice.model.vo.Notice;
import com.spring.bm.notice.model.vo.UploadNotice;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao dao;
	@Autowired
	SqlSessionTemplate sqlSession;
	
	
	@Override
	@Transactional(rollbackFor = Exception.class) //RuntimeException 발생시!
	public int insertNotice(Map<String, Object> param, List<UploadNotice> upNoticeList)throws Exception{
		int result=0;
		int boardNo=0;
		result=dao.insertNotice(sqlSession, param); //board테이블에 데이터를 입력!
		if(result==0) throw new RuntimeException();
		if(upNoticeList.size()>0) {
			for(UploadNotice n : upNoticeList) {
				n.setNNo(Integer.parseInt((String)param.get("nNo")));
				result=dao.insertUploadNotice(sqlSession, n);
			
				if(result==0) throw new Exception();
			}
		}
		
		return result;
	}

	@Override
	public Notice selectNoticeOne(String nName) {
		return dao.selectNoticeOne(sqlSession, nName);
	}

	@Override
	public int selectNoticeCount() {
		return dao.selectNoticeCount(sqlSession);
	}

	@Override
	public List<Map<String, String>> selectNoticeList(int cPage, int numPerPage) {
		return dao.selectNoticeList(sqlSession, cPage, numPerPage);
	}

	@Override
	public int updateReadCount(int nReadCount) {
		return dao.updateReadCount(sqlSession, nReadCount);
	}
	
	

}
