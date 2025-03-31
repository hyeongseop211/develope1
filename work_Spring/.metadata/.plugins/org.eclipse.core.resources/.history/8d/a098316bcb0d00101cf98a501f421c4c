package com.lgy.spring_ex9;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainClass {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		FIre fire = ctx.getBean("fire", FIre.class);
		
		fire.getFIreInfo();
		
		water Water = ctx.getBean("Water", water.class);
		
		
		Water.getwaterInfo();
		
		ctx.close();
	
	}

}
