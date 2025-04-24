package com.boot.dao;

import java.util.ArrayList;


import com.boot.dto.*;

public interface PageDAO {
	// Criteria 객체를 이용해서 페이징 처리
	public ArrayList<BoardDTO> listWithPaging(Criteria cri);
}















