package com.lgy.member_oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.member_oracle.service.MemLoginService;
import com.lgy.member_oracle.service.MemService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemController {

	MemService service;
	
//	로그인 화면 이동
	@RequestMapping("/login")
	public String login(Model model) {
		log.info("@# login()");
		
		return "login";
	}
// 로그인 화면 => 로그인 여부 판단 
	@RequestMapping("/login_yn")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# loginyn()");
		
		model.addAttribute("request", request);
		
		service=new MemLoginService();
		int result = service.excute(model);
		
//		아이디와 비밀번호가 일치
		if (result == 1) {
			return "redirect:login_ok";
		}
		
		return "write_result";
	}
	
	@RequestMapping("/login_ok")
	public String write_view() {
		log.info("@# login_ok()");
		
		return "login_ok";
	}
	
}
