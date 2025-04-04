package com.lgy.member_jdbc_oracle.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lgy.member_jdbc_oracle.DAO.MemDAO;
import com.lgy.member_jdbc_oracle.DTO.memberDTO;

@Service
public class MemLoginService implements MemService{
	@Override
	public int excute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String mId = request.getParameter("mem_uid");
		String mPw = request.getParameter("mem_pwd");
		int re;
		
		MemDAO dao = new MemDAO();
		ArrayList<memberDTO> dtos = dao.loginYn(mId, mPw);
		
		
		if (dtos.isEmpty()) {
			re=-1;
		} else {
			if (mPw.equals(dtos.get(0).getMEM_PWD())) {
				re=1;
			} else {
				re=0;
			}
		}
		
//		컨트롤러에 re 전달(0,1,-1)
		return re;
	}
}
