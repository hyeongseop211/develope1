<%@page import="magic.board.BoardBean"%>
<%@page import="magic.board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    // request.getParameter("bod_id") :show.jsp에서 받음
    	int bod_id = Integer.parseInt(request.getParameter("bod_id"));
    
    	BoardDBBean db = BoardDBBean.getInstance();
//    	BoardBean board = db.getBoard(bod_id);
    	BoardBean board = db.getBoard(bod_id, false);
    %>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
 <script src="board.js" type="text/javascript" ></script>
</head>
<body>
	<center>
		<h1>글 수 정 하 기</h1>
    	<form method="post" action="edit_ok.jsp?bod_id=<%= bod_id%>" name="reg_frm">
    		<table>
    			<tr height="30">
    				<td width="80">작성자</td>
    				<td width="140">
    				<!-- maxlength : 화면단에서 데이터베이스 오류를 미리 방지 -->
    					<input type="text" name="bod_name" size="10" maxlength="20" value="<%= board.getBod_name() %>">
    				</td>
    				<td width="80">이메일</td>
    				<td width="240">
    					<input type="text" name="bod_email" size="24" maxlength="50" value="<%= board.getBod_email() %>">
    				</td>
    			</tr>
    			<tr height="30">
    				<td width="80">글제목</td>
    				<td colspan="3" width="460">
    					<input type="text" name="bod_title" size="55" maxlength="80" value="<%= board.getBod_title() %>">
    				</td>
    			</tr>
    			<tr>
    				<td colspan="4">
				        <textarea name="bod_content" rows="10" cols="65">
				        	<%= board.getBod_content() %>
				        </textarea>
    				</td>
    			</tr>
    			<tr height="30">
    				<td width="80">암&nbsp;&nbsp;호</td>
    				<td colspan="3" width="460">
    					<input type="password" name="bod_pwd" size="12" maxlength="12">
    				</td>
    			</tr>
    			<tr height="50">
    				<td colspan="4" align="center">
				        <input type="button" value="글수정" onclick="check_ok()">&nbsp;
				        <input type="reset" value="다시작성">
				        <input type="button" value="글목록" onclick="location.href='list.jsp'">&nbsp;
				      </td>
    			</tr>
    		</table>
    	</form>
	</center>
</body>
</html>
