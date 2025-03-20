<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	if(session.getAttribute("Member") == null){
    		%>
    			<jsp:forward page="login.jsp"></jsp:forward>
    		<%
    	}
    %>
    <%
    String userId = (String) session.getAttribute("userId");
    String userName = (String) session.getAttribute("userName");
    request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 성공</title>
</head>
<body>
    <table border="1" align="center">
    	<form method="post" action="Logout.jsp">
    		<tr height="30">
    			<td>
    				안녕하세요. <%= userName %>(<%= userId %>)님
    			</td>
    		</tr>
    		<tr height="30">
    			<td align="center">
    				<input type="submit" value="로그아웃">
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="button" value="회원정보변경" onclick="location='memberUpdate.jsp'">
    			</td>
    		</tr>
    	</form>
    </table>

</body>
</html>