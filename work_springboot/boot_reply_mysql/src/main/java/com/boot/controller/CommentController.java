package com.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.dto.CommentDTO;
import com.boot.service.*;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService service;
	
	@RequestMapping("/save")
	public String write(@RequestParam HashMap<String, String> param) {
		log.info("@# save()");
		
		service.save(param);
		
		ArrayList<CommentDTO> commentList = service.findAll(param);
		
		return null;
//		return commentList;
	}
}







