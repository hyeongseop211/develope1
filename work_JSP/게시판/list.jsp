<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="magic.board.BoardBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="magic.board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     	BoardDBBean db = BoardDBBean.getInstance();
    // 호출된 메소드의 반환 타입으로 받아주면 됨
    	ArrayList<BoardBean> boardList = db.listBoard();
    	int bod_id=0;
    	int bod_hit=0;
    	int bod_level=0;
    	String bod_name ,bod_email,bod_title,bod_content;
    	
    	Timestamp bod_date;
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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
				<td width="130" align="center">작성일</td>
				<td width="80" align="center">조회수</td>
			</tr>
			<%
			//boardList에 있는 오라클 데이터를 가져옴
				for(int i=0; i<boardList.size(); i++){
				//	ArrayList 테이터의 BoardBean 객체를 가져온다
					BoardBean board = boardList.get(i);
					bod_id = board.getBod_id();
					bod_name = board.getBod_name();
					bod_email = board.getBod_email();
					bod_title = board.getBod_title();
					bod_content = board.getBod_content();
					bod_date = board.getBod_date();
					bod_hit =board.getBod_hit();
					bod_level =board.getBod_level();
			%>
			<tr bgcolor="f7f7f7" 
			onmouseover="this.style.backgroundColor='#eeeeef'"
			onmouseout="this.style.backgroundColor='##f7f7f7'">
				<td align="center"><%= bod_id %></td>
				<td>
					<%
					// bod_level 기준으로 화살표 이미지를 들여쓰기로 출력
						if(bod_level > 0){//답변글
							for(int j=0; j<bod_level; j++){// for 기준으로 들여쓰기를 얼마만큼 할것인지 정함
								%>
									&nbsp;
								<%
							}
						// 들여쓰기가 적용된 시점 -> 이미지 추가
						%>
							<img src="./images/AnswerLine.gif" width="16" height="16">
						<%
						}
					%>
					<a href="show.jsp?bod_id=<%= bod_id %>">
						<%= bod_title %>
					</a>
				</td>	
				<td align="center">
					<a href="malito:<%= bod_email %>">
						<%= bod_name %>
					</a>
				</td>	
				<td align="center">
					<%= bod_date %>
					<%-- <%= sdf.format(bod_date) %> --%>
				</td>
				<td align="center">
					<%= bod_hit %>
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</center>
</body>
</html>








