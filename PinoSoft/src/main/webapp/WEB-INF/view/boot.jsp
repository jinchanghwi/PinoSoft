<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html> <html lang="ko"> 
<head> 
<meta charset="utf-8"> 
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>부트스트랩 템플릿</title>
<link href="css/bootstrap.min.css" rel="stylesheet"> 
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="/js/bootstrap.js" ></script>
<script src="/js/jquery.modal.min.js" ></script>
<script src="/js/jquery.modal.js" ></script>
<script type="text/javascript" src="http://jqueryui.com/latest/ui/ui.core.js"></script>
<script type="text/javascript" src="http://jqueryui.com/latest/ui/ui.dialog.js"></script>
<script>
$(document).ready(function(){
	$("#testBtn").click(function() {
		var datastr = {
				sabun : $("#test").attr("value1"),
				name : $("#test").attr("value2")
				};
		$.ajax({
			tyep: "GET",
			url: "/test.do",
			data: datastr,
			success:function(data){

			}
		});
		
	});
});
</script>
</head>
<body>
<form>
<c:set var="jin" value="진창휘" />
<input type="text" name="test" id="test" value1="안녕하세요" value2="반갑습니다">
<button type="button" class="btn btn-light" id="testBtn">${jin}</button>
<c:remove var="jin"/>
<button type="button" class="btn btn-light" id="testBtn">${jin}</button>
</form>
</body>
</html>
