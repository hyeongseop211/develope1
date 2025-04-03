package com.lgy.item_oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lgy.item_oracle.dto.ItemDTO;


public class ItemDAO {

	DataSource dataSource;
	
	public ItemDAO() {
//		dbcp 방식으로 db 연결
		try {
			Context ctx = new InitialContext();
//			context.xml 에 설정(server.xml 과 달리 한번 설정으로 모든 프로젝트에서 사용가능)
//			dataSource : 조회,저장,수정,삭제 쿼리에 모두 사용 가능
			dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시판 목록 조회(type parameter : 게시글 객체)
	public void write(String NAME, String PRICE, String DESCRIPTION) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into ITEM(NAME, PRICE"
				+ ", DESCRIPTION) values(?,?,?)";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, NAME);
			pstmt.setString(2, PRICE);
			pstmt.setString(3, DESCRIPTION);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public ArrayList<ItemDTO> list(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		String sql="select NAME, PRICE, DESCRIPTION from ITEM";
		ArrayList<ItemDTO> dtos = new ArrayList<>();
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String NAME = rs.getString("NAME");
				int PRICE = rs.getInt("PRICE");
				String DESCRIPTION = rs.getString("DESCRIPTION");
				
				//			하나의 게시글 객체
				ItemDTO dto = new ItemDTO(NAME, PRICE, DESCRIPTION);
//			게시글을 추가(dtos : 여러 게시글이 될수 있음)
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	

}
