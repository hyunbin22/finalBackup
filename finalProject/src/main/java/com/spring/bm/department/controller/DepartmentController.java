package com.spring.bm.department.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bm.department.model.service.DepartmentService;

@Controller
public class DepartmentController {

	
	private Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	DepartmentService service;
	
	/* 부서등록 */
	@RequestMapping("/dept/insertDept.do")
	public String insertDept(Model model) {
		model.addAttribute("temp", "등록");
		return "dept/deptEnroll";
	}
	
	/* 부서보기/수정 */
	@RequestMapping("/dept/updateDept.do")
	public ModelAndView updateDept(int deptNo, Model model) {
		
		Map<String, String> dept = service.selectDeptOne(deptNo);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dept", dept);
		mv.addObject("temp", "수정");
		mv.setViewName("dept/deptEnroll");

		return mv;
	}
	
	@RequestMapping("/dept/insertDeptEnd.do")
	public ModelAndView insertDeptEnd(@RequestParam Map<String, String> param) {
		
		int result = 0;
		try {
			result = service.insertDept(param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg = "";
		String loc = "/dept/deptList.do";
		
		if(result > 0) msg = param.get("deptName") + " 등록이 완료되었습니다.";
		else msg = param.get("deptName") + " 등록이 실패하였습니다.";
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("loc", loc);
		mv.setViewName("common/msg");
		
		return mv;
	}
	/* 부서등록 종료 */
	
	/* 부서리스트 출력 */
	@RequestMapping("/dept/deptList.do")
	public ModelAndView selectDeptList() {
		
		List<Map<String, String>> list = service.selectDeptList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("dept/deptList");
		return mv;
	}
	
	/* 부서수정하기 */
	@RequestMapping("/dept/updateDept")
	public ModelAndView deleteDept(@RequestParam(value="deptName", required=false) String deptName,
			@RequestParam(value="status", required=false) String deptStatus, int deptNo) {
		
		int result = 0;
		Map<String, String> map = new HashMap();
		if(deptName != null && deptName != "") map.put("deptName", deptName);
		else if(deptStatus != null && deptStatus != "") map.put("deptStatus", deptStatus);
			
		try {
			result = service.updateDeptStatus(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		String msg = "";
		String loc = "/dept/deptList.do";
		if(result > 0) msg = "부서가 사용중지되었습니다.";
		else msg="부서사용중지가 실패하였습니다.";
		mv.addObject("msg", msg);
		mv.addObject("loc", loc);
		mv.setViewName("common/msg");
		return mv;
	}	

}

