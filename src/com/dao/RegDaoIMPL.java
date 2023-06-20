package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.LoginModel;
import com.model.RegistrationModel;

@Repository
public class RegDaoIMPL implements RegDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(RegistrationModel rm) {
		// TODO Auto-generated method stub
        sessionFactory.getCurrentSession().save(rm);
	}

	@Override
	public RegistrationModel getRegModel(int id)
	{
		RegistrationModel model = (RegistrationModel) sessionFactory.getCurrentSession().get(RegistrationModel.class,id);
		return model;
	}

	@Override
	public List<RegistrationModel> getAllRegModel() {
		List<RegistrationModel> list=sessionFactory.getCurrentSession().createQuery("from RegistrationModel").list();
		return list;
		}

	@Override
	public void update(RegistrationModel rm) {
		sessionFactory.getCurrentSession().update(rm);
	}

	@Override
	public void delete(int id)
	{
		RegistrationModel model = (RegistrationModel) sessionFactory.getCurrentSession().get(RegistrationModel.class,id);
		sessionFactory.getCurrentSession().delete(model);

	}

	@Override
	public List<RegistrationModel> doLogin(LoginModel lm) {
		String hql ="FROM RegistrationModel R WHERE R.email='"+lm.getEmail()+"' and R.password ='"+lm.getPassword()+"' ";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		List<RegistrationModel> result = query.list();
		List<RegistrationModel> res =result.size()>0?result:null;
		return res;
	}

}
