function check_ok(){
	if(reg_frm.b_name.value.length == 0){
		alert("이름을 써주세요.");
		reg_frm.b_name.focus();
		return;
	}	
	if(reg_frm.b_title.value.length == 0){
		alert("제목을 써주세요.");
		reg_frm.b_title.focus();
		return;
	}	
	if(reg_frm.b_content.value.length == 0){
		alert("내용을 써주세요.");
		reg_frm.b_content.focus();
		return;
	}	
	if(reg_frm.b_pwd.value.length == 0){
		alert("비밀번호를 써주세요.");
		reg_frm.b_pwd.focus();
		return;
	}	
	
	//	폼이름이 reg_frm 에서 action 속성의 파일을 호출
	document.reg_frm.submit();
}

function delete_ok(){
	if(del_frm.b_pwd.value.length == 0){
		alert("비밀번호를 써주세요.");
		del_frm.b_pwd.focus();
		return;
	}	
	
	document.del_frm.submit();
}


