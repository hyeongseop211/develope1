package com.lgy.member_jdbc_oracle.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.lgy.member_jdbc_oracle.DTO.memberDTO;
import com.lgy.member_jdbc_oracle.util.Constant;


@Repository
public class MemDAO {
	DataSource dataSource;
	JdbcTemplate template = null;

	public MemDAO() {
		template = Constant.template;
	}

//	public int loginYn(String id, String pw) {
	public ArrayList<memberDTO> loginYn(String id, String pw) {
		
		String sql= "select mem_pwd from MVC_MEMBER where mem_uid="+id;
		return (ArrayList<memberDTO>) template.query(sql, new BeanPropertyRowMapper(memberDTO.class));
		
	}
	public void write(final String MEM_UID, final String MEM_PWD, final String MEM_NAME) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql="insert into MVC_MEMBER(MEM_UID, MEM_PWD"
						+ ", MEM_NAME) values(?,?,?)";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1, MEM_UID);
				pstmt.setString(2, MEM_PWD);
				pstmt.setString(3, MEM_NAME);
				return pstmt;
			}
		}); 
			
	}
}
