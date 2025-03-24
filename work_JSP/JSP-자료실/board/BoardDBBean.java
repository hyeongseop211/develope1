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
		String sql2 = "";
		int number;
		int id = board.getB_id();
		int ref = board.getB_ref();
		int step = board.getB_step();
		int level = board.getB_level();
		
		try {
			conn = getConnection();

//			글번호 최대값+1을 구함: null 일때는 1, 아니면 +1
			sql="select max(b_id) from boardT";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				number = rs.getInt(1)+1;
			} else {
				number = 1;
			}
			
			System.out.println("@# id=>"+id);
			
//			1.글번호를 가지고 오는 경우(답변)
//			2.글번호를 가지고 오지 않는 경우(신규글)
			if (id != 0) {//글번호를 가지고 오는 경우(답변)
//				특정 조건에 step+1 로 업데이트
				sql2 = "update boardt set b_step=b_step+1 where b_ref=? and b_step > ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, step);
				pstmt.executeUpdate();
				
				step=step+1;
				level=level+1;
			} else {//글번호를 가지고 오지 않는 경우(신규글)
				ref = number;
				step=0;
				level=0;
			}
//			sql = "insert into boardt(b_id,b_name,b_email,b_title,b_content, b_date) values(?,?,?,?,?,?)";
//			sql = "insert into boardt(b_id,b_name,b_email,b_title,b_content, b_date, b_pwd) "
//			sql = "insert into boardt(b_id,b_name,b_email,b_title,b_content, b_date, b_pwd, b_ip) "
			sql = "insert into boardt(b_id,b_name,b_email,b_title,b_content, b_date, b_pwd, b_ip"
//					+ ", b_ref, b_step, b_level, b_fname, b_fsize) "
					+ ", b_ref, b_step, b_level, b_fname, b_fsize, b_rfname) "
//					+ "values((select nvl(max(b_id),0)+1 from boardT),?,?,?,?,?)";
//					+ "values((select nvl(max(b_id),0)+1 from boardT),?,?,?,?,?,?)";
//					+ "values((select nvl(max(b_id),0)+1 from boardT),?,?,?,?,?,?,?)";
//					+ "values((select nvl(max(b_id),0)+1 from boardT),?,?,?,?,?,?,?,?,?,?)";
//					+ "values((select nvl(max(b_id),0)+1 from boardT),?,?,?,?,?,?,?,?,?,?,?,?)";
					+ "values((select nvl(max(b_id),0)+1 from boardT),?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setInt(1, number);
			pstmt.setString(1, board.getB_name());
			pstmt.setString(2, board.getB_email());
			pstmt.setString(3, board.getB_title());
			pstmt.setString(4, board.getB_content());
			pstmt.setTimestamp(5, board.getB_date());
			pstmt.setString(6, board.getB_pwd());
			pstmt.setString(7, board.getB_ip());
			pstmt.setInt(8, ref);
			pstmt.setInt(9, step);
			pstmt.setInt(10, level);
			pstmt.setString(11, board.getB_fname());
			pstmt.setInt(12, board.getB_fsize());
			pstmt.setString(13, board.getB_rfname());
			
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
	
//	public ArrayList<BoardBean> listBoard(){
	public ArrayList<BoardBean> listBoard(String pageNumber){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ResultSet pageSet=null;
		
		int dbCount=0;
		int absolutePage=1;
		
//		String sql = "select b_id,b_name,b_email,b_title,b_content from boardt order by b_id";
//		String sql = "select b_id, b_name, b_email, b_title, b_content, b_date, b_hit, b_pwd "
//		String sql = "select b_id, b_name, b_email, b_title, b_content, b_date, b_hit, b_pwd, b_ip "
		String sql = "select b_id, b_name, b_email, b_title, b_content, b_date, b_hit, b_pwd, b_ip"
				+ ", b_ref, b_step, b_level, b_fname, b_fsize "
//				   + "from boardt order by b_id";
				   + "from boardt order by b_ref desc, b_step asc";
		String sql2 = "select count(b_id) from boardt";
		
		ArrayList<BoardBean> boardList=new ArrayList<BoardBean>();
		
		try {
			conn = getConnection();
//			stmt = conn.createStatement();
//			TYPE_SCROLL_SENSITIVE=>SCROLL도 가능하면서 변경된 사항도 적용됨 
//			CONCUR_UPDATABLE=>커서의 위치에서 정보 업데이트 가능
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pageSet = stmt.executeQuery(sql2);
			
			if (pageSet.next()) {
				dbCount = pageSet.getInt(1);
				pageSet.close();
			}
			
//			BoardBean.pageSize : 10
			if (dbCount % BoardBean.pageSize == 0) {
//				ex> dbCount:80=>8페이지
				BoardBean.pageCount = dbCount / BoardBean.pageSize;
			} else {
//				ex> dbCount:84=>9페이지
				BoardBean.pageCount = dbCount / BoardBean.pageSize + 1;
			}
			
			if (pageNumber != null) {
				BoardBean.pageNum = Integer.parseInt(pageNumber);
//				1: 0*10+1=1, 2: 1*10+1=11
				absolutePage = (BoardBean.pageNum - 1) * BoardBean.pageSize + 1;
			}
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				rs.absolute(absolutePage);
				int count=0;
//				while (rs.next()) {
				while (count < BoardBean.pageSize) {
					BoardBean board = new BoardBean();
					
//					쿼리 결과를 BoardBean 객체에 담아서 ArrayList 에 저장
					board.setB_id(rs.getInt(1));
					board.setB_name(rs.getString(2));
					board.setB_email(rs.getString(3));
					board.setB_title(rs.getString(4));
					board.setB_content(rs.getString(5));
					board.setB_date(rs.getTimestamp(6));
					board.setB_hit(rs.getInt(7));
					board.setB_pwd(rs.getString(8));
					board.setB_ip(rs.getString(9));
					board.setB_ref(rs.getInt(10));
					board.setB_step(rs.getInt(11));
					board.setB_level(rs.getInt(12));
					board.setB_fname(rs.getString(13));
					board.setB_fsize(rs.getInt(14));
//					여기까지가 1행을 가져와서 저장
					
//					행의 데이터를 ArrayList 에 저장
					boardList.add(board);
					
					if (rs.isLast()) {
						break;
					} else {
						rs.next();
					}
					
					count++;
				}
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
	
//	public BoardBean getBoard(int bid) {
//	hitadd : 참일때만 조회수 증가
	public BoardBean getBoard(int bid, boolean hitadd) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
//		String sql = "select b_id,b_name,b_email,b_title,b_content,b_date from boardt where b_id=?";
		String sql = "";
		BoardBean board=null;
		
		try {
			conn = getConnection();
			
			if (hitadd) {
//			조회수 1증가 SQL
				sql = "update boardt set b_hit=b_hit+1 where b_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bid);
				pstmt.executeUpdate();
			}
			
//			글내용 보기
//			sql = "select b_id, b_name, b_email, b_title, b_content, b_date, b_hit, b_pwd "
//			sql = "select b_id, b_name, b_email, b_title, b_content, b_date, b_hit, b_pwd, b_ip "
			sql = "select b_id, b_name, b_email, b_title, b_content, b_date, b_hit, b_pwd, b_ip"
//					+ ", b_ref, b_step, b_level, b_fname, b_fsize "
					+ ", b_ref, b_step, b_level, b_fname, b_fsize, b_rfname "
				+ "from boardt where b_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				board = new BoardBean();
				
				board.setB_id(rs.getInt(1));
				board.setB_name(rs.getString(2));
				board.setB_email(rs.getString(3));
				board.setB_title(rs.getString(4));
				board.setB_content(rs.getString(5));
				board.setB_date(rs.getTimestamp(6));
				board.setB_hit(rs.getInt(7));
				board.setB_pwd(rs.getString(8));
				board.setB_ip(rs.getString(9));
				board.setB_ref(rs.getInt(10));
				board.setB_step(rs.getInt(11));
				board.setB_level(rs.getInt(12));
				board.setB_fname(rs.getString(13));
				board.setB_fsize(rs.getInt(14));
				board.setB_rfname(rs.getString(15));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return board;
	}
	
	public int deleteBoard(int b_id, String b_pwd) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "";
		String pwd = "";
		int re=-1;
		
		try {
			conn = getConnection();
			
//			글번호로 비밀번호 조회
			sql = "select b_pwd "
					+ "from boardt where b_id=?";
			pstmt = conn.prepareStatement(sql);
//			쿼리 파라미터는 메소드 매개변수
			pstmt.setInt(1, b_id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {//비밀번호가 있으면 참
//				쿼리결과에서 b_pwd 컬럼 데이터
				pwd = rs.getString(1);
				
				if (pwd.equals(b_pwd)) {//비밀번호가 일치
//					삭제 쿼리 실행
					sql = "delete from boardt where b_id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, b_id);
					//정상적으로 삭제: 1
					re = pstmt.executeUpdate();					
				} else {
					//삭제 안됨
					re = 0;
				}
			}
		} catch (Exception e) {
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
	
//	수정할 내용을 BoardBean 타입의 객체로 받는다.
	public int editBoard(BoardBean board) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "";
		String pwd = "";
		int re=-1;
		
		try {
			conn = getConnection();
			
//			글번호로 비밀번호 조회
			sql = "select b_pwd "
					+ "from boardt where b_id=?";
			pstmt = conn.prepareStatement(sql);
//			쿼리 파라미터는 메소드 매개변수
			pstmt.setInt(1, board.getB_id());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {//비밀번호가 있으면 참
//				쿼리결과에서 b_pwd 컬럼 데이터
				pwd = rs.getString(1);
				
				if (pwd.equals(board.getB_pwd())) {//비밀번호가 일치
//					수정 쿼리 실행
					sql = "update boardt set b_name=?, b_email=?, b_title=?, b_content=? where b_id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, board.getB_name());
					pstmt.setString(2, board.getB_email());
					pstmt.setString(3, board.getB_title());
					pstmt.setString(4, board.getB_content());
					pstmt.setInt(5, board.getB_id());
					re = pstmt.executeUpdate();					
				} else {
					//수정 안됨
					re = 0;
				}
			}
		} catch (Exception e) {
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
	
	public BoardBean getFileName(int bid) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "select b_fname, b_rfname from boardt where b_id=?";
		BoardBean board=null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			
//			첨부파일이 있으면
			if (rs.next()) {
				board = new BoardBean();
				
				board.setB_fname(rs.getString(1));
				board.setB_rfname(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return board;
	}
}
















