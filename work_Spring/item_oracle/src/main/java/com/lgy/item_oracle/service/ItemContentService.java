package com.lgy.item_oracle.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.lgy.item_oracle.dao.ItemDAO;
import com.lgy.item_oracle.dto.ItemDTO;


public class ItemContentService implements ItemService{

	@Override
	public void excute(Model model) {
		//dao 단 호출
		ItemDAO dao=new ItemDAO();
//		게시글들을 dtos 객체로 받음
		ArrayList<ItemDTO> dtos = dao.list();
//		dtos 객체를 list 이름으로 컨트롤러단으로 전송
		model.addAttribute("content_view", dtos);
	}


}
