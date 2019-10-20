package com.spring.bm.notice.model.vo;

import lombok.Data;

@Data
public class UploadNotice {
	
	private int upNoticeNo;
	private int nNo;
	private String upNoticeOrgName;
	private String upNoticeReName;
	
	
	public UploadNotice(int upNoticeNo, int nNo, String upNoticeOrgName, String upNoticeReName) {
		super();
		this.upNoticeNo = upNoticeNo;
		this.nNo = nNo;
		this.upNoticeOrgName = upNoticeOrgName;
		this.upNoticeReName = upNoticeReName;
	}


	public UploadNotice() {
		// TODO Auto-generated constructor stub
	}

}
