<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 가입 신청</title>
    <script type="text/javascript" src="script.js"></script>
</head>
<body>
    <form name="registerForm" action="register_process.jsp" method="post" onsubmit="return check_ok()">
        <table border="1">
            <tr>
                <td colspan="2" align="center"><h2>회원 가입 신청</h2><br>* 표시 항목은 필수 입력 항목입니다.</td>
            </tr>
            <tr>
                <td>User ID</td>
                <td><input type="text" name="userId" size="20">*</td>
            </tr>
            <tr>
                <td>암호</td>
                <td><input type="password" name="password" size="20">*</td>
            </tr>
            <tr>
                <td>암호 확인</td>
                <td><input type="password" name="password_confirm" size="20">*</td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="name" size="20">*</td>
            </tr>
            <tr>
                <td>E-mail</td>
                <td><input type="text" name="email" size="30">*</td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" name="address" size="40"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="등록" onclick="check_ok">
                    <input type="reset" value="다시입력">
                    <input type="button" value="가입안함" onclick="location.href='login.html'">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
