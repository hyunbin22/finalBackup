package com.spring.bm.notice.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bm.common.PageBarFactory;
import com.spring.bm.department.model.service.DepartmentService;
import com.spring.bm.employee.model.service.EmployeeService;
import com.spring.bm.notice.model.service.NoticeService;
import com.spring.bm.notice.model.vo.Notice;
import com.spring.bm.notice.model.vo.UploadNotice;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	@Autowired
	DepartmentService deptservice;
	@Autowired
	EmployeeService empSerivce;
	
                                                                           //	@RequestParam(name="empNo") int empNo
	//게시판에서 게시판등록화면으로 화면전환
	@RequestMapping("/notice/notice.do")
	public String Notice(Model model) {                             
		List<Map<String, String>> list = deptservice.selectDeptList();
//		Map<String, String> empMap = empSerivce.selectEmpOne(empNo);

//		model.addAttribute("empOne",empMap);
		model.addAttribute("deptList",list);
		
		return "notice/noticeInsert";
	}

	//게시판등록 ,첨부파일
	@RequestMapping("/notice/insertNotice.do")
	public ModelAndView insertNotice(@RequestParam Map<String, Object> param,
			@RequestParam(value="upFile", required=false) MultipartFile upFile, HttpServletRequest request) {

		//	             파일업로드 처리하기
		//	      1.저장경로 지정하기
		String saveDir=request.getSession().getServletContext().getRealPath("/resources/upload/board");

		List<UploadNotice> upNoticeList=new ArrayList(); //여러파일 보관용

		File dir=new File(saveDir);

			if(!upFile.isEmpty()) {
				//파일명 생성(rename)
				String oriFileName=upFile.getOriginalFilename();
				String ext=oriFileName.substring(oriFileName.lastIndexOf("."));
				//규칙설정
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHMMssSSS");
				int rdv = (int)(Math.random()*1000);
				String reName=sdf.format(System.currentTimeMillis())+"_"+rdv+ext;
				try {
					upFile.transferTo(new File(saveDir+"/"+reName));
				}catch(Exception e) {
					e.printStackTrace();
				}
				//DB에 저장할 데이터 보관
				UploadNotice un=new UploadNotice();
				un.setUpNoticeOrgName(oriFileName);
				un.setUpNoticeReName(reName);
				upNoticeList.add(un);
			}

		int result=0;
		
		try {
			result=noticeService.insertNotice(param,upNoticeList);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		String msg="";
		String loc="/notice/selectNoticeList.do";
		if(result>0) {
			msg="게시판등록성공!";
		}else {
			msg="게시판등록실패!";
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("msg",msg);
		mv.addObject("loc",loc);
		mv.setViewName("common/msg");
		return mv;
	}


	//작성글 상세페이지로 연결
	@RequestMapping("/notice/selectNoticeOne.do")
	public String selectNoticeOne(@RequestParam(name="nName") String nName, @RequestParam("nReadCount") int nReadCount, Model model) {
		
		
		Notice nt = noticeService.selectNoticeOne(nName);
		//조회수 +1
		int rc = noticeService.updateReadCount(nReadCount);
		
		model.addAttribute("nt",nt);
		model.addAttribute("rc",rc);
		
		return "notice/noticeOne";
	}
	
	//관련사이트화면
	@RequestMapping("/notice/site.do")
	public String site() {
		return "notice/noticeSite";
	}

	//메인화면에서 게시판화면으로 화면전환, 게시판목록 (페이징처리)
	//ModelAndView : 모델과 view를 한번에 묶어서 처리
		@RequestMapping("/notice/selectNoticeList.do")
		public ModelAndView selectList(@RequestParam(value="cPage", required=false, defaultValue="0") int cPage, Model model) {

			//반환될 modelAndView객체 생성
			ModelAndView mv = new ModelAndView();
			int numPerPage = 5;
			List<Map<String,String>> list = noticeService.selectNoticeList(cPage, numPerPage);
			int totalCount = noticeService.selectNoticeCount();

			mv.addObject("pageBar", PageBarFactory.getPageBar(totalCount, cPage, numPerPage, "/spring/notice/selectNoticeList.do"));
			mv.addObject("count", totalCount);
			mv.addObject("list",list);   //key value형식 -> model로 들어감
			mv.setViewName("notice/noticeList");   // -> view

			return mv;
		}

		@RequestMapping("/notice/noticeForm")
		public String boardForm() {
			return "notice/noticeForm";
		}
		
}
