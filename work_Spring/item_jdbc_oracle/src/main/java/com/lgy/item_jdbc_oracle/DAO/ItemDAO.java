package com.lgy.item_jdbc_oracle.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.lgy.item_jdbc_oracle.DTO.ItemDTO;
import com.lgy.item_jdbc_oracle.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemDAO {

	JdbcTemplate template = null;
	
	public ItemDAO() {
		template = Constant.template;
	}
	
	public void write(String NAME, String PRICE, String DESCRIPTION) {
		
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql="insert into ITEM(NAME, PRICE"
						+ ", DESCRIPTION) values(?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, NAME);
				pstmt.setString(2, PRICE);
				pstmt.setString(3, DESCRIPTION);
				
				return pstmt;
			}
		});
	}
	
	public ArrayList<ItemDTO> list(){
		String sql="select NAME, PRICE, DESCRIPTION from ITEM";
		return (ArrayList<ItemDTO>) template.query(sql, new 
				BeanPropertyRowMapper(ItemDTO.class));
		
		
	
	}

	public ItemDTO contentView(String boardNo) {
		return null;
	}
}
