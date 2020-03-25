//package com.inma.itp;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//
//@SpringBootApplication(exclude = MessageSourceAutoConfiguration.class)
//public class ServletInitializer extends SpringBootServletInitializer {
//	private static Logger log = LoggerFactory.getLogger(ServletInitializer.class);
//
//	/*
//	 * public static void main(String[] args) {
//	 * SpringApplication.run(ServletInitializer.class, args); }
//	 */
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(ServletInitializer.class);
//	}
//}
