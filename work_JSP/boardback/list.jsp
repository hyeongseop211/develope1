<%@page import="magic.board.BoardBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="magic.board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDBBean db = BoardDBBean.getInstance();
//	호출된 메소드의 반환 타입으로 받아주면 됨
	ArrayList<BoardBean> boardList = db.listBoard();
	int b_id=0;
	String b_name,b_email,b_title,b_content;
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>게시판에 등록된 글 목록 보기</h1>
		<table width="600">
			<tr>
				<td align="right">
					<a href="write.jsp">글 쓰 기</a>
				</td>
			</tr>
		</table>
	</center>
	<center>
		<table border="1" width="800" cellspacing="0">
			<tr height="25">
				<td width="40" align="center">번호</td>
				<td width="450" align="center">글제목</td>
				<td width="120" align="center">작성자</td>
			</tr>
			<%
// 			boardList 에 있는 오라클 데이터를 가져옴
				for(int i=0; i<boardList.size(); i++){
//	 				ArrayList 데이터의 BoardBean 객체를 가져온다.
					BoardBean board = boardList.get(i);
//	 				board 객체에 있는 컬럼의 데이터를 가져온다.
					b_id = board.getB_id();
					b_name = board.getB_name();
					b_email = board.getB_email();
					b_title = board.getB_title();
					b_content = board.getB_content();
			%>
			<tr bgcolor="#f7f7f7" 
				onmouseover="this.style.backgroundColor='#eeeeef'"
				onmouseout="this.style.backgroundColor='##f7f7f7'">
				<!-- 			표현식으로 컬럼의 데이터를 출력 -->
				<td align="center"><%= b_id %></td>
				<td><%= b_title %></td>
				<td align="center">
					<a href="mailto:<%= b_email %>">
						<%= b_name %>
					</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</center>
</body>
</html>












