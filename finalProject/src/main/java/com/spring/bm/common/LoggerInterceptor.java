package com.spring.bm.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger= LoggerFactory.getLogger(LoggerInterceptor.class);

	// 전처리용 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("========================== start ===================================");
		logger.debug(request.getRequestURI());
		logger.debug("--------------------------------------------------------------------");
		
		
		// 로그인시에만 dev 등록 및 목록조회를 할수 있게 수정
		if(request.getSession().getAttribute("loginMember")==null) {
			request.setAttribute("msg", " 로그인 후 이용하세요!");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return false;
		} else {
			logger.debug("로그인 했으니깐 진정해!");
			return super.preHandle(request, response, handler);
		}
		
	}

	// 후 처리용 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("===================== Mapping Method 실행 ============================");
		logger.debug("---------------------------------------------------------------------");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
	
	
	
	
}
