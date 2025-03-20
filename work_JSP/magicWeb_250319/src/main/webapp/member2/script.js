function check_ok(){
	// 폼 이름에 name 값으로 찾아감
	if(reg_frm.mem_uid.value==""){
		alert("아이디를 써주세요.");
		reg_frm.mem_uid.focus();
		return;
	}
	if(reg_frm.mem_uid.value.length < 4){
		alert("아이디는 4글자 이상이어야 합니다.");
		reg_frm.mem_uid.focus();
		return;
	}
	if(reg_frm.mem_pwd.value.length == 0){//length==0, value="": 같은 결과 
		alert("패스워드는 반드시 입력해야 합니다.");
		reg_frm.mem_uid.focus();
		return;
	}
	if(reg_frm.mem_pwd.value != reg_frm.mem_pwd_check.value){ 
		alert("패스워드가 일치하지 않습니다.");
		reg_frm.mem_uid.focus();
		return;
	}
	if(reg_frm.mem_name.value.length == 0){
		alert("이름은 반드시 입력해야 합니다.");
		reg_frm.mem_uid.focus();
		return;
	}
	if(reg_frm.mem_email.value.length == 0){
		alert("이메일은 반드시 입력해야 합니다.");
		reg_frm.mem_uid.focus();
		return;
	}
	// 폼이름이 reg_frm에서 action 속성의 파일을 호출
	document.reg_frm.submit();
}
















