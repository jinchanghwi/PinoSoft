package com.pinosoft.jinch.insa;

import org.springframework.web.multipart.MultipartFile;

public class InsaVo {
			private String sabun;
			private String join_day;
			private String retire_day;
		    private String put_yn;
		    private String name;
		    private String reg_no;
		    private String eng_name;
		    private String phone;
		    private String hp;
		    private String position ;
		    private String pos_gbn_code;
		    private String cmp_reg_no;
		    private MultipartFile upload_cmp_reg_image; // 사업자 등록증
		    private String cmp_reg_image;
		    private String sex;
		    private String years;
		    private String email1; // 이메일 아이디
		    private String email2; // 도메인
		    private String email; // 완성된 이메일
		    private String zip;
		    private String addr1; // 주소
		    private String addr2; // 세부주소
		    private String dept_code;
		    private String join_gbn_code;
		    private String id;
		    private String pwd1;
		    private String pwd2;
		    private String pwd;
		    private String salary;
		    private String kosa_reg_yn;
		    private String kosa_class_code;
		    private String mil_yn;
		    private String mil_type;
		    private String mil_level;
		    private String mil_startdate;
		    private String mil_enddate;
		    private String job_type;
		    private String gart_level;
		    private String selp_intro;
		    private String crm_name;
		    private MultipartFile upload_profile_image; // 프로필 사진
		    private String profile_image;
		    private MultipartFile upload_carrier_image; // 이력서
		    private String carrier_image;
		    
		    private String andor;
		    
		    private int pageSize;
		    private int listSize;
		    private int totalRecord;
		    private int totalPage;
		    private int nowRecord;
		    private int nowPage;
		    private int startPage;
		    private int endPage;
		    
		    private String searchSabun;
		    private String searchName;
		    private String searchJoin_gbn_code;
		    private String searchPut_yn;
		    private String searchPosition;
		    private String searchJoin_day;
		    private String searchRetire_day;
		    private String searchJob_type;
		    
		    private String check_Sabun[];
		    private int check_Cnt;
		    
		    private String test;
		    
		    
		    
			public String getTest() {
				return test;
			}
			public void setTest(String test) {
				this.test = test;
			}
			public String[] getCheck_Sabun() {
				return check_Sabun;
			}
			public void setCheck_Sabun(String[] check_Sabun) {
				this.check_Sabun = check_Sabun;
			}
			public int getCheck_Cnt() {
				return check_Cnt;
			}
			public void setCheck_Cnt(int check_Cnt) {
				this.check_Cnt = check_Cnt;
			}
			public String getSearchName() {
				return searchName;
			}
			public void setSearchName(String searchName) {
				this.searchName = searchName;
			}
			public String getSearchJoin_gbn_code() {
				return searchJoin_gbn_code;
			}
			public void setSearchJoin_gbn_code(String searchJoin_gbn_code) {
				this.searchJoin_gbn_code = searchJoin_gbn_code;
			}
			public String getSearchPut_yn() {
				return searchPut_yn;
			}
			public void setSearchPut_yn(String searchPut_yn) {
				this.searchPut_yn = searchPut_yn;
			}
			public String getSearchPosition() {
				return searchPosition;
			}
			public void setSearchPosition(String searchPosition) {
				this.searchPosition = searchPosition;
			}
			public String getSearchJoin_day() {
				return searchJoin_day;
			}
			public void setSearchJoin_day(String searchJoin_day) {
				this.searchJoin_day = searchJoin_day;
			}
			public String getSearchRetire_day() {
				return searchRetire_day;
			}
			public void setSearchRetire_day(String searchRetire_day) {
				this.searchRetire_day = searchRetire_day;
			}
			public String getSearchJob_type() {
				return searchJob_type;
			}
			public void setSearchJob_type(String searchJob_type) {
				this.searchJob_type = searchJob_type;
			}
			public String getSearchSabun() {
				return searchSabun;
			}
			public void setSearchSabun(String searchSabun) {
				this.searchSabun = searchSabun;
			}
			public int getPageSize() {
				return pageSize;
			}
			public void setPageSize(int pageSize) {
				this.pageSize = pageSize;
			}
			public int getListSize() {
				return listSize;
			}
			public void setListSize(int listSize) {
				this.listSize = listSize;
			}
			public int getTotalRecord() {
				return totalRecord;
			}
			public void setTotalRecord(int totalRecord) {
				this.totalRecord = totalRecord;
			}
			public int getTotalPage() {
				return totalPage;
			}
			public void setTotalPage(int totalPage) {
				this.totalPage = totalPage;
			}
			public int getNowRecord() {
				return nowRecord;
			}
			public void setNowRecord(int nowRecord) {
				this.nowRecord = nowRecord;
			}
			public int getNowPage() {
				return nowPage;
			}
			public void setNowPage(int nowPage) {
				this.nowPage = nowPage;
			}
			public int getStartPage() {
				return startPage;
			}
			public void setStartPage(int startPage) {
				this.startPage = startPage;
			}
			public int getEndPage() {
				return endPage;
			}
			public void setEndPage(int endPage) {
				this.endPage = endPage;
			}
			public String getAndor() {
				return andor;
			}
			public void setAndor(String andor) {
				this.andor = andor;
			}
			public String getSabun() {
				return sabun;
			}
			public void setSabun(String sabun) {
				this.sabun = sabun;
			}
			public String getJoin_day() {
				return join_day;
			}
			public void setJoin_day(String join_day) {
				this.join_day = join_day;
			}
			public String getRetire_day() {
				return retire_day;
			}
			public void setRetire_day(String retire_day) {
				this.retire_day = retire_day;
			}
			public String getPut_yn() {
				return put_yn;
			}
			public void setPut_yn(String put_yn) {
				this.put_yn = put_yn;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getReg_no() {
				return reg_no;
			}
			public void setReg_no(String reg_no) {
				this.reg_no = reg_no;
			}
			public String getEng_name() {
				return eng_name;
			}
			public void setEng_name(String eng_name) {
				this.eng_name = eng_name;
			}
			public String getPhone() {
				return phone;
			}
			public void setPhone(String phone) {
				this.phone = phone;
			}
			public String getHp() {
				return hp;
			}
			public void setHp(String hp) {
				this.hp = hp;
			}
			public String getPosition() {
				return position;
			}
			public void setPosition(String position) {
				this.position = position;
			}
			public String getPos_gbn_code() {
				return pos_gbn_code;
			}
			public void setPos_gbn_code(String pos_gbn_code) {
				this.pos_gbn_code = pos_gbn_code;
			}
			public String getCmp_reg_no() {
				return cmp_reg_no;
			}
			public void setCmp_reg_no(String cmp_reg_no) {
				this.cmp_reg_no = cmp_reg_no;
			}
			public MultipartFile getUpload_cmp_reg_image() {
				return upload_cmp_reg_image;
			}
			public void setUpload_cmp_reg_image(MultipartFile upload_cmp_reg_image) {
				this.upload_cmp_reg_image = upload_cmp_reg_image;
			}
			public String getCmp_reg_image() {
				return cmp_reg_image;
			}
			public void setCmp_reg_image(String cmp_reg_image) {
				this.cmp_reg_image = cmp_reg_image;
			}
			public String getSex() {
				return sex;
			}
			public void setSex(String sex) {
				this.sex = sex;
			}
			public String getYears() {
				return years;
			}
			public void setYears(String years) {
				this.years = years;
			}
			public String getEmail1() {
				return email1;
			}
			public void setEmail1(String email1) {
				this.email1 = email1;
			}
			public String getEmail2() {
				return email2;
			}
			public void setEmail2(String email2) {
				this.email2 = email2;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getZip() {
				return zip;
			}
			public void setZip(String zip) {
				this.zip = zip;
			}
			public String getAddr1() {
				return addr1;
			}
			public void setAddr1(String addr1) {
				this.addr1 = addr1;
			}
			public String getAddr2() {
				return addr2;
			}
			public void setAddr2(String addr2) {
				this.addr2 = addr2;
			}
			public String getDept_code() {
				return dept_code;
			}
			public void setDept_code(String dept_code) {
				this.dept_code = dept_code;
			}
			public String getJoin_gbn_code() {
				return join_gbn_code;
			}
			public void setJoin_gbn_code(String join_gbn_code) {
				this.join_gbn_code = join_gbn_code;
			}
			public String getId() {
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}
			public String getPwd1() {
				return pwd1;
			}
			public void setPwd1(String pwd1) {
				this.pwd1 = pwd1;
			}
			public String getPwd2() {
				return pwd2;
			}
			public void setPwd2(String pwd2) {
				this.pwd2 = pwd2;
			}
			public String getPwd() {
				return pwd;
			}
			public void setPwd(String pwd) {
				this.pwd = pwd;
			}
			public String getSalary() {
				return salary;
			}
			public void setSalary(String salary) {
				this.salary = salary;
			}
			public String getKosa_reg_yn() {
				return kosa_reg_yn;
			}
			public void setKosa_reg_yn(String kosa_reg_yn) {
				this.kosa_reg_yn = kosa_reg_yn;
			}
			public String getKosa_class_code() {
				return kosa_class_code;
			}
			public void setKosa_class_code(String kosa_class_code) {
				this.kosa_class_code = kosa_class_code;
			}
			public String getMil_yn() {
				return mil_yn;
			}
			public void setMil_yn(String mil_yn) {
				this.mil_yn = mil_yn;
			}
			public String getMil_type() {
				return mil_type;
			}
			public void setMil_type(String mil_type) {
				this.mil_type = mil_type;
			}
			public String getMil_level() {
				return mil_level;
			}
			public void setMil_level(String mil_level) {
				this.mil_level = mil_level;
			}
			public String getMil_startdate() {
				return mil_startdate;
			}
			public void setMil_startdate(String mil_startdate) {
				this.mil_startdate = mil_startdate;
			}
			public String getMil_enddate() {
				return mil_enddate;
			}
			public void setMil_enddate(String mil_enddate) {
				this.mil_enddate = mil_enddate;
			}
			public String getJob_type() {
				return job_type;
			}
			public void setJob_type(String job_type) {
				this.job_type = job_type;
			}
			public String getGart_level() {
				return gart_level;
			}
			public void setGart_level(String gart_level) {
				this.gart_level = gart_level;
			}
			public String getSelp_intro() {
				return selp_intro;
			}
			public void setSelp_intro(String selp_intro) {
				this.selp_intro = selp_intro;
			}
			public String getCrm_name() {
				return crm_name;
			}
			public void setCrm_name(String crm_name) {
				this.crm_name = crm_name;
			}
			public MultipartFile getUpload_profile_image() {
				return upload_profile_image;
			}
			public void setUpload_profile_image(MultipartFile upload_profile_image) {
				this.upload_profile_image = upload_profile_image;
			}
			public String getProfile_image() {
				return profile_image;
			}
			public void setProfile_image(String profile_image) {
				this.profile_image = profile_image;
			}
			public MultipartFile getUpload_carrier_image() {
				return upload_carrier_image;
			}
			public void setUpload_carrier_image(MultipartFile upload_carrier_image) {
				this.upload_carrier_image = upload_carrier_image;
			}
			public String getCarrier_image() {
				return carrier_image;
			}
			public void setCarrier_image(String carrier_image) {
				this.carrier_image = carrier_image;
			}
			@Override
			public String toString() {
				return "InsaVo [sabun=" + sabun + ", join_day=" + join_day + ", retire_day=" + retire_day + ", put_yn="
						+ put_yn + ", name=" + name + ", reg_no=" + reg_no + ", eng_name=" + eng_name + ", phone="
						+ phone + ", hp=" + hp + ", position=" + position + ", pos_gbn_code=" + pos_gbn_code
						+ ", cmp_reg_no=" + cmp_reg_no + ", upload_cmp_reg_image=" + upload_cmp_reg_image
						+ ", cmp_reg_image=" + cmp_reg_image + ", sex=" + sex + ", years=" + years + ", email1="
						+ email1 + ", email2=" + email2 + ", email=" + email + ", zip=" + zip + ", addr1=" + addr1
						+ ", addr2=" + addr2 + ", dept_code=" + dept_code + ", join_gbn_code=" + join_gbn_code + ", id="
						+ id + ", pwd1=" + pwd1 + ", pwd2=" + pwd2 + ", pwd=" + pwd + ", salary=" + salary
						+ ", kosa_reg_yn=" + kosa_reg_yn + ", kosa_class_code=" + kosa_class_code + ", mil_yn=" + mil_yn
						+ ", mil_type=" + mil_type + ", mil_level=" + mil_level + ", mil_startdate=" + mil_startdate
						+ ", mil_enddate=" + mil_enddate + ", job_type=" + job_type + ", gart_level=" + gart_level
						+ ", selp_intro=" + selp_intro + ", crm_name=" + crm_name + ", upload_profile_image="
						+ upload_profile_image + ", profile_image=" + profile_image + ", upload_carrier_image="
						+ upload_carrier_image + ", carrier_image=" + carrier_image + ", andor=" + andor + ", pageSize="
						+ pageSize + ", listSize=" + listSize + ", totalRecord=" + totalRecord + ", totalPage="
						+ totalPage + ", nowRecord=" + nowRecord + ", nowPage=" + nowPage + ", startPage=" + startPage
						+ ", endPage=" + endPage + ", searchSabun=" + searchSabun + ", searchName=" + searchName
						+ ", searchJoin_gbn_code=" + searchJoin_gbn_code + ", searchPut_yn=" + searchPut_yn
						+ ", searchPosition=" + searchPosition + ", searchJoin_day=" + searchJoin_day
						+ ", searchRetire_day=" + searchRetire_day + ", searchJob_type=" + searchJob_type + "]";
			}
			
			
		
			
		    
			
		    
}
