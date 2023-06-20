package com.service;

import java.util.List;

import com.model.LoginModel;
import com.model.RegistrationModel;

public interface RegService
{
	public void save(RegistrationModel rm);
	public RegistrationModel getRegModel(int id);
	public List<RegistrationModel> getAllRegModel();
	public void update(RegistrationModel rm);
	public void delete(int id);
	public List<RegistrationModel> doLogin(LoginModel lm);

}
