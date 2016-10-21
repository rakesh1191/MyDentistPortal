package myDentist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myDentist.model.User;
import myDentist.model.dao.userDao;

@Controller
public class UserController {
	
	@Autowired
	private userDao userDao;
	
	@RequestMapping("/display.html")
	public String displayUser(ModelMap models)
	{
		
		models.put("users", userDao.getUsers());
		return "display";
	}
	
	@RequestMapping(value="/loginPage.html", method=RequestMethod.GET)
	public String loginPage(ModelMap models)
	{	
		models.put("users", userDao.getUsers());
		return "loginPage";
	}
	
	@RequestMapping(value="/loginPage.html", method=RequestMethod.POST)
	public String loginPage(@ModelAttribute ("user") User user,BindingResult result, ModelMap models)
	{	
		System.out.println(user.getUsername());
		System.out.println(user.getUserPassword());
		for(User u : userDao.getUsers()){
			if(user.getUsername().equals(u.getUsername())&& user.getUserPassword().equals(u.getUserPassword())){
				return "redirect:display.html";
			}
				
		}
		if(!result.hasErrors()){
			return "loginPage.html";
		}
		return "loginPage.html";
	}
	
	@RequestMapping(value="/PatientRegistration.html", method=RequestMethod.GET)
	public String PatientRegistration(ModelMap models)
	{	
		models.put("user", new User());
		return "PatientRegistration";
	}
	
	@RequestMapping(value="/PatientRegistration.html", method=RequestMethod.POST)
	public String PatientRegistration(@ModelAttribute ("User") User user, BindingResult result)
	{	
		user.setUserType("patient");
		// save user to database
		user=userDao.saveUser(user);
		System.out.println("Data saved in db :"+user.getUsername());
		//redirect to display page
		return "redirect:loginPage.html";
	}
}
