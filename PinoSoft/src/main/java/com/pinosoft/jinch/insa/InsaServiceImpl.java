package com.pinosoft.jinch.insa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsaServiceImpl implements InsaService {

	@Autowired
	InsaDao insaDao;

	@Override
	public void insaInput(InsaVo vo) {
		insaDao.insaInput(vo);
	}
	@Override
	public List<Insa_ComVo> job_type_List() {
		// TODO Auto-generated method stub
		return insaDao.job_type_List();
	}

	@Override
	public List<Insa_ComVo> dept_code_List() {
		// TODO Auto-generated method stub
		return insaDao.dept_code_List();
	}

	@Override
	public List<Insa_ComVo> position_List() {
		// TODO Auto-generated method stub
		return insaDao.position_List();
	}

	@Override
	public List<Insa_ComVo> join_gbn_code_List() {
		// TODO Auto-generated method stub
		return insaDao.join_gbn_code_List();
	}
	@Override
	public List<Insa_ComVo> email_List() {
		return insaDao.email_List();
	}

	@Override
	public List<Insa_ComVo> put_yn_List() {
		// TODO Auto-generated method stub
		return insaDao.put_yn_List();
	}

	@Override
	public List<Insa_ComVo> sex_List() {
		// TODO Auto-generated method stub
		return insaDao.sex_List();
	}



	@Override
	public List<Insa_ComVo> gart_level_List() {
		// TODO Auto-generated method stub
		return insaDao.gart_level_List();
	}



	@Override
	public List<Insa_ComVo> mil_yn_List() {
		// TODO Auto-generated method stub
		return insaDao.mil_yn_List();
	}



	@Override
	public List<Insa_ComVo> mil_type_List() {
		// TODO Auto-generated method stub
		return insaDao.mil_type_List();
	}



	@Override
	public List<Insa_ComVo> mil_level_List() {
		// TODO Auto-generated method stub
		return insaDao.mil_level_List();
	}



	@Override
	public List<Insa_ComVo> kosa_reg_yn_List() {
		// TODO Auto-generated method stub
		return insaDao.kosa_reg_yn_List();
	}



	@Override
	public List<Insa_ComVo> kosa_class_code_List() {
		// TODO Auto-generated method stub
		return insaDao.kosa_class_code_List();
	}



	@Override
	public List<InsaVo> insaList(InsaVo vo) {
		// TODO Auto-generated method stub
		return insaDao.insaList(vo);
	}



	@Override
	public String getDeptCode(Insa_ComVo vo) {
		// TODO Auto-generated method stub
		return insaDao.getDeptCode(vo);
	}



	@Override
	public String getSeq() {
		// TODO Auto-generated method stub
		return insaDao.getSeq();
	}



	@Override
	public int getTotalRecord(InsaVo vo) {
		// TODO Auto-generated method stub
		return insaDao.getTotalRecord(vo);
	}
	@Override
	public InsaVo getInsa(InsaVo vo) {
		// TODO Auto-generated method stub
		return insaDao.getInsa(vo);
	}
	@Override
	public void insaDelete(InsaVo vo) {
		insaDao.insaDelete(vo);
		
	}
	@Override
	public void insaUpdate(InsaVo vo) {
		insaDao.insaUpdate(vo);
		
	}
	@Override
	public String getId(InsaVo vo) {
		// TODO Auto-generated method stub
		return insaDao.getId(vo);
	}
	@Override
	public String getProfile(InsaVo vo) {
		// TODO Auto-generated method stub
		return insaDao.getProfile(vo);
	}
	@Override
	public String getCmp(InsaVo vo) {
		// TODO Auto-generated method stub
		return insaDao.getCmp(vo);
	}
	@Override
	public String getCarrier(InsaVo vo) {
		// TODO Auto-generated method stub
		return insaDao.getCarrier(vo);
	}





}
