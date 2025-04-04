package com.lgy.item_mybatis_oracle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
	private String NAME;
	private int PRICE;
	private String DESCRIPTION;
}
