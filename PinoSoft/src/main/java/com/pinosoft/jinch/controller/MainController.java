 package com.pinosoft.jinch.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pinosoft.jinch.insa.InsaServiceImpl;
import com.pinosoft.jinch.insa.InsaVo;
import com.pinosoft.jinch.insa.Insa_ComVo;

@Controller

public class MainController {
	@Autowired
	InsaServiceImpl insaService;
<<<<<<< Updated upstream

	//깃 연동 테스트2
=======
	//깃허브 테스트용 주석입니다
	
>>>>>>> Stashed changes
	@RequestMapping("/test.do")
	public void test(InsaVo vo,HttpServletRequest request) {
		
		System.out.println(vo.getSabun());
		System.out.println(vo.getName());
		
	}
	
	@RequestMapping("/check_delete.do")
	public String check_delete(InsaVo vo,RedirectAttributes redirectAttributes,HttpServletRequest request) {
		String check_Sabun[] = vo.getCheck_Sabun();
		vo.setSearchSabun(vo.getSabun());
		for(int i=0;i<vo.getCheck_Cnt();i++) {
			vo.setSabun(check_Sabun[i]);
			
			String path1 = request.getSession().getServletContext().getRealPath("/img/profile/"); // 경로
			if(!insaService.getProfile(vo).equals("default.png")) { // 기본이미지가 아니라면
				File delfile = new File(path1 + insaService.getProfile(vo)); // 삭제할 파일 지정
				delfile.delete(); // 파일삭제
			}
			
			String path2 = request.getSession().getServletContext().getRealPath("/img/cmp_reg/"); // 경로
			if(!insaService.getCmp(vo).equals("noimage.jpg")) { // 기본이미지가 아니라면
				File delfile = new File(path2 + insaService.getCmp(vo)); // 삭제할 파일 지정
				delfile.delete(); // 파일삭제
			}
			
			String path3 = request.getSession().getServletContext().getRealPath("/img/carrier/"); // 경로
			if(!insaService.getCarrier(vo).equals("noimage.jpg")) { // 기본이미지가 아니라면
				File delfile = new File(path3 + insaService.getCarrier(vo)); // 삭제할 파일 지정
				delfile.delete(); // 파일삭제
			}
			
			insaService.insaDelete(vo);
		}
		System.out.println("삭제완료");
		vo.setSabun(vo.getSearchSabun());
		redirectAttributes.addFlashAttribute("vo", vo);
		return "redirect:insaListForm_Search.do";
	}
	
	@RequestMapping("/idCheck.do")
	public void idCheck(InsaVo vo,HttpServletResponse response) throws Exception {
		String idCheck = insaService.getId(vo);
		int flag = 0;
		
		PrintWriter out = response.getWriter();
		 if (idCheck == null) {
			 flag = 100; 
			 out.println(flag);
		 } else {
			 flag = 200; 
			 out.println(flag);
		 }
		 
	}
	
	@RequestMapping("/boot.do")
	public String boot() {
		return "boot";
	}
	
	
	@RequestMapping("/insaListForm.do")
	public String insaListForm(Model model) {
		model.addAttribute("join_gbn_code_List", insaService.join_gbn_code_List());
		model.addAttribute("put_yn_List", insaService.put_yn_List());
		model.addAttribute("position_List", insaService.position_List());
		model.addAttribute("job_type_List", insaService.job_type_List());
		return "insaListForm";
	}
	
	@RequestMapping("/insaListForm_Search.do")
	public String insaListForm_Search(InsaVo vo,Model model) {

		InsaVo searchVo = new InsaVo();
		InsaVo vo2 = new InsaVo();
		if((InsaVo)model.asMap().get("vo") != null) {
			vo = (InsaVo)model.asMap().get("vo");
		}
		if((InsaVo)model.asMap().get("searchVo") != null) {
			System.out.println("1");
			vo2 = (InsaVo)model.asMap().get("searchVo");
			System.out.println(vo2);
			//searchVo.setAndor(vo.getAndor());
			searchVo.setSabun(vo2.getSearchSabun());
			searchVo.setName(vo2.getSearchName());
			searchVo.setJoin_gbn_code(vo2.getSearchJoin_gbn_code());
			searchVo.setPut_yn(vo2.getSearchPut_yn());
			searchVo.setPosition(vo2.getSearchPosition());
			searchVo.setJoin_day(vo2.getSearchJoin_day());
			searchVo.setRetire_day(vo2.getSearchRetire_day());
			searchVo.setJob_type(vo2.getSearchJob_type());
			vo.setNowRecord(vo2.getNowRecord());
			System.out.println(searchVo.getNowRecord());
			model.addAttribute("insaList", insaService.insaList(searchVo));
			
		}
		else {
			System.out.println("2");
			//searchVo.setAndor(vo.getAndor());
			searchVo.setSabun(vo.getSabun());
			searchVo.setName(vo.getName());
			searchVo.setJoin_gbn_code(vo.getJoin_gbn_code());
			searchVo.setPut_yn(vo.getPut_yn());
			searchVo.setPosition(vo.getPosition());
			searchVo.setJoin_day(vo.getJoin_day());
			searchVo.setRetire_day(vo.getRetire_day());
			searchVo.setJob_type(vo.getJob_type());
			vo.setNowRecord(vo.getNowRecord());
			System.out.println(searchVo.getNowRecord());
			model.addAttribute("insaList", insaService.insaList(vo));
		}
		vo.setPageSize(10); // 페이지 사이즈
		vo.setListSize(10); // 리스트 사이즈
		vo.setTotalRecord(insaService.getTotalRecord(searchVo)); //총 레코드
		if(vo.getTotalRecord() % 10 == 0) { // 총 페이지
			vo.setTotalPage(vo.getTotalRecord()/vo.getListSize());
		}
		else {
			vo.setTotalPage(vo.getTotalRecord()/vo.getListSize()+1);
		}
		
		if(vo.getNowRecord() == 0) { // 현재 레코드
			vo.setNowRecord(1);
			vo.setNowPage(1); // 현재 페이지
		}
		else {
			vo.setNowPage(vo.getNowRecord()/vo.getListSize()+1);
		}
		
		vo.setStartPage((vo.getNowPage()-1)/vo.getPageSize()*vo.getPageSize()+1); // 하단 시작
		vo.setEndPage(vo.getStartPage()+vo.getPageSize()-1); // 하단 끝

		model.addAttribute("paging", vo);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("join_gbn_code_List", insaService.join_gbn_code_List());
		model.addAttribute("put_yn_List", insaService.put_yn_List());
		model.addAttribute("position_List", insaService.position_List());
		model.addAttribute("job_type_List", insaService.job_type_List());
		
		return "insaListForm";
	}
	
	
	@RequestMapping("/insaInputForm.do")
	public String indaInputForm(Model model) {
		model.addAttribute("job_type_List", insaService.job_type_List());
		model.addAttribute("dept_code_List", insaService.dept_code_List());
		model.addAttribute("position_List", insaService.position_List());
		model.addAttribute("join_gbn_code_List", insaService.join_gbn_code_List());
		model.addAttribute("put_yn_List", insaService.put_yn_List());
		model.addAttribute("sex_List", insaService.sex_List());
		model.addAttribute("email_List", insaService.email_List());
		model.addAttribute("gart_level_List", insaService.gart_level_List());
		model.addAttribute("mil_yn_List", insaService.mil_yn_List());
		model.addAttribute("mil_type_List", insaService.mil_type_List());
		model.addAttribute("mil_level_List", insaService.mil_level_List());
		model.addAttribute("kosa_reg_yn_List", insaService.kosa_reg_yn_List());
		model.addAttribute("kosa_class_code_List", insaService.kosa_class_code_List());
		return "insaInputForm";
	}
	
	@RequestMapping("/insaInput.do")
	public String insaInput(InsaVo vo,HttpServletRequest request) throws Exception {
		if(vo.getMil_yn().equals("") || vo.getMil_yn().equals("N")) {
			vo.setMil_yn("N");
			vo.setMil_type("");
			vo.setMil_enddate("");
			vo.setMil_level("");
			vo.setMil_startdate("");
		}

		String year = vo.getJoin_day().substring(2, 4); // xx년도
		String dept = null;
		if(vo.getDept_code().equals("none")) {
			dept = "000";
		}
		else {
			Insa_ComVo insa_ComVo = new Insa_ComVo();
			insa_ComVo.setName(vo.getDept_code());
			dept = insaService.getDeptCode(insa_ComVo); // 부서코드
		}
		String seq = insaService.getSeq(); // 시퀀스
		String sabun = year+dept+seq;
		vo.setSabun(sabun);
		String salary = vo.getSalary().replace(",", "");
		vo.setSalary(salary);
		
		
		
		MultipartFile upload_cmp_reg_image = vo.getUpload_cmp_reg_image(); // 업로드 받기
		String path = request.getSession().getServletContext().getRealPath("/img/cmp_reg/"); //경로
		if(!upload_cmp_reg_image.isEmpty()) { //업로드가 존재하면
			String fileName = upload_cmp_reg_image.getOriginalFilename(); //실제 파일 이름
			File file = new File(path + fileName); //파일경로와 이름을 가지고
			if(file.exists()) { //파일이 이미 존재하면		
				String onlyFileName = fileName.substring(0, fileName.indexOf(".")); //파일명
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); //날짜포맷
				String time = sdf.format(new Date()); //중복방지용 날짜
				String extension = fileName.substring(fileName.indexOf(".")); //확장자
				fileName = onlyFileName+time+extension; //최종 파일이름
			}
			vo.setCmp_reg_image(fileName);
			upload_cmp_reg_image.transferTo(new File(path + fileName)); //저장하는 부분,java.io 임포트
			System.out.println(path + fileName);
		}
		else {
			vo.setCmp_reg_image("noimage.jpg"); //업로드가 없으면 기본 이미지
		}
		
		
		MultipartFile upload_profile_image = vo.getUpload_profile_image(); // 업로드 받기
		path = request.getSession().getServletContext().getRealPath("/img/profile/"); //경로
		if(!upload_profile_image.isEmpty()) { //업로드가 존재하면
			String fileName = upload_profile_image.getOriginalFilename(); //실제 파일 이름
			File file = new File(path + fileName); //파일경로와 이름을 가지고
			if(file.exists()) { //파일이 이미 존재하면		
				String onlyFileName = fileName.substring(0, fileName.indexOf(".")); //파일명
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); //날짜포맷
				String time = sdf.format(new Date()); //중복방지용 날짜
				String extension = fileName.substring(fileName.indexOf(".")); //확장자
				fileName = onlyFileName+time+extension; //최종 파일이름
			}
			vo.setProfile_image(fileName);
			upload_profile_image.transferTo(new File(path + fileName)); //저장하는 부분,java.io 임포트
			System.out.println(path + fileName);
		}
		else {
			vo.setProfile_image("default.png"); //업로드가 없으면 기본 이미지
		}
		MultipartFile upload_carrier_image = vo.getUpload_carrier_image(); // 업로드 받기
		path = request.getSession().getServletContext().getRealPath("/img/carrier/"); //경로
		if(!upload_carrier_image.isEmpty()) { //업로드가 존재하면
			String fileName = upload_carrier_image.getOriginalFilename(); //실제 파일 이름
			File file = new File(path + fileName); //파일경로와 이름을 가지고
			if(file.exists()) { //파일이 이미 존재하면		
				String onlyFileName = fileName.substring(0, fileName.indexOf(".")); //파일명
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); //날짜포맷
				String time = sdf.format(new Date()); //중복방지용 날짜
				String extension = fileName.substring(fileName.indexOf(".")); //확장자
				fileName = onlyFileName+time+extension; //최종 파일이름
			}
			vo.setCarrier_image(fileName);
			upload_carrier_image.transferTo(new File(path + fileName)); //저장하는 부분,java.io 임포트
			System.out.println(path + fileName);
			
		}
		else {
			vo.setCarrier_image("noimage.jpg"); //업로드가 없으면 기본 이미지
		}
		String pwd = vo.getPwd1();
		String email = vo.getEmail1()+"@"+vo.getEmail2();
		vo.setPwd(pwd);
		vo.setEmail(email);
		insaService.insaInput(vo); // 입력
		System.out.println("입력완료");

		return "redirect:insaInputForm.do";
		
	}

	@RequestMapping("/insaDelete.do")
	public String insaDelete(InsaVo vo,RedirectAttributes redirectAttributes,HttpServletRequest request) {
		String path1 = request.getSession().getServletContext().getRealPath("/img/profile/"); // 경로
		if(!insaService.getProfile(vo).equals("default.png")) { // 기본이미지가 아니라면
			File delfile = new File(path1 + insaService.getProfile(vo)); // 삭제할 파일 지정
			delfile.delete(); // 파일삭제
		}
		
		String path2 = request.getSession().getServletContext().getRealPath("/img/cmp_reg/"); // 경로
		if(!insaService.getCmp(vo).equals("noimage.jpg")) { // 기본이미지가 아니라면
			File delfile = new File(path2 + insaService.getCmp(vo)); // 삭제할 파일 지정
			delfile.delete(); // 파일삭제
		}
		
		String path3 = request.getSession().getServletContext().getRealPath("/img/carrier/"); // 경로
		if(!insaService.getCarrier(vo).equals("noimage.jpg")) { // 기본이미지가 아니라면
			File delfile = new File(path3 + insaService.getCarrier(vo)); // 삭제할 파일 지정
			delfile.delete(); // 파일삭제
		}
		insaService.insaDelete(vo);
		System.out.println("삭제완료");
		vo.setSabun(vo.getSearchSabun());
		redirectAttributes.addFlashAttribute("vo", vo);
		return "redirect:insaListForm_Search.do";
	}
	
	@RequestMapping("/insaUpdateForm.do")
	public String insaUpdateForm(InsaVo vo,Model model) throws Exception {
		//System.out.println(vo.toString());
		InsaVo insaVo = new InsaVo();
		insaVo = insaService.getInsa(vo);
		String email[] = insaVo.getEmail().split("@");
		insaVo.setEmail1(email[0]);
		insaVo.setEmail2(email[1]);
		
		

		model.addAttribute("getInsa", insaVo);
		model.addAttribute("searchVo", vo);
		model.addAttribute("job_type_List", insaService.job_type_List());
		model.addAttribute("dept_code_List", insaService.dept_code_List());
		model.addAttribute("position_List", insaService.position_List());
		model.addAttribute("join_gbn_code_List", insaService.join_gbn_code_List());
		model.addAttribute("put_yn_List", insaService.put_yn_List());
		model.addAttribute("sex_List", insaService.sex_List());
		model.addAttribute("email_List", insaService.email_List());
		model.addAttribute("gart_level_List", insaService.gart_level_List());
		model.addAttribute("mil_yn_List", insaService.mil_yn_List());
		model.addAttribute("mil_type_List", insaService.mil_type_List());
		model.addAttribute("mil_level_List", insaService.mil_level_List());
		model.addAttribute("kosa_reg_yn_List", insaService.kosa_reg_yn_List());
		model.addAttribute("kosa_class_code_List", insaService.kosa_class_code_List());
		return "insaUpdateForm";
	}
	
	@RequestMapping("/insaUpdate.do")
	public String insaUpdate(InsaVo vo,Model model,RedirectAttributes redirectAttributes,HttpServletRequest request) throws Exception {
		String salary = vo.getSalary().replace(",", "");
		String pwd = vo.getPwd1();
		String email = vo.getEmail1()+"@"+vo.getEmail2();
		if(vo.getMil_yn().equals("") || vo.getMil_yn().equals("N")) {
			vo.setMil_yn("N");
			vo.setMil_type("");
			vo.setMil_enddate("");
			vo.setMil_level("");
			vo.setMil_startdate("");
		}
		vo.setPwd(pwd);
		vo.setEmail(email);
		vo.setSalary(salary);
		
		//프로필
		MultipartFile upload_profile_image = vo.getUpload_profile_image(); // 업로드 받기
		String path1 = request.getSession().getServletContext().getRealPath("/img/profile/"); //경로
		if(!upload_profile_image.isEmpty()) { // 업로드가 존재하면
			String fileName1 = upload_profile_image.getOriginalFilename(); // 실제 파일 이름
			File file = new File(path1 + fileName1); //파일경로와 이름을 가지고
			if(file.exists()) { //파일이 이미 존재하면
				String onlyFileName = fileName1.substring(0, fileName1.indexOf(".")); //파일명
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); //날짜포맷
				String time = sdf.format(new Date()); //중복방지용 날짜
				String extension = fileName1.substring(fileName1.indexOf(".")); //확장자
				fileName1 = onlyFileName+time+extension; //최종 파일이름
			}
			vo.setProfile_image(fileName1); // 파일이름 Set
			if(!insaService.getProfile(vo).equals("default.png")) { // 기본이미지가 아니라면
				File delfile = new File(path1 + insaService.getProfile(vo)); // 삭제할 파일 지정
				delfile.delete(); // 파일삭제
			}
			upload_profile_image.transferTo(new File(path1 + fileName1)); // 저장하는 부분,java.io 임포트
		}
		else { //사진을 안바꾸면
			vo.setProfile_image(insaService.getProfile(vo)); //기존 파일 그대로 유지
		}

		//사업자 등록증
		MultipartFile upload_cmp_reg_image = vo.getUpload_cmp_reg_image(); // 업로드 받기
		String path2 = request.getSession().getServletContext().getRealPath("/img/cmp_reg/"); //경로
		if(!upload_cmp_reg_image.isEmpty()) { // 업로드가 존재하면
			String fileName2 = upload_cmp_reg_image.getOriginalFilename(); // 실제 파일 이름
			File file = new File(path2 + fileName2); //파일경로와 이름을 가지고
			if(file.exists()) { //파일이 이미 존재하면
				String onlyFileName = fileName2.substring(0, fileName2.indexOf(".")); //파일명
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); //날짜포맷
				String time = sdf.format(new Date()); //중복방지용 날짜
				String extension = fileName2.substring(fileName2.indexOf(".")); //확장자
				fileName2 = onlyFileName+time+extension; //최종 파일이름
			}
			vo.setCmp_reg_image(fileName2); // 파일이름 Set
			if(!insaService.getCmp(vo).equals("noimage.jpg")) { // 기본이미지가 아니라면
				File delfile = new File(path2 + insaService.getCmp(vo)); // 삭제할 파일 지정
				delfile.delete(); // 파일삭제
			}
			upload_cmp_reg_image.transferTo(new File(path2 + fileName2)); // 저장하는 부분,java.io 임포트
		}
		else { //사진을 안바꾸면
			vo.setCmp_reg_image(insaService.getCmp(vo)); //기존 파일 그대로 유지
		}

		//이력서
		MultipartFile upload_carrier_image = vo.getUpload_carrier_image(); // 업로드 받기
		String path3 = request.getSession().getServletContext().getRealPath("/img/carrier/"); //경로
		if(!upload_carrier_image.isEmpty()) { // 업로드가 존재하면
			String fileName3 = upload_carrier_image.getOriginalFilename(); // 실제 파일 이름
			File file = new File(path3 + fileName3); //파일경로와 이름을 가지고
			if(file.exists()) { //파일이 이미 존재하면
				String onlyFileName = fileName3.substring(0, fileName3.indexOf(".")); //파일명
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); //날짜포맷
				String time = sdf.format(new Date()); //중복방지용 날짜
				String extension = fileName3.substring(fileName3.indexOf(".")); //확장자
				fileName3 = onlyFileName+time+extension; //최종 파일이름
			}
			vo.setCarrier_image(fileName3); // 파일이름 Set
			if(!insaService.getCarrier(vo).equals("noimage.jpg")) { // 기본이미지가 아니라면
				File delfile = new File(path3 + insaService.getCarrier(vo)); // 삭제할 파일 지정
				delfile.delete(); // 파일삭제
			}
			upload_carrier_image.transferTo(new File(path3 + fileName3)); // 저장하는 부분,java.io 임포트
		}
		else { //사진을 안바꾸면
			vo.setCarrier_image(insaService.getCarrier(vo)); //기존 파일 그대로 유지
		}
				
		insaService.insaUpdate(vo);
		System.out.println("수정완료");
		//System.out.println(vo.toString());
		System.out.println("현재 : " + vo.getNowRecord());
		redirectAttributes.addFlashAttribute("searchVo", vo);
		return "redirect:insaListForm_Search.do";
	}
}
