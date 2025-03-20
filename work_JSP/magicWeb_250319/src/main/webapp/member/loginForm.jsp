<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String userId = (String) session.getAttribute("userId");
    request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 성공</title>
</head>
<body>
    <h2><%= userId %> 님 환영합니다!</h2>
    <hr>
    <h3>회원 목록</h3>
    <table border="1">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>이메일</th>
            <th>주소</th>
        </tr>
        <%
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                String url = "jdbc:oracle:thin:@localhost:1521:xe";
                String dbId = "scott";
                String dbPw = "tiger";
                
                conn = DriverManager.getConnection(url, dbId, dbPw);
                
                String sql = "SELECT mem_uid, mem_name, mem_email, mem_address FROM memberT ORDER BY mem_uid";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                
                while(rs.next()) {
        %>
                    <tr>
                        <td><%=rs.getString("mem_uid")%></td>
                        <td><%=rs.getString("mem_name")%></td>
                        <td><%=rs.getString("mem_email")%></td>
                        <td><%=rs.getString("mem_address")%></td>
                    </tr>
        <%
                }
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                if(rs != null) try { rs.close(); } catch(Exception e) {}
                if(pstmt != null) try { pstmt.close(); } catch(Exception e) {}
                if(conn != null) try { conn.close(); } catch(Exception e) {}
            }
        %>
    </table>
    <br>
    <a href="login.html">로그아웃</a>
</body>
</html>