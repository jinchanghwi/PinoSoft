package com.pinosoft.jinch.insa;

import java.util.List;

public interface InsaService {
	public List<Insa_ComVo> job_type_List(); // 01
	public List<Insa_ComVo> dept_code_List(); // 02
	public List<Insa_ComVo> position_List(); // 03
	public List<Insa_ComVo> join_gbn_code_List(); // 04
	public List<Insa_ComVo> put_yn_List(); // 05
	public List<Insa_ComVo> sex_List(); // 06
	public List<Insa_ComVo> email_List(); // 07
	public List<Insa_ComVo> gart_level_List(); // 08
	public List<Insa_ComVo> mil_yn_List(); // 09
	public List<Insa_ComVo> mil_type_List(); // 10
	public List<Insa_ComVo> mil_level_List(); // 11
	public List<Insa_ComVo> kosa_reg_yn_List(); // 12
	public List<Insa_ComVo> kosa_class_code_List(); // 13
	
	public List<InsaVo> insaList(InsaVo vo);
	public InsaVo getInsa(InsaVo vo);
	public String getDeptCode(Insa_ComVo vo);
	public String getSeq();
	public String getId(InsaVo vo);
	public String getProfile(InsaVo vo);
	public String getCmp(InsaVo vo);
	public String getCarrier(InsaVo vo);
	public int getTotalRecord(InsaVo vo);
	public void insaInput(InsaVo vo);
	public void insaDelete(InsaVo vo);
	public void insaUpdate(InsaVo vo);
}
