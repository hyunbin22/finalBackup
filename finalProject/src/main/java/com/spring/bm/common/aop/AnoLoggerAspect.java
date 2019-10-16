package com.spring.bm.common.aop;

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

@Component
@Aspect
public class AnoLoggerAspect {

	private Logger logger=LoggerFactory.getLogger(AnoLoggerAspect.class);
	
	//1.pintcut : 실행대상 매소드 표현식적용
	@Pointcut("execution(* com.kh.spring..insert*(..))")
	public void beforeAop() {}
	
	//2.adviece등록
	@Before("beforeAop()")
	public void testAop(JoinPoint joinpoint) {
		Signature s=joinpoint.getSignature();
		logger.debug("[before]"+s.getName());
				
	}
	
	
	@Around("execution(* com.kh.spring..*(..))")
	public Object loggerAround(ProceedingJoinPoint joinpoint) throws Throwable{
		logger.debug("[before] 건철화이팅!! 할 수 있다!!!");
		Object obj=joinpoint.proceed();
		logger.debug("[after] 파이널 화이팅~!");
		return obj;
	}
	
	
	
	
}





