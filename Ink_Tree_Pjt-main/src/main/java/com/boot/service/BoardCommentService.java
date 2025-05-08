package com.boot.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.boot.dto.BoardCommentDTO;
import com.boot.dto.CriteriaDTO;

public interface BoardCommentService {
	public ArrayList<BoardCommentDTO> bcView(HashMap<String, String> param, CriteriaDTO criteriaDTO);

	public int getTotalCount(HashMap<String, String> param);
	public int getAllCount(HashMap<String, String> param);

	public void bcWrite(HashMap<String, String> param);

	public void bcModify(HashMap<String, String> param);

	public void bcDelete(HashMap<String, String> param);
}
