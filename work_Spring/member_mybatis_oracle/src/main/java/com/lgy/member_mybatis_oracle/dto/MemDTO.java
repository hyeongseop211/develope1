package com.lgy.member_mybatis_oracle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemDTO {
	private String mem_uid;
	private String mem_pwd;
	private String mem_name;
}
