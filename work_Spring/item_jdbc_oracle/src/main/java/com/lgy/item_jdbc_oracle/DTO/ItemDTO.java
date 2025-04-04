package com.lgy.item_jdbc_oracle.DTO;

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
