package com.lgy.member_oracle.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lgy.member_oracle.DAO.MemDAO;

@Service
public class MemLoginService implements MemService{
	
	@Override
	public int excute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String mId = request.getParameter("mem_uid");
		String mPw = request.getParameter("mem_pwd");
		
		MemDAO dao=new MemDAO();
		int re = dao.loginYn(mId, mPw);
		
//		컨트롤러에 re 전달(0,1,-1)
		return re;
	}

}
