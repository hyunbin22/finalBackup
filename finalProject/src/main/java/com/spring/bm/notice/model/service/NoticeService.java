package com.spring.bm.notice.model.service;

import java.util.List;
import java.util.Map;

import com.spring.bm.notice.model.vo.Notice;
import com.spring.bm.notice.model.vo.UploadNotice;

public interface NoticeService {

	Notice selectNoticeOne(String nName);

	int selectNoticeCount();

	List<Map<String, String>> selectNoticeList(int cPage, int numPerPage);

	int updateReadCount(int nReadCount);

	int insertNotice(Map<String, Object> param, List<UploadNotice> upNoticeList) throws Exception;

}
