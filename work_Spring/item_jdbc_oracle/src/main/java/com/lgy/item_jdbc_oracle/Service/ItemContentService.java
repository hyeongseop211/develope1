package com.lgy.item_jdbc_oracle.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.item_jdbc_oracle.DAO.ItemDAO;
import com.lgy.item_jdbc_oracle.DTO.ItemDTO;

public class ItemContentService {


	public void excute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String boardNo = request.getParameter("boardNo");
		
		ItemDAO dao=new ItemDAO();
//		게시글 하나의 내용을 BoardDTO 객체로 받음(boardNo(글번호) 를 넘겨서 select 쿼리 처리)
		ItemDTO dto = dao.contentView(boardNo);
//		dto 객체를 모델에 추가(뷰에서 꺼내 사용할수 있음)
		model.addAttribute("content_view", dto);
	}

}
