package com.spring.bm.employee.model.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EmpFile {
	
	private int efNo;
	private int empNo;
	private String efcName;
	private String efOrgName;
	private String efReName;

}
