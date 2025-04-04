package com.lgy.board_mybatis_mysql.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.board_mybatis_mysql.dao.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	/*
	BoardService service;
	public JdbcTemplate template;
	
//	servlet-context.xml 에 있는 template 객체를 저장(this.template)
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
//		Constant.template 를 dao 에서 사용
		Constant.template = this.template;
	}
	*/
	
//	servlet-context에 있는 sqlSession 객체 연결
	@Autowired
	private SqlSession sqlSession;
	@RequestMapping("/list")
	public String list(Model model) {
		log.info("@# list()");
		
//		service=new BoardListService();
//		service.excute(model);
		
//		getMapper = dao 로 연결
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		서비스단에서 처리했던 것을 컨트롤러 단에서 처리
		model.addAttribute("list", dao.list());
		
		return "list";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write()");
		
		model.addAttribute("request", request);
		
//		service=new BoardWriteService();
//		service.excute(model);
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		서비스단에서 처리했던 것을 컨트롤러 단에서 처리
		dao.write(request.getParameter("boardName"), request.getParameter("boardTitle"), request.getParameter("boardContent"));
		
		return "redirect:list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		log.info("@# content_view()");
		
		model.addAttribute("request", request);
		
//		service=new BoardContentService();
//		service.excute(model);
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		서비스단에서 처리했던 것을 컨트롤러 단에서 처리
		model.addAttribute("content_view", dao.contentView(request.getParameter("boardNo")));
		
		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		log.info("@# modify()");
		
		model.addAttribute("request", request);
		
//		service=new BoardModifyService();
//		service.excute(model);
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		서비스단에서 처리했던 것을 컨트롤러 단에서 처리
		dao.modify(request.getParameter("boardNo"), 
				request.getParameter("boardName"),
				request.getParameter("boardTitle"),
				request.getParameter("boardContent"));
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		log.info("@# delete()");
		
		model.addAttribute("request", request);
		
//		service=new BoardDeleteService();
//		service.excute(model);
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		서비스단에서 처리했던 것을 컨트롤러 단에서 처리
		dao.delete(request.getParameter("boardNo"));
		
		return "redirect:list";
	}
}






