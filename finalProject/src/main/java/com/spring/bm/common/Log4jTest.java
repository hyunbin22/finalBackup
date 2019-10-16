package com.spring.bm.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTest {
	//log4j를 적용하기 위해서는 Logger객체를 이용한다.
	private static Logger logger=LoggerFactory.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		Log4jTest.test();
	}
	
	public static void test() {
		
		logger.debug("Debug야!");
		logger.info("info야!");
		logger.warn("warn이야!");
		logger.error("error야!");
	}

}

