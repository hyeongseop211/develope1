package com.lgy.item_jdbc_oracle.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.item_jdbc_oracle.DAO.ItemDAO;

public class ItemWriteService implements ItemService{
	
	@Override
	public void excute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		
		ItemDAO dao=new ItemDAO();
		dao.write(name, price, description);
	}
}
