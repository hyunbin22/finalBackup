package com.spring.bm.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


// add these 2 annotations
@Component
@Aspect
//
public class AnoLoggerAspect {
	
	private Logger logger = LoggerFactory.getLogger(AnoLoggerAspect.class);
	
	//1. pintcut : 실행대상 메소드 표현식 적용
	//@Pointcut("execution(* com.kh.spring..*(..))")
	@Pointcut("execution(* com.kh.spring..insert*(..))")
	public void beforeAop() {}
	
	//2. advice 등록
	@Before("beforeAop()")
	public void testApp(JoinPoint joinpoint) {
		Signature s = joinpoint.getSignature();
		logger.debug("[BEFORE : ]" + s.getName());
	}
	
	@Around("execution(* com.kh.spring..*(..))")
	public Object loggerAround(ProceedingJoinPoint joinpoint) throws Throwable{
		logger.debug("[BEFORE : ] 건철 화이팅!! 할수있다!!!");
		Object obj = joinpoint.proceed();
		
		logger.debug("[AFTER : ] 파이널 화이팅!!");
		return obj;
	}
	
}
