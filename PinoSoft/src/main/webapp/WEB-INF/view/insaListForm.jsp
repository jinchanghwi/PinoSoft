<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/bootstrap-select.css">
<link rel="stylesheet" href="/css/insaListForm.css">
<link type="text/css" href="http://jqueryui.com/latest/themes/base/ui.all.css" rel="stylesheet" />
<script src="/js/bootstrap.js" ></script>
<script src="/js/bootstrap-select.min.js" ></script>
<script type="text/javascript" src="http://jqueryui.com/latest/ui/ui.core.js"></script>
<script type="text/javascript" src="http://jqueryui.com/latest/ui/ui.dialog.js"></script>
<script src="/js/insaListForm.js"></script>
<script>
$(document).ready(function(){
	
	
});
</script>
</head>
<body>
<header id="header1">
PINO SOFT&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
<a href="/index.html">Home</a>&emsp;
<a href="/insaInputForm.do">Input</a>&emsp;
<a href="/insaListForm.do">Search</a>
</header>
<form name="insaForm" action="/insaListForm_Search.do" class="form-inline">
<input type="hidden" name="nowRecord_txt" id="nowRecord_txt" value="${paging.nowRecord}">
<div id="topDiv">
	<table width="1400" height="150" align="center" border=0 >
		<caption>
			<h2>직원 리스트</h2>
			
		</caption>
		<tr>	
			<td>사번</td><td><input type="text" name="sabun" id="sabun" value="${searchVo.sabun}"></td>
			<td>성명</td><td><input type="text" name="name" id="name" value="${searchVo.name}"></td>
			<td>입사구분</td>
			<td>
				<select name="join_gbn_code" id="join_gbn_code">
				<option value=""></option>
					<c:forEach var="jgcList" items="${join_gbn_code_List}">
						<c:if test="${jgcList.name.equals(searchVo.join_gbn_code)}">
							<option value="${jgcList.name}" selected="selected">${jgcList.name}</option>
						</c:if>
						<c:if test="${jgcList.name != searchVo.join_gbn_code}">
							<option value="${jgcList.name}">${jgcList.name}</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td>투입여부</td>
			<td>
				<select name="put_yn" id="put_yn">
				<option value=""></option>
					<c:forEach var="pynList" items="${put_yn_List}">
						<c:if test="${pynList.name.equals(searchVo.put_yn)}">
							<option value="${pynList.name}" selected="selected">${pynList.name}</option>
						</c:if>
						<c:if test="${pynList.name != searchVo.put_yn}">
							<option value="${pynList.name}">${pynList.name}</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>직위</td>
			<td>
				<select name="position" id="position">
				<option value=""></option>
					<c:forEach var="pList" items="${position_List}">
						<c:if test="${pList.name.equals(searchVo.position)}">
							<option value="${pList.name}" selected="selected">${pList.name}</option>
						</c:if>
						<c:if test="${pList.name != searchVo.position}">
							<option value="${pList.name}">${pList.name}</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td>입사일자</td><td><input type="date" name="join_day" id="join_day" value="${searchVo.join_day}"></td>
			<td>퇴사일자</td><td><input type="date" name="retire_day" id="retire_day" value="${searchVo.retire_day}"></td>
			<td>직종분류</td>
			<td>
				<select name="job_type" id="job_type">
				<option value=""></option>
					<c:forEach var="jtList" items="${job_type_List}">
						<c:if test="${jtList.name.equals(searchVo.job_type)}">
							<option value="${jtList.name}" selected="selected">${jtList.name}</option>
						</c:if>
						<c:if test="${jtList.name != searchVo.job_type}">
							<option value="${jtList.name}">${jtList.name}</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="8" align="right">
			<!--
				<select name="andor" id="andor">
					<c:if test="${searchVo.andor != ''}">
						<option value="and" selected="selected">모든조건 만족</option>
						<option value="or">일부조건 만족</option>
					</c:if>
					<c:if test="${searchVo.andor == 'and'}">
							<option value="and" selected="selected">모든조건 만족</option>
							<option value="or">일부조건 만족</option>
					</c:if>
					<c:if test="${searchVo.andor == 'or'}">
							<option value="and">모든조건 만족</option>
							<option value="or" selected="selected">일부조건 만족</option>
					</c:if>
				</select>
				-->
				<button type="submit" class="btn btn-light">검색</button>
				<button type="button" class="btn btn-light" id="delBtn">삭제</button>
				<button type="button" class="btn btn-light" onclick="location.href='/insaListForm.do'">초기화</button>
				<button type="button" class="btn btn-light" onclick="location.href='/index.html'">이전</button>
			</td>
		</tr>
	</table>
</div>
<div id="bottomDiv">

<table border=0 width="1400" align="center" class="table table-striped">
	<tr class="bottomTR">
		<td>체크</td>
		<td>사번</td><td>성명</td><td>주민번호</td><td>핸드폰번호</td>
		<td>직위</td><td>입사일자</td><td>퇴사일자</td><td>투입여부</td>
		<td>연봉</td>
		<td>수정</td>
		<!-- <td>삭제</td>  -->
	</tr>
	<c:if test="${fn:length(insaList)<=0}">
		<tr>
			<td colspan="11" align="center">
				검색 결과가 없습니다.
			</td>
		</tr>
	</c:if>
	<c:forEach var="iList" items="${insaList}">
			<tr class="bottomTR">	
				<td>
					
					<input type="checkbox" name="check_Sabun" id="check_Sabun" value="${iList.sabun}">
				</td>
				<td>${iList.sabun}</td><td>${iList.name}</td><td>${fn:substring(iList.reg_no,0,8)}******</td><td>${iList.phone}</td>
				<td>${iList.position}</td><td>${fn:substring(iList.join_day,0,10)}</td><td>${fn:substring(iList.retire_day,0,10)}</td><td>${iList.put_yn}</td>
				<td>${iList.salary}</td>
				<td>
					<button type="button" class="insaUpdateBtn btn btn-light" value="${iList.sabun}">수정</button>
				</td>
				<!-- 
				<td>
					<button type="button" class="insaDeleteBtn btn btn-light" value="${iList.sabun}">삭제</button>
				</td>
				 -->
			</tr>			
	</c:forEach>
</table>
<div align="center">
<br>
<c:if test="${paging.nowPage<=10}">
	<button type="submit" name="nowRecord" disabled="disabled">이전</button>
</c:if>
<c:if test="${paging.nowRecord > (paging.pageSize * paging.listSize)}">
	<button type="submit" name="nowRecord" value="${(paging.startPage-paging.listSize)*paging.pageSize-paging.pageSize+1}">이전</button>
</c:if>

<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
	<c:if test="${i<=paging.totalPage}">
		<c:if test="${i==paging.nowPage}">
			<button type="submit" name="nowRecord" value="${(i-1)*10+1}"><font color="red">${i}</font></button>
		</c:if>
		<c:if test="${i!=paging.nowPage}">
			<button type="submit" name="nowRecord" value="${(i-1)*10+1}">${i}</button>
		</c:if>
	</c:if>
</c:forEach>

<c:if test="${paging.endPage < paging.totalPage}">
	<button type="submit" name="nowRecord" value="${paging.pageSize*paging.endPage+1}">다음</button>
</c:if>
<c:if test="${paging.endPage >= paging.totalPage}">
	<button type="submit" name="nowRecord" disabled="disabled">다음</button>
</c:if>

<c:if test="${paging eq null}">
	<input type="hidden" name="nowRecord" id="nowRecord" value="1">
</c:if>
<c:if test="${paging ne null}">
	<input type="hidden" name="nowRecord" id="nowRecord" value="${paging.nowRecord}">
</c:if>
</div>
</div>
<br>
</form>
</body>
</html>