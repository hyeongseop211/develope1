package com.lgy.member_mybatis_oracle.dao;

import java.util.ArrayList;

import com.lgy.member_mybatis_oracle.dto.MemDTO;

public interface MemDAO {
	public ArrayList<MemDTO> loginYn(String id, String pw);
	public void write(String mem_uid, String mem_pwd, String mem_name);
	
	/*
	JdbcTemplate template=null;
	
	public MemDAO() {
//		Constant.template : 컨트롤러에서 설정됨
		template = Constant.template;
	}
	
//	public int loginYn(String id, String pw) {
	public ArrayList<MemDTO> loginYn(String id, String pw) {
//		String sql="select mem_pwd from mvc_member where mem_uid="+id;
		String sql="select mem_pwd from mvc_member where mem_uid='"+id+"'";
		return (ArrayList<MemDTO>) template.query(sql, new BeanPropertyRowMapper(MemDTO.class));
	}
	
	public void write(final String mem_uid, final String mem_pwd, final String mem_name) {
		log.info("@# MemDAO mem_uid=>"+mem_uid);
		log.info("@# MemDAO mem_pwd=>"+mem_pwd);
		log.info("@# MemDAO mem_name=>"+mem_name);
		
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql="insert into mvc_member(mem_uid, mem_pwd"
						+ ", mem_name) values(?,?,?)";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1, mem_uid);
				pstmt.setString(2, mem_pwd);
				pstmt.setString(3, mem_name);
				return pstmt;
			}
		});
	}
	*/
}







