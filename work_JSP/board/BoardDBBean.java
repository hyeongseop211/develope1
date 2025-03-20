package magic.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import magic.member.MemberBean;
import magic.member.MemberDBBean;

public class BoardDBBean {
	private static BoardDBBean instance=new BoardDBBean();
	
	public static BoardDBBean getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		return ((DataSource)(new InitialContext().lookup("java:comp/env/jdbc/oracle"))).getConnection();
	}
	
	public int insertBoard(BoardBean board) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int re=-1;//초기값 -1, insert 정상적으로 실행되면 1
//		String sql = "insert into boardt values(?,?,?,?)";
		String sql = "";
		int number=0;
		
		try {
			
			  conn = getConnection();
		  
		  sql="select max(B_ID) from boardT";
		  pstmt = conn.prepareStatement(sql); 
		  rs = pstmt.executeQuery();
			  
			  if (rs.next()) { number = rs.getInt(1)+1; } else { number = 1; }
			 
			
			  sql = "insert into boardt(B_ID,B_NAME,B_EMAIL,B_TITLE,B_CONTENT,B_DATE) "
			  		+ "values(?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, number);
			pstmt.setString(2, board.getBod_name());
			pstmt.setString(3, board.getBod_email());
			pstmt.setString(4, board.getBod_title());
			pstmt.setString(5, board.getBod_content());
			pstmt.setTimestamp(6, board.getBod_date());
			
			re = pstmt.executeUpdate();
			System.out.println("추가 성공");
		} catch (Exception e) {
			System.out.println("추가 실패");
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return re;
	}
	
	public ArrayList<BoardBean> listBoard(){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql = "select B_ID,B_NAME,B_EMAIL,B_TITLE,B_CONTENT,B_DATE from boardT order by B_ID";
		ArrayList<BoardBean> boardList=new ArrayList<BoardBean>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				BoardBean board = new BoardBean();
				
//				쿼리 결과를 BoardBean 객체에 담아서 ArrayList 에 저장
				board.setBod_id(rs.getInt(1));
				board.setBod_name(rs.getString(2));
				board.setBod_email(rs.getString(3));
				board.setBod_title(rs.getString(4));
				board.setBod_content(rs.getString(5));
				board.setBod_date(rs.getTimestamp(6));
//				여기까지가 1행을 가져와서 저장
				
//				행의 데이터를 ArrayList 에 저장
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return boardList;
	}
	 public BoardBean getBoard(int bid) {

	        Connection conn = null;
	        PreparedStatement pstmt=null;
	        ResultSet rs = null;
	        String sql ="SELECT B_ID,B_NAME ,B_EMAIL,B_TITLE,B_CONTENT,B_DATE from boardT where B_ID=?";
	        ArrayList<BoardBean> boardList = new ArrayList<BoardBean>();
	        BoardBean board=null;
	        
	        try {
	            conn = getConnection();  // DB 연결 메소드 호출 필요
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, bid);
	            rs = pstmt.executeQuery();
	            
	            if (rs.next()) {  // 아이디가 일치하는 로우 존재
	            	board = new BoardBean();
	            	
	            	board.setBod_id(rs.getInt(1));
	            	board.setBod_name(rs.getString(2));
	            	board.setBod_email(rs.getString(3));
	            	board.setBod_title(rs.getString(4));
	            	board.setBod_content(rs.getString(5) );
	            	board.setBod_date(rs.getTimestamp(6));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (pstmt != null) pstmt.close();
	                if (conn != null) conn.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return board;
	    
	    
	    }
}
















