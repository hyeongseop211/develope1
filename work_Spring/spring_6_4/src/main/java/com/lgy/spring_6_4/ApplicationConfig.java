package com.lgy.spring_6_4;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

//스프링 설정파일로 사용
@Configuration
//자바에서 xml 스프링 설정파일 추가
@ImportResource("classpath:applicationCTX.xml")
public class ApplicationConfig {
//	빈 객체 생성
	@Bean
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student student = new Student("홍길동", 20, hobbys);
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
	
//	@Bean
//	public Student student2() {
//		ArrayList<String> hobbys = new ArrayList<String>();
//		hobbys.add("독서");
//		hobbys.add("음악감상");
//		
//		Student student = new Student("홍길순", 28, hobbys);
//		student.setHeight(170);
//		student.setWeight(55);
//		
//		return student;
//	}
}
