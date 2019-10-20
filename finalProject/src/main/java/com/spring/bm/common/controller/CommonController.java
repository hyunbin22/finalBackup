package com.spring.bm.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	@RequestMapping("/common/main.do")
	public String toMain() {
		
		return "common/main";
	}

}
