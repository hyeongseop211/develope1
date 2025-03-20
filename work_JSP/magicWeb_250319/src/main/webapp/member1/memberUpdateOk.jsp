<%@page import="magic.member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="member" class="magic.member.MemberBean"></jsp:useBean>
<jsp:setProperty property="*" name="member"/>
<% 
	//회원정보를 가지고 가서 업데이트(화면에서 넘어옴)
	//보류-회원아이디를 가지고 가서 회원정보를 가져옴
	String userId = (String) session.getAttribute("userId");
	member.setMem_uid(userId);	

	MemberDBBean manager = MemberDBBean.getInstance();
	int re = manager.updateMember(member);
	
	if(re == 1){
		%>
			<script>
				alert("입력하신 대로 회원 정보가 수정되었습니다.");
				location.href="main.jsp";
			</script>
		<%
	}else{
		%>
			<script>
				alert("수정이 실패했습니다.");
				history.go(-1);
			</script>
		<%
	}
%>