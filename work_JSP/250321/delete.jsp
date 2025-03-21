<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int b_id = Integer.parseInt(request.getParameter("bod_id"));
%>
<html>
<head>
    <title>게시글 삭제</title>
    <script type="text/javascript" src="board.js"></script>
</head>
<body>
	<center>
	    <form method="post" action="delete_ok.jsp?bod_id=<%= b_id %>" name="del_frm">
	    	<h1>글 삭 제 하 기</h1>
	        <table>
	            <tr height="50">
	                <td colspan="2" align="left">
	                	<strong>
	                		>>암호를 입력하세요.<< 
	                	</strong>
	                </td>
	            </tr>
	            <tr height="50">
	                <td width="80">
	                	암 호
	                </td>
	                <td> 
	                	<input type="password" name="bod_pwd" size="12" maxlength="12">
	                </td>
	            </tr>
	            <tr height="50">
	                <td colspan="2" align="center">
	                    <input type="submit" value="글삭제" onclick="delete_ok()">
	                    &nbsp;&nbsp;&nbsp;
	                    <input type="reset" value="다시작성">
	                    &nbsp;&nbsp;&nbsp;
	                    <input type="button" value="글목록" onclick="location.href='list.jsp'">
	                </td>
	            </tr>
	        </table>
	    </form>
    </center>
</body>
</html>
