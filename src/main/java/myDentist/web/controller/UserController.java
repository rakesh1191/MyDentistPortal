package myDentist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
