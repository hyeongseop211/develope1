<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="processLogin.jsp" method="post">
			<table border="1" align="center">
				<tr height="30">
					<td width="100" align="center">사용자 ID</td>
					<td width="100">
						<input type="text" name="mem_uid">
					</td>
				</tr>
				<tr height="30">
					<td width="100" align="center">비밀번호</td>
					<td width="100">
						<input type="password" name="mem_pwd">
					</td>
				</tr>
				<tr height="30">
					<td colspan="2" width="100" align="center">
						<button type="submit">로그인</button>
						<button type="button" onclick="location.href='register.jsp'">회원가입</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>












