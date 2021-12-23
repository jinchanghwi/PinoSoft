<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/insaInputForm.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="/js/jquery.mask.js" ></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> <!-- 주소API -->
<script src="/js/addressAPI.js"></script>
<script src="/js/insaInputForm_jQuery.js" ></script>
<script src="/js/insaInputForm.js" ></script> 
</head>
<body>
<header id="header1">
PINO SOFT&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
<a href="/index.html">Home</a>&emsp;
<a href="/insaInputForm.do">Input</a>&emsp;
<a href="/insaListForm.do">Search</a>
</header>
<div>
<form name="insaForm" action="insaInput.do" method="post" enctype="multipart/form-data" class="form-inline">
	<table height=600 align="center" border=0>
		<tr>
			<td colspan="8">
				<div align="right" style="padding-right:1%" >
					<button type="submit" class="btn btn-dark" onclick="return check()">등록</button>
					<button type="reset" class="btn btn-dark" id="formReset">초기화</button>
					<button type="button" class="btn btn-dark" onclick="location.href='index.html'">전화면</button>
				</div>
			</td>
		</tr>
		<tr>
			<td rowspan="5" colspan="2">
				<img src="img/default.png" id="profile_image_preview">
			</td>
			<td width="150">*사번</td><td width="200"><input type="text" name="sabun" id="sabun" readonly="readonly" dir="rtl" placeholder="자동으로 생성됩니다" ></td>
			<td width="150">*한글성명</td><td width="200"><input type="text" name="name" onKeypress="hangul()"></td>
			<td width="150">영문성명</td><td width="200"><input type="text" name="eng_name" onKeyup="this.value=this.value.replace(/[^A-Za-z_]/g,'');"></td>
		</tr>
		<tr>
			<td>*아이디</td><td><input type="text" name="id" id="id" onKeyup="this.value=this.value.replace(/[^A-Za-z0-9_]/g,'');"></td>
			<td>*패스워드</td><td><input type="password" name="pwd1" id="pwd1"></td>
			<td>*패스워드<br>확인</td><td><input type="password" name="pwd2" id="pwd2"></td>
		</tr>
		<tr>
			<td>전화번호</td><td><input type="text" name="hp" id="hp" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="14"></td>
			<td>*핸드폰번호</td><td><input type="text" name="phone" id="phone" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="13"></td>
			<td>*주민번호</td>
			<td>
				<input type="text" name="reg_no_masking" id="reg_no_masking" maxlength="14">
				<input type="text" name="reg_no" id="reg_no" maxlength="14">
			</td>
		</tr>
		<tr>
			<td>
			연령
				<input type="text" name="years" id="years" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
			</td>
			<td colspan="3">
			*이메일
				<input type="text" name="email1" id="email1" onKeyup="this.value=this.value.replace(/[^A-Za-z0-9_]/g,'');">@
				<input type="text" name="email2" id="email2" style="width:100px;" readonly>
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
						<option value="${jtList.name}">${jtList.name}</option>>
					</c:forEach>
				</select>
				&nbsp;
			성별
				<select name="sex" id="sex">
					<option value=""></option>
					<c:forEach var="sList" items="${sex_List}">
						<option value="${sList.name}">${sList.name}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>주소</td><td><input type="text" id="sample6_postcode" name="zip" placeholder="우편번호" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
			<button type="button" onclick="sample6_execDaumPostcode()" class="btn btn-light">주소검색</button></td>
			<td colspan="2"><input type="text" id="sample6_address" name="addr1" placeholder="주소"></td>
			<td colspan="2"><input type="text" id="sample6_detailAddress" name="addr2" placeholder="세부주소"></td>
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
						<option value="${pList.name}">${pList.name}</option>
					</c:forEach>
				</select>
			</td>
			<td>부서</td>
			<td>
				<select name="dept_code" id="dept_code">
					<option value="none" value2="000"></option>
					<c:forEach var="dcList" items="${dept_code_List}">
						<option value="${dcList.name}" value2="${dcList.code}">${dcList.name}</option>
					</c:forEach>
				</select>
			</td>
			<td>연봉(만원)</td><td><input type="text" name="salary" id="salary" dir="rtl" placeholder="(만원)" onkeyup="inputNumberFormat(this)" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"></td>
		</tr>
		<tr>
			<td width="150">입사구분</td>
			<td width="200">
				<select name="join_gbn_code">
					<option value=""></option>
					<c:forEach var="jgcList" items="${join_gbn_code_List}">
						<option value="${jgcList.name}">${jgcList.name}</option>>
					</c:forEach>
				</select>
			</td>
			<td>학력</td>
			<td>
				<select name="gart_level">
					<option value=""></option>
					<c:forEach var="gList" items="${gart_level_List}">
						<option value="${gList.name}">${gList.name}</option>>
					</c:forEach>
				</select>
			</td>
			<td>투입여부</td>
			<td>
				<select name="put_yn">
					<option value=""></option>
					<c:forEach var="pynList" items="${put_yn_List}">
						<option value="${pynList.name}">${pynList.name}</option>>
					</c:forEach>
				</select>
			</td>
			<td>군필여부</td>
			<td>
				<select name="mil_yn" id="mil_yn">
					<option value=""></option>
					<c:forEach var="mynList" items="${mil_yn_List}">
						<option value="${mynList.name}">${mynList.name}</option>>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>군별</td>
			<td>
				<select name="mil_type" id="mil_type">
					<option value=""></option>
					<c:forEach var="myList" items="${mil_type_List}">
						<option value="${myList.name}">${myList.name}</option>>
					</c:forEach>
				</select>
			</td>
			<td>계급</td>
			<td>
				<select name="mil_level" id="mil_level">
					<option value=""></option>
					<c:forEach var="mlList" items="${mil_level_List}">
						<option value="${mlList.name}">${mlList.name}</option>>
					</c:forEach>
				</select>
			</td>
			<td>입영일자</td><td><input type="date" name="mil_startdate" id="mil_startdate" class="datepicker"></td>
			<td>전역일자</td><td><input type="date" name="mil_enddate" id="mil_enddate"></td>
		</tr>
		<tr>
			<td>KOSA등록</td>
			<td>
				<select name="kosa_reg_yn" id="kosa_reg_yn">
					<option value=""></option>
					<c:forEach var="krynList" items="${kosa_reg_yn_List}">
						<option value="${krynList.name}">${krynList.name}</option>>
					</c:forEach>
				</select>
			</td>
			<td>KOSA등급</td>
			<td>
				<select name="kosa_class_code" id="kosa_class_code">
					<option value=""></option>
					<c:forEach var="kccList" items="${kosa_class_code_List}">
						<option value="${kccList.name}">${kccList.name}</option>>
					</c:forEach>
				</select>
			</td>
			<td>*입사일자</td><td><input type="date" name="join_day" id="join_day"></td>
			<td>퇴사일자</td><td><input type="date" name="retire_day" id="retire_day"></td>
		</tr>
		<tr>
			<td>사업자번호</td><td><input type="text" name="cmp_reg_no" id="cmp_reg_no" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="12"></td>
			<td>업체명</td><td><input type="text" name="crm_name"></td>
			<td>사업자등록증</td><td><input type="text" id="upload_cmp_reg_image_txt" disabled="disabled"></td>
			<td colspan="2">
				<button type="button" id="upload_cmp_reg_image_Btn" class="btn btn-light" style="width:40%" data-toggle="modal" data-target="#cmp_reg_Modal">미리보기</button>
				<input type="file" id="upload_cmp_reg_image" name="upload_cmp_reg_image" id="upload_cmp_reg_image">
				<button type="button" class="btn btn-light" id="cmp_regBtn" style="width:40%">등록</button>
			</td>
		</tr>
		<tr>
			<td>자기소개</td><td colspan="3"><textarea rows="2" cols="100" name="selp_intro" placeholder="100자 내외로 적으세요"></textarea></td>
			<td>이력서</td><td><input type="text" id="upload_carrier_image_txt" disabled="disabled"></td>
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
		<img src="/img/noimage.jpg" id="cmp_reg_image_preview">
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
		<img src="/img/noimage.jpg" id="carrier_image_preview">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<button type="button" id="testBtn" name="testBtn">테스트</button>
</body>
</html>