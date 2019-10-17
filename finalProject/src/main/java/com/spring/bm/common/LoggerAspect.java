package com.spring.bm.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAspect {
	
	private Logger logger=LoggerFactory.getLogger(LoggerAspect.class);
	
	
	// 특정 메소드 실행전|후|전후에 실행할 로직
	// around  방식 (전후처리) * 전처리만, 후처리만 가능
	public Object loggerAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		// 전처리 시작
		Signature sig = joinPoint.getSignature();
		/* logger.debug("[signature = ]"+sig); */
		String type=sig.getDeclaringTypeName();
		String methodName = sig.getName();
		String componentName = "";
		if(type.indexOf("Controller")>-1) {
			componentName="Controller";
		} else if(type.indexOf("ServiceImpl")>-1) {
			componentName="ServiceImpl";
		} else if (type.indexOf("Dao")>-1) {
			componentName="DaoImpl";
		}
		logger.debug("[Before = ]"+componentName+type+"."+methodName+"()");
		//return joinPoint.proceed(); 
		// 전처리 끝
		
		
		Object obj = joinPoint.proceed();// 이메소드를 기준으로 전처리 후처리가 나눠짐
		
		//후처리 시작
		logger.debug("[After = ]"+componentName+type+"."+methodName+"()");
		// 후처리 끝
		
		
		return obj;
	};
	
	// 전처리 메소드
	public void before(JoinPoint joinpoint) {
		joinpoint.getSignature(); // getSignature 는 넘어가는 클래스명 확인하는 메소드
		// 이전 단계에서 넘어노는 파라미터 값 확인
		Object[] objs = joinpoint.getArgs();
		// 매개변수 값 확인
//		for(Object obj : objs) {
//			
//		}
		
		logger.debug("*before* 전처리 전용");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
