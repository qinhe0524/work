package com.xk.listener;

import org.apache.log4j.Logger;

public class TestMe {
	Logger log4j = Logger.getRootLogger();

	public void gogogo() {
		log4j.info("info");
		log4j.debug("debug");
		log4j.error("error");
		log4j.warn("warn");
	}
}
