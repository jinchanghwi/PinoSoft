$(document).ready(function(){
	$("#id").change(function(){
		idCheck = 0;
		var datastr = {id : $("#id").val()};
		$.ajax({
			tyep: "GET",
			url: "/idCheck.do",
			data: datastr,
			success:function(data){
				if(data == 100){
					idCheck = 1;
				}
				else{
					alert("중복된 아이디 입니다");
					$("#id").val("");
					$("#id").focus();
					idCheck = 0;
				}
			}
		});
	});
	$("#pwd2").focusout(function(){
		var pwd1 = $("#pwd1").val();
		var pwd2 = $("#pwd2").val();
		if(pwd1 != pwd2){
			alert("암호를 확인해주세요");
			$("#pwd1").focus();
			$("#pwd2").val("");
			
		}
	});
	$(document).on("keyup", "#phone", function() {
		$(this).val($(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-")); 
	});
	$(document).on("keyup", "#hp", function() {
		$(this).val($(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-")); 
	});
	
	$(document).on("keyup", "#reg_no_masking", function() {
		$("#reg_no_masking").mask("000000-0000000");
		if($(this).val().length<14){
			$('#reg_no').val("");
		}
		if($(this).val().length>=14 && $('#reg_no').val() == ""){
			$('#reg_no').val($(this).val());
			var age = 19+$(this).val().substring(0,2);
			var year = new Date().getFullYear();
			var sex = $(this).val().substring(7,8) // 931110-1

			age = year - age + 1;
			$('#years').val(age);
			if(sex == 1 || sex == 3){
				$("#sex").val("남자").prop("selected", true);
			}
			else if(sex == 2 || sex == 4){
				$("#sex").val("여자").prop("selected", true);
			}
		}
		$(this).val(reg_no_Masking($(this).val())); 
	});
	$(document).on("keyup", "#cmp_reg_no", function() {
		var cmp_reg_no = $(this).val();
		cellvalue = cmp_reg_no.replace(/-/g, '').replace(/(\d{3})(\d{2})(\d{5})/g, '$1-$2-$3');
		$(this).val(cellvalue);
	});
	$("#join_day").change(function(item){
		var sabun1 = $('#join_day').val().substring(2,4);
		var sabun2 = $("#dept_code option:selected").attr('value2');
		if(sabun2 == null){
			$('#sabun').val(sabun1+'xxx'+'xxxx');
		}
		else {
			$('#sabun').val(sabun1+sabun2+'xxxx');
		}
	});
	$("#dept_code").change(function(item){
		var sabun1 = $('#join_day').val().substring(2,4);
		var sabun2 = $("#dept_code option:selected").attr('value2');
		if(sabun1 == ''){
			$('#sabun').val('xx'+sabun2+'xxxx');
		}
		else {
			$('#sabun').val(sabun1+sabun2+'xxxx');
		}
	});

	$("#join_day").change(function(){
		var join_day = new Date($('#join_day').val());
		var retire_day = new Date($('#retire_day').val());
		if(join_day.getTime()>retire_day.getTime()){
			alert("퇴사날짜는 입사날짜보다 이전일 수 없습니다.");
			$("#join_day").val("");
			$("#retire_day").val("");
		}
	});
	$("#retire_day").change(function(){
		var join_day = new Date($('#join_day').val());
		var retire_day = new Date($('#retire_day').val());
		if(join_day.getTime()>retire_day.getTime()){
			alert("퇴사날짜는 입사날짜보다 이전일 수 없습니다.");
			$("#join_day").val("");
			$("#retire_day").val("");
		}
	});
	$("#mil_startdate").change(function(){
		var mil_startdate = new Date($('#mil_startdate').val());
		var mil_enddate = new Date($('#mil_enddate').val());
		if(mil_startdate.getTime()>mil_enddate.getTime()){
			alert("전역날짜는 입영날짜보다 이전일 수 없습니다.");
			$("#mil_startdate").val("");
			$("#mil_enddate").val("");
		}
	});
	$("#mil_enddate").change(function(){
		var mil_startdate = new Date($('#mil_startdate').val());
		var mil_enddate = new Date($('#mil_enddate').val());
		if(mil_startdate.getTime()>mil_enddate.getTime()){
			alert("전역날짜는 입영날짜보다 이전일 수 없습니다.");
			$("#mil_startdate").val("");
			$("#mil_enddate").val("");
		}
	});
	
	$("#mil_yn").change(function(){

		if(document.getElementById("mil_yn").value == 'N'){
			$("#mil_type").attr('disabled','disabled');
			$("#mil_level").attr('disabled','disabled');
			$("#mil_startdate").attr('disabled','disabled');
			$("#mil_enddate").attr('disabled','disabled');
			
			$('#mil_type option:eq(0)').prop('selected', true);
			$('#mil_level option:eq(0)').prop('selected', true);
			$("#mil_startdate").val("");
			$("#mil_enddate").val("");
		}
		if(document.getElementById("mil_yn").value == 'Y'){
			$("#mil_type").removeAttr('disabled');
			$("#mil_level").removeAttr('disabled');
			$("#mil_startdate").removeAttr('disabled');
			$("#mil_enddate").removeAttr('disabled');
		}
	});
	
	$("#kosa_reg_yn").change(function(){
		if(document.getElementById("kosa_reg_yn").value == 'N'){
			$("#kosa_class_code").attr('disabled','disabled');
			$('#kosa_class_code option:eq(0)').prop('selected', true);
		}
		if(document.getElementById("kosa_reg_yn").value == 'Y'){
			$("#kosa_class_code").removeAttr('disabled');
		}
	});
	$('#profileBtn').click(function(){
		$("#upload_profile_image").click();
	});
	$('#cmp_regBtn').click(function(){
		$("#upload_cmp_reg_image").click();
	});
	$('#carrierBtn').click(function(){
		$("#upload_carrier_image").click();
	});
	
	$("#formReset").click(function(){
		$('#profile_image_preview').attr('src','img/default.png');
	});
	
	$("#upload_profile_image").change(function(){
		setImageFromFile(this, '#profile_image_preview');
	});
	
	$("#upload_cmp_reg_image").change(function(){
		$("#upload_cmp_reg_image_txt").val(document.getElementById("upload_cmp_reg_image").files[0].name);
		setImageFromFile(this, '#cmp_reg_image_preview');
	});
	
	$("#upload_carrier_image").change(function(){
		$("#upload_carrier_image_txt").val(document.getElementById("upload_carrier_image").files[0].name);
		setImageFromFile(this, '#carrier_image_preview');
	});
	
	$("#email2_selct").change(function(){
		
		var str = $(this).val();
		if(str == 'self'){
			$('#email2').val('');  //이메일 도메인입력박스 초기화.
            $('#email2').attr('readonly', false); //직접입력 가능하도록 readonly막기
		}
		else {
            $('#email2').attr('readonly', true); //readonly로 직접입력 막기.
            $('#email2').val(str); //이메일 도메인 입력박스에 선택된 호스트등록.
        }
	});
	
	$('tr').attr('align','center');
	
	$('input').addClass('form-control');
	$('input').attr('style','width:86%');
	
	$('select').addClass('form-control');
	$('select').attr('style','width:86%');
	
	$('textarea').addClass('form-control');
	$('textarea').attr('style','width:94%');
	
	$('#years').attr('style','width:30%');
	$('#email1').attr('style','width:25%');
	$('#email2').attr('style','width:25%');
	$('#email2_selct').attr('style','width:25%');
	
	$('#job_type').attr('style','width:30%');
	$('#sex').attr('style','width:30%');
	
	$('#sample6_postcode').attr('style','width:48%');
	
	$('#upload_profile_image').attr('style','display:none');
	$('#upload_cmp_reg_image').attr('style','display:none');
	$('#upload_carrier_image').attr('style','display:none');

});