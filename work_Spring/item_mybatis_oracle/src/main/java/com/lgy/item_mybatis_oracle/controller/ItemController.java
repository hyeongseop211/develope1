package com.lgy.item_mybatis_oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.item_mybatis_oracle.dao.ItemDAO;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class ItemController {

	/*
	ItemService service;
	public JdbcTemplate template;
	
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	*/
	@Autowired
	private SqlSession sqlSession;
	
//	상품 목록 조회
	@RequestMapping("/content_view")
	public String content_view(Model model) {
		log.info("@# content_view()");
		
//		service=new ItemContentService();
//		service.excute(model);
		ItemDAO dao=sqlSession.getMapper(ItemDAO.class);
		model.addAttribute("content_view", dao.list());
		
		return "content_view";
	}
//	상품 등록
	@RequestMapping("/write_result")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write_result()");
		
//		model.addAttribute("request", request);
		
//		service=new ItemWriteService();
//		service.excute(model);
		ItemDAO dao=sqlSession.getMapper(ItemDAO.class);
		dao.write(request.getParameter("name"), 
				request.getParameter("price"), 
				request.getParameter("description"));
		
		return "write_result";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view()");
		
		return "item_write";
	}
	
	}
