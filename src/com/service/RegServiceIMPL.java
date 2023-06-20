package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.RegDao;
import com.model.LoginModel;
import com.model.RegistrationModel;
@Service
public class RegServiceIMPL implements RegService {
	
	@Autowired
	private RegDao dao;
	
	@Transactional
	@Override
	public void save(RegistrationModel rm) {
		// TODO Auto-generated method stub
        dao.save(rm);
	}
	
	@Transactional
	@Override
	public RegistrationModel getRegModel(int id) {
		RegistrationModel reg = dao.getRegModel(id);
		return reg;
	}
	
	@Transactional
	@Override
	public List<RegistrationModel> getAllRegModel() {
		// TODO Auto-generated method stub
		List<RegistrationModel> list= dao.getAllRegModel();
		return list;
	}
	
	@Transactional
	@Override
	public void update(RegistrationModel rm) {
		dao.update(rm);

	}
	
	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);

	}
	
	@Transactional
	@Override
	public List<RegistrationModel> doLogin(LoginModel lm) {
		List<RegistrationModel> list = dao.doLogin(lm);
		return list;
	}

}
