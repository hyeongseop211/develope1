function check_ok() {
    if (document.registerForm.userId.value.length < 4) {
        alert("아이디를 써주세요");
        document.registerForm.userId.focus();
        return false;
    }
    if (document.registerForm.userId.value.length < 4) {
        alert("아이디는 4글자이상이어야 합니다.");
        document.registerForm.userId.focus();
        return false;
    }
    if (document.registerForm.password.value == "") {
        alert("패스워드는 반드시 입력해야 합니다.");
        document.registerForm.password.focus();
        return false;
    }
    if (document.registerForm.password.value != document.registerForm.password_confirm.value) {
        alert("패스워드가 일치하지 않습니다.");
        document.registerForm.password_confirm.focus();
        return false;
    }
    if (document.registerForm.name.value == "") {
        alert("이름을 써주세요.");
        document.registerForm.name.focus();
        return false;
    }
    if (document.registerForm.email.value == "") {
        alert("Email을 써주세요.");
        document.registerForm.email.focus();
        return false;
    }
    return true;
}
