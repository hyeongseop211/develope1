package magic.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
		int number;
		
		try {
			conn = getConnection();

			sql="select max(b_id) from boardT";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				number = rs.getInt(1)+1;
			} else {
				number = 1;
			}
			
			sql = "insert into boardt(b_id,b_name,b_email,b_title,b_content) values(?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, number);
			pstmt.setString(2, board.getB_name());
			pstmt.setString(3, board.getB_email());
			pstmt.setString(4, board.getB_title());
			pstmt.setString(5, board.getB_content());
			
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
		String sql = "select b_id,b_name,b_email,b_title,b_content from boardt order by b_id";
		ArrayList<BoardBean> boardList=new ArrayList<BoardBean>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				BoardBean board = new BoardBean();
				
//				쿼리 결과를 BoardBean 객체에 담아서 ArrayList 에 저장
				board.setB_id(rs.getInt(1));
				board.setB_name(rs.getString(2));
				board.setB_email(rs.getString(3));
				board.setB_title(rs.getString(4));
				board.setB_content(rs.getString(5));
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
}
















