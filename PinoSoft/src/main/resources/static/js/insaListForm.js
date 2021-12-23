$(document).ready(function(){
	$('input').addClass('form-control');
	$('input').attr('style','width:86%');
	
	$('select').addClass('form-control');
	$('select').attr('style','width:86%');
	//$('#AndOr').attr('style','width:15%');
	$(".insaDeleteBtn").click(function() {
		 if(confirm("정말 삭제하시겠습니까?")) {
			 location.href = "/insaDelete.do"
					+"?sabun=" + $(this).val()
					+ "&searchSabun=" + $("#sabun").val()
					+ "&name=" + $("#name").val()
					+ "&join_gbn_code=" + $("#join_gbn_code").val()
					+ "&put_yn=" + $("#put_yn").val()
					+ "&position=" + $("#position").val()
					+ "&join_day=" + $("#join_day").val()
					+ "&retire_day=" + $("#retire_day").val()
					+ "&job_type=" + $("#job_type").val()
					// + "&andor=" + $("#andor").val()
					+ "&nowRecord=" + $("#nowRecord_txt").val();
		 }
		 else {
		 
		 }
	});
	$(".insaUpdateBtn").click(function() {

		 location.href = "/insaUpdateForm.do"
				+"?sabun=" + $(this).val()
				+ "&searchSabun=" + $("#sabun").val()
				+ "&name=" + $("#name").val()
				+ "&join_gbn_code=" + $("#join_gbn_code").val()
				+ "&put_yn=" + $("#put_yn").val()
				+ "&position=" + $("#position").val()
				+ "&join_day=" + $("#join_day").val()
				+ "&retire_day=" + $("#retire_day").val()
				+ "&job_type=" + $("#job_type").val()
				// + "&andor=" + $("#andor").val()
				+ "&nowRecord=" + $("#nowRecord_txt").val();
	});
	$("#delBtn").click(function() {
		var end = $("#check_Sabun:checked").length;
		
		if(confirm("총 " + end + "건의 데이터를 삭제합니까?")) {
		
			var checked = [];
			
			$("#check_Sabun:checked").each(function() {
				checked.push($(this).val());
			});
			
			var url="/check_delete.do?check_Cnt="+end
			+ "&check_Sabun="+checked
			+ "&sabun=" + $("#sabun").val()
			+ "&name=" + $("#name").val()
			+ "&join_gbn_code=" + $("#join_gbn_code").val()
			+ "&put_yn=" + $("#put_yn").val()
			+ "&position=" + $("#position").val()
			+ "&join_day=" + $("#join_day").val()
			+ "&retire_day=" + $("#retire_day").val()
			+ "&job_type=" + $("#job_type").val()
			+ "&nowRecord=" + $("#nowRecord").val();
			
			
			location.href = url;
		}
		
	});
});