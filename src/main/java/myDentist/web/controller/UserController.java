package myDentist.web.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import myDentist.model.Appointments;
import myDentist.model.Patient;
import myDentist.model.User;
import myDentist.model.dao.appointmentsDao;
import myDentist.model.dao.doctorDao;
import myDentist.model.dao.patientDao;
import myDentist.model.dao.userDao;
import myDentist.model.dao.jpa.appointmentsDaoImpl;

@Controller
public class UserController {
	
	@Autowired
	private userDao userDao;
	
	@Autowired
	private appointmentsDao appointmentsDao;
	
	@Autowired
	private patientDao patientDao;
	
	
	@RequestMapping("/display.html")
	public String displayUser(ModelMap models)
	{
		
		models.put("users", userDao.getUsers());
		return "display";
	}
	
	@RequestMapping("/logout.html")
	public String loginOut(HttpSession session)
	{	
		//if(session!=null)
		session.invalidate();
		//models.put("users", userDao.getUsers());
		return "logout.html";
	}
	
	@RequestMapping("/adminHome.html")
	public String adminHome(ModelMap models)
	{
		models.put("appointments", appointmentsDao.getAppointments());
		return "adminHome";
	}
	
	@RequestMapping(value="/loginPage.html", method=RequestMethod.GET)
	public String loginPage(ModelMap models)
	{	
		models.put("users", userDao.getUsers());
		return "loginPage";
	}
	int uid=0;
	@RequestMapping(value="/loginPage.html", method=RequestMethod.POST)
	public String loginPage(@ModelAttribute ("user") User user,BindingResult result, ModelMap models,SessionStatus status)
	{	
		System.out.println(user.getUsername());
		System.out.println(user.getUserPassword());
		System.out.println(user.getUserType());
		
		for(User u : userDao.getUsers()){
			if(user.getUsername().equals(u.getUsername())&& user.getUserPassword().equals(u.getUserPassword())){
				if(u.getUserType().equals("patient")){
					models.put("userid", u.getUserId());
					//uid=u.getUserId();
					status.setComplete();
					return "redirect:PatientHome.html";
				}else if(u.getUserType().equals("doctor")){
					models.put("userid", u.getUserId());
					uid=u.getUserId();
					status.setComplete();
					return "redirect:doctorHome.html";
				}else if(u.getUserType().equals("admin")){
					uid=u.getUserId();
					status.setComplete();
					return "redirect:adminHome.html";
				}
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
	
	@RequestMapping(value="/doctorRegistration.html", method=RequestMethod.GET)
	public String doctorRegistration(ModelMap models)
	{	
		models.put("user", new User());
		return "doctorRegistration";
	}
	
	@RequestMapping(value="/doctorRegistration.html", method=RequestMethod.POST)
	public String doctorRegistration(@ModelAttribute ("User") User user, BindingResult result)
	{	
		user.setUserType("doctor");
		// save user to database
		user=userDao.saveUser(user);
		System.out.println("Data saved in db :"+user.getUsername());
		//redirect to display page
		return "redirect:doctorHome.html";
	}
	
	@RequestMapping(value="/editPatient.html", method=RequestMethod.GET)
	public String editPatient(ModelMap models,@RequestParam Integer userid)
	{	
		User u=userDao.getUser(userid);
		models.put("user", u);
		return "editPatient";
	}
	
	@RequestMapping(value="/editPatient.html", method=RequestMethod.POST)
	public String editPatient(@ModelAttribute ("user") User user,@RequestParam Integer userid)
	{	
		User u=userDao.getUser(userid);
		user.setUsername(u.getUsername());
		user.setUserPassword(u.getUserPassword());
		user.setUserType(u.getUserType());
		user.setDateOfBirth(u.getDateOfBirth());
		user.setUserId(userid);
		user=userDao.saveUser(user);
		return "redirect:PatientHome.html?userid="+userid;
	}
	
}
