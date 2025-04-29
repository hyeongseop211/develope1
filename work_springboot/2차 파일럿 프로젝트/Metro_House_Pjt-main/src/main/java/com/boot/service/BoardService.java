package com.boot.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.boot.dto.BoardDTO;
import com.boot.dto.CriteriaDTO;

public interface BoardService {
	public void boardWrite(HashMap<String, String> param);

	public ArrayList<BoardDTO> boardView(CriteriaDTO criteriaDTO);

	public BoardDTO boardDetailView(HashMap<String, String> param);

	public void boardHit(HashMap<String, String> param);

	public void boardModify(HashMap<String, String> param);

	public void boardDelete(HashMap<String, String> param);

	public boolean boardHasLiked(HashMap<String, String> param);

	public int boardAddLike(HashMap<String, String> param);

	public void boardRemoveLike(HashMap<String, String> param);

	public int getTotalCount(CriteriaDTO criteriaDTO);

}
