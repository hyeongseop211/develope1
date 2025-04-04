package com.lgy.item_mybatis_oracle.dao;

import java.util.ArrayList;



public interface ItemDAO {
	public void write(String NAME, String PRICE, String DESCRIPTION);
	public ArrayList<ItemDAO> list();
		
	/*
		
	
	
	
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
	*/
}
