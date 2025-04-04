package com.lgy.item_jdbc_oracle.Service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.lgy.item_jdbc_oracle.DAO.ItemDAO;
import com.lgy.item_jdbc_oracle.DTO.ItemDTO;

public class ItemContentService implements ItemService{


	@Override
	public void excute(Model model) {
		
		ItemDAO dao=new ItemDAO();
		ArrayList<ItemDTO> dtos = dao.list();
		model.addAttribute("content_view", dtos);
	}

}
