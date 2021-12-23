function check() {
    if(insaForm.name.value == ''){
    	alert("이름을 입력해주세요");
    	insaForm.name.focus();
    	return false;
    }
    else if(insaForm.id.value == ''){
    	alert("아이디를 입력해주세요");
    	insaForm.id.focus();
    	return false;
    }
    else if(insaForm.pwd1.value == ''){
    	alert("암호를 입력해주세요");
    	insaForm.pwd1.focus();
    	return false;
    }
    else if(insaForm.pwd1.value != insaForm.pwd2.value){
    	alert("암호를 확인해주세요");
    	insaForm.pwd2.focus();
    	return false;
    }
    else if(insaForm.phone.value == ''){
    	alert("연락처를 입력해주세요");
    	insaForm.phone.focus();
    	return false;
    }
    else if(insaForm.reg_no.value == ''){
    	alert("주민번호를 입력해주세요");
    	insaForm.reg_no.focus();
    	return false;
    }
    else if(insaForm.email1.value == ''){
    	alert("이메일을 입력해주세요");
    	insaForm.email1.focus();
    	return false;
    }
    else if(insaForm.email2.value == ''){
    	alert("이메일을 입력해주세요");
    	insaForm.email2.focus();
    	return false;
    }
    else if(insaForm.join_day.value == ''){
    	alert("입사일자를 입력해주세요");
    	return false;
    }
    else {
    	if(confirm("수정하시겠습니까?")) {

		}
    	else {
    		return false;
    	}
    }
}
function inputNumberFormat(obj) {
    obj.value = comma(uncomma(obj.value));
}
function comma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}
function uncomma(str) {
    str = String(str);
    return str.replace(/[^\d]+/g, '');
}
function setImageFromFile(input, expression) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $(expression).attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}
function hangul(){ 
	if((event.keyCode < 12592) || (event.keyCode > 12687)){
		alert("한글만 입력이 가능합니다."); 
		event.returnValue = false 
	}
}
function checkNull(str){
	if(typeof str == "undefined" || str == null || str == ""){ 
		return true; 
	}
	else{ 
		return false; 
	}
}
function reg_no_Masking(str) {
	var originStr = str; 
	var rrnStr; 
	var maskingStr; 
	var strLength; 
	
	if(this.checkNull(originStr) == true){
		
		return originStr; 
	} 
	rrnStr = originStr.match(/(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4]{1}[0-9]{6}\b/gi); 
	if(this.checkNull(rrnStr) == false){ 
		strLength = rrnStr.toString().split('-').length; 
		maskingStr = originStr.toString().replace(rrnStr,rrnStr.toString().replace(/(-?)([1-4]{1})([0-9]{6})\b/gi,"$1$2******")); 
	}
	else { 
		rrnStr = originStr.match(/\d{13}/gi); 
		if(this.checkNull(rrnStr) == false){ 
			strLength = rrnStr.toString().split('-').length; 
			maskingStr = originStr.toString().replace(rrnStr,rrnStr.toString().replace(/(-?)([0-9]{6})$/gi,"******"));
		}
		else{ 
			return originStr; 
		} 
	}
	return maskingStr;
}