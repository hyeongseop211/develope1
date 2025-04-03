package com.lgy.item_jdbc_oracle.DAO;

import java.lang.invoke.ConstantBootstraps;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.lgy.item_jdbc_oracle.DTO.ItemDTO;
import com.lgy.item_jdbc_oracle.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemDAO {

	JdbcTemplate template = null;
	DataSource dataSource;
	
	public ItemDAO() {
//		dbcp 방식으로 db 연결
//		try {
//			Context ctx = new InitialContext();
////			context.xml 에 설정(server.xml 과 달리 한번 설정으로 모든 프로젝트에서 사용가능)
////			dataSource : 조회,저장,수정,삭제 쿼리에 모두 사용 가능
//			dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		template = Constant.template;
	}
	
	//게시판 목록 조회(type parameter : 게시글 객체)
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
		return (ArrayList<ItemDTO>) template.query(sql, new BeanPropertyRowMapper(ItemDTO.class));
		
		
	
	}

	public ItemDTO contentView(String boardNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
