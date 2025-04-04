package com.lgy.member_jdbc_oracle.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.member_jdbc_oracle.DAO.MemDAO;

public class MwriteService implements MemService{

	@Override
	public int excute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String mem_uid = request.getParameter("MEM_UID");
		String mem_pwd = request.getParameter("MEM_PWD");
		String mem_name = request.getParameter("MEM_NAME");
		
		MemDAO dao=new MemDAO();
		dao.write(mem_uid, mem_pwd, mem_name);
		
		return 0;
	}
}
