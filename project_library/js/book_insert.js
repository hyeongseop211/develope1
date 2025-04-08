    // 대분류에 따른 소분류 매핑
    const subCategories = {
        "소설": ["한국소설", "외국소설", "역사소설"],
        "과학": ["물리학", "화학", "생물학"],
        "인문": ["철학", "심리학", "종교"],
        "기술": ["컴퓨터", "전자", "기계"],
        "기타": ["에세이", "여행", "요리"]
    };

    function updateSubCategories() {
        const mainSelect = document.getElementById("mainCategory");
        const subSelect = document.getElementById("subCategory");
        const selectedMain = mainSelect.value;

        // 소분류 초기화
        subSelect.innerHTML = "";

        if (selectedMain && subCategories[selectedMain]) {
            subCategories[selectedMain].forEach(function(sub) {
                const option = document.createElement("option");
                option.value = sub;
                option.text = sub;
                subSelect.appendChild(option);
            });
        } else {
            const option = document.createElement("option");
            option.value = "";
            option.text = "소분류 없음";
            subSelect.appendChild(option);
        }
    }
    function fn_submit() {
    	// 폼 이름에 name 값으로 찾아감
	if(frm.bookTitle.value==""){
		alert("도서 제목을 입력하세요.");
		frm.bookTitle.focus();
		return;
	}
	if(frm.bookWrite.value==""){
		alert("작가 이름을 입력하세요.");
		frm.bookWrite.focus();
		return;
	}
	if(frm.bookCount.value.min >= 1){
		alert("책 권수를 입력하세요");
		frm.bookCount.focus();
		return;
	}
	if(frm.bookPub.value.length == 0){ 
		alert("출판사 이름을 입력해야 합니다.");
		frm.bookPub.focus();
		return;
	}
	if(frm.bookComent.value.length == 0){ 
		alert("책의 내용을 입력해주세요.");
		frm.bookComent.focus();
		return;
	}
	if(reg_frm.mem_pwd.value != reg_frm.mem_pwd_check.value){ 
		alert("패스워드가 일치하지 않습니다.");
		reg_frm.mem_uid.focus();
		return;
	}
	document.frm.submit();
    }