package com.lgy.member_mybatis_oracle.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.member_mybatis_oracle.dao.MemDAO;
import com.lgy.member_mybatis_oracle.dto.MemDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemController {
//	servlet-context 에 있는 sqlSession 객체 연결
	@Autowired
	private SqlSession sqlSession;
	
//	로그인 화면 이동
	@RequestMapping("/login")
	public String login(Model model) {
		log.info("@# login()");
		
		return "login";
	}
	
//	로그인화면->로그인 여부 판단
	@RequestMapping("/login_yn")
	public String loginYn(HttpServletRequest request, Model model) {
		log.info("@# loginYn()");
		
//		model.addAttribute("request", request);
		
//		service=new MemLoginService();
//		int result = service.execute(model);
		MemDAO dao=sqlSession.getMapper(MemDAO.class);
		
		ArrayList<MemDTO> dtos = dao.loginYn(request.getParameter("mem_uid")
										   , request.getParameter("mem_pwd"));
		
		if (dtos.isEmpty()) {
			return "redirect:login";
		} else {
			if (request.getParameter("mem_pwd").equals(dtos.get(0).getMem_pwd())) {
				return "redirect:login_ok";
			}
			return "redirect:login";
		}
	}
	
//	로그인 성공시 이동
	@RequestMapping("/login_ok")
	public String login_ok() {
		log.info("@# login_ok()");
		
		return "login_ok";
	}
	
	@RequestMapping("/register")
	public String register() {
		log.info("@# register()");
		
		return "register";
	}
	
	@RequestMapping("/registerOk")
	public String registerOk(HttpServletRequest request, Model model) {
		log.info("@# registerOk()");

//		model.addAttribute("request", request);
		
//		service=new MWriteService();
//		service.execute(model);
		MemDAO dao=sqlSession.getMapper(MemDAO.class);
		dao.write(request.getParameter("mem_uid")
				, request.getParameter("mem_pwd")
				, request.getParameter("mem_name"));
		
		return "redirect:login";
	}
	
}









