package com.lgy.item_jdbc_oracle.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDTO {
	private String NAME;
	private int PRICE;
	private String DESCRIPTION;
}
