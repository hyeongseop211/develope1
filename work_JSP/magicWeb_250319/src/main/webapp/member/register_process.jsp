<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    
    // 폼에서 전송된 데이터 받기
    String userId = request.getParameter("userId");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String address = request.getParameter("address");
    /* (String)session.setAttribute("userId");  */
    Connection conn = null;
    PreparedStatement pstmt = null;
    
    try {
        // JDBC 드라이버 로드
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        // 데이터베이스 연결
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbId = "scott";
        String dbPw = "tiger";
        
        conn = DriverManager.getConnection(url, dbId, dbPw);
        
        // SQL 쿼리 준비
        String sql = "INSERT INTO memberT (mem_uid, mem_pwd, mem_name, mem_email, mem_address) VALUES (?, ?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        
        // 파라미터 설정
        pstmt.setString(1, userId);
        pstmt.setString(2, password);
        pstmt.setString(3, name);
        pstmt.setString(4, email);
        pstmt.setString(5, address);
        
        // 쿼리 실행
        pstmt.executeUpdate();
        
        // 회원가입 성공 시 로그인 페이지로 리다이렉트
        response.sendRedirect("login.html");
        
    } catch(Exception e) {
        e.printStackTrace();
        // 에러 발생 시 에러 메시지 출력
        out.println("<script>alert('회원가입 중 오류가 발생했습니다.'); history.back();</script>");
    } finally {
        // 리소스 해제
        if(pstmt != null) try { pstmt.close(); } catch(Exception e) {}
        if(conn != null) try { conn.close(); } catch(Exception e) {}
    }
%>