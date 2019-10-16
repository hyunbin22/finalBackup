package com.spring.bm.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;//연결되는 메소드에 대한 정보를 담고있음.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAspect {

	private Logger logger=LoggerFactory.getLogger(LoggerAspect.class);
	//특정 매소드 실행전|후|전후에 실행할 로직
	//around방식(전후처리) * 전처리만, 후처리만 가능
	public Object loggerAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		Signature sig=joinPoint.getSignature();
		/* logger.debug("[signature] "+sig); */
		String type=sig.getDeclaringTypeName();
		String methodName=sig.getName();
		String componentName="";
		if(type.indexOf("Controller")>-1) {
			componentName="Controller";
		}else if(type.indexOf("Service")>-1) {
			componentName="ServiceImpl";
		}else if(type.indexOf("Dao")>-1) {
			componentName="DaoImpl";
		}
		logger.debug("[Before]"+componentName+type+"."+methodName+"()");
		//return joinPoint.proceed();
		///전처리
		Object obj=joinPoint.proceed();//이메소드를 기준으로 전처리 후처리가 나눠짐
		//후처리시작
		logger.debug("[After]"+componentName+type+"."+methodName+"()");
		
		return obj;
		
	}
	
	//전처리 매소드
	public void before(JoinPoint joinpoint) {
		joinpoint.getSignature();
		//이전단계에서 넘어오는 파라미터값 확인
		Object[] objs=joinpoint.getArgs();
		for(Object obj : objs) {
			
		}
		
		logger.debug("*before*전처리 전용");
	}
	
	
	
	
	
}









