
package com.spring.bm.employee.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bm.common.PageBarFactory;
import com.spring.bm.employee.model.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private Logger logger=LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService service;
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	/* 사원등록 */
	@RequestMapping("/emp/insertEmp.do")	//사원등록 폼으로 전환
	public String insertEmp() {
		return "emp/empEnroll";
	}
	
	@RequestMapping("/emp/insertEmpEnd.do")	//사원 등록 완료
	public ModelAndView insertEmpEnd(@RequestParam Map<String, String> param,
			@RequestParam(value="upFile", required=false) MultipartFile[] upFile,
			HttpServletRequest request) {
		
		param.replace("empPassword", pwEncoder.encode(param.get("empPassword")));
		
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/emp");
		Map<String, String> fMap = new HashMap();
		List<Map<String, String>> fileList = new ArrayList();
		
		File dir = new File(saveDir);
		
		if(!dir.exists()) logger.debug("생성결과 : " + dir.mkdir());
		for(MultipartFile f : upFile) {
			if(!f.isEmpty()) {
				String oriFileName = f.getOriginalFilename();
				String ext = oriFileName.substring(oriFileName.lastIndexOf("."));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHMMssSSS");
				int rdv = (int)(Math.random()*1000);
				String reName = sdf.format(System.currentTimeMillis()+"_"+rdv+ext);
				try {
					f.transferTo(new File(saveDir + "/" + reName));
				} catch(Exception e) {
					e.printStackTrace();
				}
				fMap.put("efOrgname", oriFileName);
				fMap.put("efReName", reName);
				fileList.add(fMap);
			}
		}
		
		int result = 0;
		try {
			result=service.insertEmp(param,fileList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		String msg = "";
		String loc = "/emp/empList.do";
		if(result > 0) {
			msg = param.get("empName") + "사원이 등록되었습니다.";
		} else {
			msg = param.get("empName") + "사원등록이 실패하였습니다.";
		}
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("msg", msg);
		mv.addObject("loc", loc);
		mv.setViewName("common/msg");
		
		return mv;
	}
	/* 사원등록끝 */
	
	/* 사원리스트 불러오기 */
	@RequestMapping("/emp/empList.do")
	public ModelAndView empList(@RequestParam(value="cPage", 
			required=false, defaultValue="0") int cPage) {
		
		int numPerPage = 10;
		List<Map<String,String>> list = service.selectEmpList(cPage, numPerPage);
		int totalCount = service.selectEmpCount();
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("pageBar", PageBarFactory.getPageBar(totalCount, cPage, numPerPage, "/bm/emp/empList.do"));
		mv.addObject("count", totalCount);
		mv.addObject("list", list);
		mv.setViewName("emp/empList");
		return mv;
	}
	
	/* 사원상세보기 */
	@RequestMapping("/emp/selectEmpOne.do")
	public ModelAndView selectEmpOne(int empNo) {
		Map<String, String> empMap = service.selectEmpOne(empNo);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("emp", empMap);
		mv.setViewName("emp/selectEmpOne");
		
		return mv;
	}

}

