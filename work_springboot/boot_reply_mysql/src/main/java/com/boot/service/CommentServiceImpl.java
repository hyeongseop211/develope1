package com.boot.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.*;
import com.boot.dto.*;

@Service("CommentService")
public class CommentServiceImpl implements CommentService{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void save(HashMap<String, String> param) {
		CommentDAO dao=sqlSession.getMapper(CommentDAO.class);
		dao.save(param);
	}

	@Override
	public ArrayList<CommentDTO> findAll(HashMap<String, String> param){
		CommentDAO dao=sqlSession.getMapper(CommentDAO.class);
		ArrayList<CommentDTO> list = dao.findAll(param);
		return list;
	}

}




