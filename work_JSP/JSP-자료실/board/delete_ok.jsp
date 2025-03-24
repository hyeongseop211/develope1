<%@page import="java.io.File"%>
<%@page import="magic.board.BoardBean"%>
<%@page import="magic.board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String pageNum = request.getParameter("pageNum");

//	글번호와 비밀번호를 받아서 변수에 저장
	int b_id = Integer.parseInt(request.getParameter("b_id"));
	String b_pwd = request.getParameter("b_pwd");
	
	BoardDBBean db = BoardDBBean.getInstance();
	
// 	파일삭제를 위한 처리
	BoardBean board = db.getBoard(b_id, false);
	String fName = board.getB_fname();
	String up="C:\\develop\\work_java\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\magicWeb_250319\\upload";
	
// 	글삭제를 위해서 글번호와 비밀번호를 가지고 메소드 호출
	int re = db.deleteBoard(b_id, b_pwd);

	if(re == 1){
		//파일 삭제
		if(fName != null){
			File file=new File(up+fName);
			file.delete();
		}
		
		//비밀번호 일치로 글목록 이동
		response.sendRedirect("list.jsp?pageNum="+pageNum);
	}else if(re == 0){
		//비밀번호 틀림
%>
		<script>
			alert("비밀번호가 맞지 않습니다.");
			history.go(-1);
		</script>
<%
	}else if(re == -1){
		//삭제 실패
%>
		<script>
			alert("삭제에 실패하였습니다.");
			history.go(-1);
		</script>
<%
	}
%>






