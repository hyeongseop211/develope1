package com.boot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// @NoArgsConstructor
public class Criteria {
	private int pageNum;//현재 페이지 번호
	private int amount;//한 페이지당 보여줄 게시글 수
	
	public Criteria() {
        this(1,10);
	}
}