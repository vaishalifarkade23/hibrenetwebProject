package com.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.model.LoginModel;
import com.model.RegistrationModel;
import com.service.RegService;

@Controller
public class HandlingController
{
	@Autowired
	private RegService regservice;
	
	@RequestMapping("/viewform")
	public String getLoginForm()
	{
		return "LoginForm";
	}
	
	@RequestMapping("/SignUpForm")
	public String getSignup()
	{
		return "Registration";
	}
	
	@RequestMapping("/dummy")
	public String get()
	{
		return  "LoginForm";
	}
	@RequestMapping(value="val" ,method=RequestMethod.POST)
	public String getSave(@ModelAttribute ("rm") RegistrationModel rm)
	{
		regservice.save(rm);
		return  "redirect:/dummy";
	}
	
	@RequestMapping(value="dologin" ,method=RequestMethod.POST)
	public String doLogin(@ModelAttribute ("log") LoginModel log,HttpSession session ,Model m)
	{
		List<RegistrationModel> list =regservice.doLogin(log);
		//for alret massage
		
		session.setAttribute("list", list);
		
		if(list == null)
		{
			return "LoginForm";
		}
		else
		{
			session.setAttribute("sesuser", log.getEmail());
			//return "dashboard";
			return "redirect:/getdetails";
		}
	}
	
	@RequestMapping("/getdetails")
	public String getAllRegModel(Model model)
	{
		List<RegistrationModel> list= regservice.getAllRegModel();
		model.addAttribute("list", list);
		return "dashboard";
	}
	
//	@RequestMapping("delete/{id}")
//	public String deleteEmpById(@PathVariable int id)
//	{
//		regservice.delete(id);
//		return "dashboard";
//	}
//	
//	@RequestMapping("edit/{id}")
//	public String getRegModel(@PathVariable int id,HttpSession session)
//	{
//		RegistrationModel model = regservice.getRegModel(id);
//		session.setAttribute("reg", model);
//		return "EditRegistractionForm";
//	}
//	
//	@RequestMapping(value="update",method=RequestMethod.POST)
//	public String update(@ModelAttribute ("reg") RegistrationModel reg)
//	{
//		regservice.update(reg);
//		return "dashboard";
//	}

	/*@RequestMapping(value="getdashboard",method=RequestMethod.POST)
	public String getDashboard()
	{
		return "dashboard";
	}*/
	
	
}
