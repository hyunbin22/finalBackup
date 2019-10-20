package com.spring.bm.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTest {
	// log4J를 적용하기 위해서는 Logger 객체를 이용한다.
	private static Logger logger = LoggerFactory.getLogger(Log4jTest.class);
	// 이게 log4j를 생성하는 방식!
	
	
	public static void main(String[] args) {
		Log4jTest.test();
	}
	
	public static void test() {
		logger.debug("Debug 야!");
		logger.info("info 야!");
		logger.warn("warn 야!");
		logger.error("erro 야!");
	}
}
