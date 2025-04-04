package com.lgy.item_jdbc_oracle.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.item_jdbc_oracle.Service.ItemContentService;
import com.lgy.item_jdbc_oracle.Service.ItemService;
import com.lgy.item_jdbc_oracle.Service.ItemWriteService;
import com.lgy.item_jdbc_oracle.util.Constant;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class ItemController {

	ItemService service;
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
//	상품 목록 조회
	@RequestMapping("/content_view")
	public String content_view(Model model) {
		log.info("@# content_view()");
		
		service=new ItemContentService();
		service.excute(model);
		
		return "content_view";
	}
//	상품 등록
	@RequestMapping("/write_result")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write_result()");
		
		model.addAttribute("request", request);
		
		service=new ItemWriteService();
		service.excute(model);
		
		return "write_result";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view()");
		
		return "item_write";
	}
	}
