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
	BoardDBBean db = BoardDBBean.getInstance();
	
	//db.insertBoard(board);
	
	if(db.insertBoard(board) == 1){//글쓰기가 정상적으로 완료시
		response.sendRedirect("list.jsp");
	}else{//글쓰기가 실패시
		response.sendRedirect("write.jsp");
	}
%>