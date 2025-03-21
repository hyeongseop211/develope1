<%@page import="java.text.SimpleDateFormat"%>
<%@page import="magic.board.BoardBean"%>
<%@page import="magic.board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
   	int bid = Integer.parseInt(request.getParameter("bod_id"));
   BoardDBBean db = BoardDBBean.getInstance();
   // board 객체에 게시글의 정보가 저장되어 있음
   BoardBean board = db.getBoard(bid);
   %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>글 내 용 보 기</h1>
		<table border="1" width="600" cellspacing="0">
			<tr height="30" align="center">
				<td width="100">글번호</td>
				<td width="200">
					<%= bid %>
				</td>
				<td width="100">조회수</td>
				<td width="200">
					<%= board.getBod_hit() %>
				</td>
			</tr>
			<tr height="30" align="center">
				<td width="100">작성자</td>
				<td width="200">
					<%= board.getBod_name() %>
				</td>
				<td width="100">작성일</td>
				<td width="200">
					<%= sdf.format(board.getBod_date()) %>
					
				</td>
   			</tr>
			<tr height="30" align="center">
				<td width="100">글제목</td>
				<td width="200" align="left">
					<%= board.getBod_title() %>
				</td>
			</tr>
			<tr height="30" align="center">
				<td width="100">글내용</td>
				<td width="200" align="left">
					<%= board.getBod_content() %>
				</td>
			</tr>
			<tr height="30">
				<td colspan="4" align="right">
					<input type="button" value="글삭제" onclick="location.href='delete.jsp?bod_id=<%= bid%>'"> 
				</td>
			</tr>
		</table>
	</center>
</body>
</html>