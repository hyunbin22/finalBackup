package com.spring.bm.empjob.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bm.empjob.model.service.EmpJobService;

public class EmpJobController {
	
	@Autowired
	EmpJobService service;
	
	/* 직급등록폼으로 가기 */
	@RequestMapping("/empJob/insertEmpJob")
	public String insertEmpJob() {
		return "empJob/empJobForm";
	}
	
	/* 직급등록 */
	@RequestMapping("/empJob/insertEmpJobEnd.do")
	public ModelAndView insertEmpJobEnd(@RequestParam Map<String, String> param) {
		
		int result = 0;
		try {
			result = service.insertEmpJob(param);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String msg = "";
		String loc = "/empJob/empJobList.do";
		if(result > 0) msg = param.get("empJobName") + " 직급이 등록 완료되었습니다.";
		else msg = param.get("empJobName") + " 직급등록이 실패하였습니다.";
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("loc", loc);
		mv.setViewName("common/msg");
		
		return mv;
	}
	
	/* 직급리스트출력 */
	@RequestMapping("/empJob/empJobList.do")
	public ModelAndView empJobList() {
		List<Map<String, String>> list = service.empJobList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("empJob/empJobList");
		return mv;
	}
	
	/* 직급수정하기 */
	@RequestMapping("/empJob/updateEmpJob.do")
	public ModelAndView updateEmpJob(@RequestParam Map<String, String> param) {
		
		int result = 0;
		try {
			result = service.updateEmpJob(param);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String msg = "";
		String loc = "/empJob/empJobList.do";
		
		ModelAndView mv = new ModelAndView();

		if(result > 0) msg = "직급수정이 완료되었습니다.";
		else msg = "직급수정이 실패하였습니다.";
		
		mv.addObject("msg", msg);
		mv.addObject("loc", loc);
		mv.setViewName("common/msg");
		
		return mv;
	}
	

}
