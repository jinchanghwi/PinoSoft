<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/bootstrap-select.css">
<link rel="stylesheet" href="/css/insaUpdateForm.css">
<link type="text/css" href="http://jqueryui.com/latest/themes/base/ui.all.css" rel="stylesheet" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="/js/bootstrap.js" ></script>
<script src="/js/bootstrap-select.min.js" ></script>
<script src="/js/jquery.modal.min.js" ></script>
<script src="/js/jquery.modal.js" ></script>
<script src="/js/jquery.bpopup.min.js" ></script>
<script src="/js/jquery.mask.js" ></script>
<script src="/js/jquery-inputcloak.js" ></script>
<script type="text/javascript" src="http://jqueryui.com/latest/ui/ui.core.js"></script>
<script type="text/javascript" src="http://jqueryui.com/latest/ui/ui.dialog.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> <!-- 주소API -->
<script src="/js/addressAPI.js"></script>
<script src="/js/insaUpdateForm.js"></script>
<script src="/js/insaUpdateForm_jQuery.js"></script>
</head>
<body>
<header id="header1">
PINO SOFT&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
<a href="/index.html">Home</a>&emsp;
<a href="/insaInputForm.do">Input</a>&emsp;
<a href="/insaListForm.do">Search</a>
</header>
<div>
<form name="insaForm" action="insaUpdate.do" method="post" enctype="multipart/form-data" class="form-inline">
<input type="hidden" name="nowRecord" id="nowRecord" value="${searchVo.nowRecord}">
<input type="hidden" name="searchSabun" id="searchSabun" value="${searchVo.searchSabun}">
<input type="hidden" name="searchName" id="searchName" value="${searchVo.name}">
<input type="hidden" name="searchJoin_gbn_code" id="searchJoin_gbn_code" value="${searchVo.join_gbn_code}">
<input type="hidden" name="searchPut_yn" id="searchPut_yn" value="${searchVo.put_yn}">
<input type="hidden" name="searchPosition" id="searchPosition" value="${searchVo.position}">
<input type="hidden" name="searchJoin_day" id="searchJoin_day" value="${searchVo.join_day}">
<input type="hidden" name="searchRetire_day" id="searchRetire_day" value="${searchVo.retire_day}">
<input type="hidden" name="searchJob_type" id="searchJob_type" value="${searchVo.job_type}">
<!--  <input type="hidden" name="andor" value="${searchVo.andor}"> -->
	<table height=600 align="center" border=0>
		<tr>
			<td colspan="8">
				<div align="right" style="padding-right:1%" >
					<button type="submit" class="btn btn-dark" onclick="return check()">수정</button>
					<button type="button" class="insaDeleteBtn btn btn-dark" value="${getInsa.sabun}">삭제</button>
					<button type="reset" class="btn btn-dark" id="formReset">초기화</button>
					<button type="button" class="btn btn-dark" onclick="prevPage()">전화면</button>
				</div>
			</td>
		</tr>
		<tr>
			<td rowspan="5" colspan="2">
				<img src="/img/profile/${getInsa.profile_image}" id="profile_image_preview">
			</td>
			<td width="150">*사번</td><td width="200"><input type="text" name="sabun" id="sabun" readonly="readonly" dir="rtl" value="${getInsa.sabun}"></td>
			<td width="150">*한글성명</td><td width="200"><input type="text" name="name" onKeypress="hangul()" value="${getInsa.name}"></td>
			<td width="150">영문성명</td><td width="200"><input type="text" name="eng_name" onKeyup="this.value=this.value.replace(/[^A-Za-z_]/g,'');" value="${getInsa.eng_name}"></td>
		</tr>
		<tr>
			<td>*아이디</td><td><input type="text" name="id" id="id" onKeyup="this.value=this.value.replace(/[^A-Za-z0-9_]/g,'');" value="${getInsa.id}"></td>
			<td>*패스워드</td><td><input type="password" name="pwd1" value="${getInsa.pwd}"></td>
			<td>*패스워드<br>확인</td><td><input type="password" name="pwd2" value="${getInsa.pwd}"></td>
		</tr>
		<tr>
			<td>전화번호</td><td><input type="text" name="hp" id="hp" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="14" value="${getInsa.hp}"></td>
			<td>*핸드폰번호</td><td><input type="text" name="phone" id="phone" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="13"value="${getInsa.phone}"></td>
			<td>*주민번호</td>
			<td>
				<input type="text" name="reg_no_masking" id="reg_no_masking" maxlength="14" value="${getInsa.reg_no}">
				<input type="hidden" name="reg_no" id="reg_no" maxlength="14" value="${getInsa.reg_no}">
			</td>
		</tr>
		<tr>
			<td>
			연령
				<input type="text" name="years" id="years" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" value="${getInsa.years}">&nbsp;&nbsp;
			</td>
			<td colspan="3">
			*이메일
				<input type="text" name="email1" id="email1" onKeyup="this.value=this.value.replace(/[^A-Za-z0-9_]/g,'');" value="${getInsa.email1}">@
				<input type="text" name="email2" id="email2" style="width:100px;" value="${getInsa.email2}" readonly>
				<select name="email2_selct" id="email2_selct">
					<option value=""></option>
					<c:forEach var="eList" items="${email_List}">
						<option value="${eList.name}">${eList.name}</option>
					</c:forEach>
					<option value="self">직접입력</option>
				</select>
			</td>
			<td colspan="2">
			직종체크
				<select name="job_type" id="job_type">
					<option value=""></option>
					<c:forEach var="jtList" items="${job_type_List}">
						<c:if test="${jtList.name eq getInsa.job_type}">
							<option value="${jtList.name}" selected="selected">${jtList.name}</option>
						</c:if>
						<c:if test="${jtList.name != getInsa.job_type}">
							<option value="${jtList.name}">${jtList.name}</option>
						</c:if>
					</c:forEach>
				</select>&nbsp;&nbsp;
			성별
				<select name="sex" id="sex">
					<option value=""></option>
					<c:forEach var="sList" items="${sex_List}">
						<c:if test="${sList.name eq getInsa.sex}">
							<option value="${sList.name}" selected="selected">${sList.name}</option>
						</c:if>
						<c:if test="${sList.name != getInsa.sex}">
							<option value="${sList.name}">${sList.name}</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
				<input type="text" id="sample6_postcode" name="zip" value="${getInsa.zip}" placeholder="우편번호" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
				<button type="button" onclick="sample6_execDaumPostcode()" class="btn btn-light">주소검색</button>
			</td>
			<td colspan="2"><input type="text" id="sample6_address" name="addr1" value="${getInsa.addr1}" placeholder="주소"></td>
			<td colspan="2"><input type="text" id="sample6_detailAddress" name="addr2" value="${getInsa.addr2}" placeholder="세부주소"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="file" id="upload_profile_image" name="upload_profile_image">
				<button type="button" class="btn btn-light" id="profileBtn" >사진 등록</button>
			</td>
			<td>직위</td>
			<td>
				<select name="position">
					<option value=""></option>
					<c:forEach var="pList" items="${position_List}">
						<c:if test="${pList.name eq getInsa.position}">
							<option value="${pList.name}" selected="selected">${pList.name}</option>
						</c:if>
						<c:if test="${pList.name != getInsa.position}">
							<option value="${pList.name}">${pList.name}</option>
						</c:if>
						<option value="${pList.name}">${pList.name}</option>>
					</c:forEach>
				</select>
			</td>
			<td>부서</td>
			<td>
				<select name="dept_code" id="dept_code">
					<option value="none" value2="000"></option>
					<c:forEach var="dcList" items="${dept_code_List}">
						<c:if test="${dcList.name eq getInsa.dept_code}">
							<option value="${dcList.name}" selected="selected">${dcList.name}</option>
						</c:if>
						<c:if test="${dcList.name != getInsa.dept_code}">
							<option value="${dcList.name}">${dcList.name}</option>
						</c:if>
						<option value="${dcList.name}" value2="${dcList.code}">${dcList.name}</option>
					</c:forEach>
				</select>
			</td>
			<td>연봉(만원)</td>
			<td>
				<input type="text" name="salary" id="salary" value="${getInsa.salary}" dir="rtl" placeholder="(만원)" onkeyup="inputNumberFormat(this)" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
			</td>
		</tr>
		<tr>
			<td width="150">입사구분</td>
			<td width="200">
				<select name="join_gbn_code">
					<option value=""></option>
					<c:forEach var="jgcList" items="${join_gbn_code_List}">
						<c:if test="${jgcList.name eq getInsa.join_gbn_code}">
							<option value="${jgcList.name}" selected="selected">${jgcList.name}</option>
						</c:if>
						<c:if test="${jgcList.name != getInsa.join_gbn_code}">
							<option value="${jgcList.name}">${jgcList.name}</option>
						</c:if>
						<option value="${jgcList.name}">${jgcList.name}</option>
					</c:forEach>
				</select>
			</td>
			<td>학력</td>
			<td>
				<select name="gart_level">
					<option value=""></option>
					<c:forEach var="gList" items="${gart_level_List}">
						<c:if test="${gList.name eq getInsa.gart_level}">
							<option value="${gList.name}" selected="selected">${gList.name}</option>
						</c:if>
						<c:if test="${gList.name != getInsa.gart_level}">
							<option value="${gList.name}">${gList.name}</option>
						</c:if>
						<option value="${gList.name}">${gList.name}</option>
					</c:forEach>
				</select>
			</td>
			<td>투입여부</td>
			<td>
				<select name="put_yn">
					<option value=""></option>
					<c:forEach var="pynList" items="${put_yn_List}">
						<c:if test="${pynList.name eq getInsa.put_yn}">
							<option value="${pynList.name}" selected="selected">${pynList.name}</option>
						</c:if>
						<c:if test="${pynList.name != getInsa.put_yn}">
							<option value="${pynList.name}">${pynList.name}</option>
						</c:if>
						<option value="${pynList.name}">${pynList.name}</option>>
					</c:forEach>
				</select>
			</td>
			<td>군필여부</td>
			<td>
				<select name="mil_yn" id="mil_yn">
					<option value=""></option>
					<c:forEach var="mynList" items="${mil_yn_List}">
						<c:if test="${mynList.name eq getInsa.mil_yn}">
							<option value="${mynList.name}" selected="selected">${mynList.name}</option>
						</c:if>
						<c:if test="${mynList.name != getInsa.mil_yn}">
							<option value="${mynList.name}">${mynList.name}</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>군별</td>
			<td>
				<select name="mil_type" id="mil_type">
					<option value=""></option>
					<c:forEach var="mtList" items="${mil_type_List}">
					<c:if test="${mtList.name eq getInsa.mil_type}">
							<option value="${mtList.name}" selected="selected">${mtList.name}</option>
						</c:if>
						<c:if test="${mtList.name != getInsa.mil_type}">
							<option value="${mtList.name}">${mtList.name}</option>
						</c:if>
						<option value="${myList.name}">${myList.name}</option>>
					</c:forEach>
				</select>
			</td>
			<td>계급</td>
			<td>
				<select name="mil_level" id="mil_level">
					<option value=""></option>
					<c:forEach var="mlList" items="${mil_level_List}">
					<c:if test="${mlList.name eq getInsa.mil_level}">
							<option value="${mlList.name}" selected="selected">${mlList.name}</option>
						</c:if>
						<c:if test="${mlList.name != getInsa.mil_level}">
							<option value="${mlList.name}">${mlList.name}</option>
						</c:if>
						<option value="${mlList.name}">${mlList.name}</option>>
					</c:forEach>
				</select>
			</td>
			<td>입영일자</td><td><input type="date" name="mil_startdate" id="mil_startdate" class="datepicker" value="${getInsa.mil_startdate.substring(0,10)}"></td>
			<td>전역일자</td><td><input type="date" name="mil_enddate" id="mil_enddate" value="${getInsa.mil_enddate.substring(0,10)}"></td>
		</tr>
		<tr>
			<td>KOSA등록</td>
			<td>
				<select name="kosa_reg_yn" id="kosa_reg_yn">
					<option value=""></option>
					<c:forEach var="krynList" items="${kosa_reg_yn_List}">
					<c:if test="${krynList.name eq getInsa.kosa_reg_yn}">
							<option value="${krynList.name}" selected="selected">${krynList.name}</option>
						</c:if>
						<c:if test="${krynList.name != getInsa.kosa_reg_yn}">
							<option value="${krynList.name}">${krynList.name}</option>
						</c:if>
						<option value="${krynList.name}">${krynList.name}</option>>
					</c:forEach>
				</select>
			</td>
			<td>KOSA등급</td>
			<td>
				<select name="kosa_class_code" id="kosa_class_code">
					<option value=""></option>
					<c:forEach var="kccList" items="${kosa_class_code_List}">
						<c:if test="${kccList.name eq getInsa.kosa_class_code}">
							<option value="${kccList.name}" selected="selected">${kccList.name}</option>
						</c:if>
						<c:if test="${kccList.name != getInsa.kosa_class_code}">
							<option value="${kccList.name}">${kccList.name}</option>
						</c:if>
						<option value="${kccList.name}">${kccList.name}</option>>
					</c:forEach>
				</select>
			</td>
			<td>*입사일자</td><td><input type="date" name="join_day" id="join_day" value="${getInsa.join_day.substring(0,10)}"></td>
			<td>퇴사일자</td><td><input type="date" name="retire_day" id="retire_day" value="${getInsa.retire_day.substring(0,10)}"></td>
		</tr>
		<tr>
			<td>사업자번호</td><td><input type="text" name="cmp_reg_no" id="cmp_reg_no" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="12" value="${getInsa.cmp_reg_no}"></td>
			<td>업체명</td><td><input type="text" name="crm_name" value="${getInsa.crm_name}"></td>
			<td>사업자등록증</td><td><input type="text" id="upload_cmp_reg_image_txt" disabled="disabled" value="${getInsa.cmp_reg_image}"></td>
			<td colspan="2">
				<button type="button" id="upload_cmp_reg_image_Btn" class="btn btn-light" style="width:40%" data-toggle="modal" data-target="#cmp_reg_Modal">미리보기</button>
				<input type="file" id="upload_cmp_reg_image" name="upload_cmp_reg_image" id="upload_cmp_reg_image">
				<button type="button" class="btn btn-light" id="cmp_regBtn" style="width:40%">등록</button>
			</td>
		</tr>
		<tr>
			<td>자기소개</td><td colspan="3"><textarea rows="2" cols="100" name="selp_intro" placeholder="100자 내외로 적으세요">${getInsa.selp_intro}</textarea></td>
			<td>이력서</td><td><input type="text" id="upload_carrier_image_txt" disabled="disabled" value="${getInsa.carrier_image}"></td>
			<td colspan="2">
				<button type="button" id="upload_carrier_image_Btn" class="btn btn-light" style="width:40%" data-toggle="modal" data-target="#carrier_Modal">미리보기</button>
				<input type="file" id="upload_carrier_image" name="upload_carrier_image">
				<button type="button" class="btn btn-light" id="carrierBtn" style="width:40%">파일 업로드</button>
			</td>
		</tr>
	</table>
</form>
</div>
<div class="modal fade" id="cmp_reg_Modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body" style="text-align:center">
		<img src="/img/cmp_reg/${getInsa.cmp_reg_image}" id="cmp_reg_image_preview">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="carrier_Modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body" style="text-align:center">
		<img src="/img/carrier/${getInsa.carrier_image}" id="carrier_image_preview">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>