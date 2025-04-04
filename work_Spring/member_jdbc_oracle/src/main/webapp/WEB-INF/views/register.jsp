<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<form method="post" action="registerOk">
			<tr height="50">
				<td colspan="2">
					<h1>회원 가입 신청</h1>
				</td>
			</tr>
			<tr height="50">
				<td width="80">
					user ID
				</td>
				<td>
					<input type="text" size="20" name="mem_uid">
				</td>
			</tr>
			<tr height="50">
				<td width="80">
					user PW
				</td>
				<td>
					<input type="text" size="20" name="mem_pwd">
				</td>
			</tr>
			<tr height="50">
				<td width="80">
					user Name
				</td>
				<td>
					<input type="text" size="20" name="mem_name">
				</td>
			</tr>
			<tr height="50">
				<td colspan="2">
					<input type="submit" value="등록">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>