package com.boot.service;

import java.util.ArrayList;

import com.boot.dto.*;

public interface PageService {
	public ArrayList<BoardDTO> listWithPaging(Criteria cri);
}
