<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="magic.board.BoardBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="magic.board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="magic.board.BoardBean" id="board"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>
<%
	board.setBod_date(new Timestamp(System.currentTimeMillis()));

// 자바 클래스 이용해서 ip추가
	InetAddress address = InetAddress.getLocalHost();
// getHostAddress : ip 주소 가져오는 메소드
	String ip = address.getHostAddress();
// 0:0:0:0:0:0:0:1
//	board.setBod_ip(request.getRemoteAddr());
	board.setBod_ip(ip); //192.168.10.24
	
	BoardDBBean db = BoardDBBean.getInstance();
	
	//db.insertBoard(board);
	
	if(db.insertBoard(board) == 1){//글쓰기가 정상적으로 완료시
		response.sendRedirect("list.jsp");
	}else{//글쓰기가 실패시
		response.sendRedirect("write.jsp");
	}
%>
<!-- // 클라이언트 IP 주소 가져오기
    String userIP = request.getRemoteAddr();
    
    // DB에 저장하는 예시 (실제 쿼리는 테이블 구조에 맞게 수정 필요)
    String sql = "INSERT INTO board (ip_address, ...) VALUES (?, ...)";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, userIP);
    // 다른 필드 설정...
    pstmt.executeUpdate(); -->