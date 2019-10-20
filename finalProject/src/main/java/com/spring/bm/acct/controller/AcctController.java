package com.spring.bm.acct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AcctController {

	@RequestMapping("acct/is.do")
	public String is() {
		return "acct/is";
	}
	
	@RequestMapping("acct/bs.do")
	public String bs() {
		return "acct/bs";
	}
	
	@RequestMapping("acct/cf.do")
	public String cf() {
		return "acct/cf";
	}
	
}
