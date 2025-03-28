package com.lgy.spring_6_4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student1", Student.class);
//		이름 : 홍길동
//		나이 : 20
//		취미 : [수영, 요리]
//		키 : 180.0
//		몸무게 : 80.0
		System.out.println("이름 : "+student1.getName());
		System.out.println("나이 : "+student1.getAge());
		System.out.println("취미 : "+student1.getHobbys());
		System.out.println("키 : "+student1.getHeight());
		System.out.println("몸무게 : "+student1.getWeight());
		
		Student student2 = ctx.getBean("student2", Student.class);
//		이름 : 홍길순
		
//		나이 : 30
//		취미 : [마라톤, 요리]
//		키 : 190.0
//		몸무게 : 70.0
		System.out.println("이름 : "+student2.getName());
		System.out.println("나이 : "+student2.getAge());
		System.out.println("취미 : "+student2.getHobbys());
		System.out.println("키 : "+student2.getHeight());
		System.out.println("몸무게 : "+student2.getWeight());
		
	}
}
