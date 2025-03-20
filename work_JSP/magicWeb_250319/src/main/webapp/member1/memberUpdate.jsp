<%@page import="magic.member.MemberBean"%>
<%@page import="magic.member.MemberDBBean"%>
<%@page import="java.lang.reflect.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    String userId = (String) session.getAttribute("userId");
    String userName = (String) session.getAttribute("userName");
    String userAddress = (String) session.getAttribute("userAddress");
    request.setCharacterEncoding("UTF-8");
    MemberDBBean manager = MemberDBBean.getInstance();
    MemberBean member = manager.getMember(userId);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="script.js" type="text/javascript"></script>
</head>
<body>
	<table border="1" align="center">
		<form name="upd_frm" method="post" action="memberUpdateOk.jsp">
			<tr height="50">
				<td colspan="2" align="center">
					<h1>회원 정보 수정</h1>
					'*'표시 항목은 필수 입력 항목입니다.
				</td>
			</tr>
			<tr height="30">
				<td width="80">user ID</td>
				<td>
					<%= userId %>
				</td>
			</tr>
			<tr height="30">
				<td width="80">암호</td>
				<td>
					<input name="mem_pwd" type="password" size="20">*
				</td>
			</tr>
			<tr height="30">
				<td width="80">암호 확인</td>
				<td>
					<input name="pwd_check" type="password" size="20">*
				</td>
			</tr>
			<tr height="30">
				<td width="80">이  름</td>
				<td>
					<%= member.getMem_name() %>
				</td>
			</tr>
			<tr height="30">
				<td width="80">E-mail</td>
				<td>
					<input name="mem_email" type="text" size="30" value="<%= member.getMem_email() %>">*
				</td>
			</tr>
			<tr height="30">
				<td width="80">주 소</td>
				<td>
					<input name="mem_address" type="text" size="40" value="<%= member.getMem_address() %>">*
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" onclick="update_check_ok()">
					<input type="reset" value="다시입력" >
					<input type="button" value="수정안함" onclick="location.href='main.jsp'">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>