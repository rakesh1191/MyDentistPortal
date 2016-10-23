package myDentist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myDentist.model.Appointments;
import myDentist.model.Patient;
import myDentist.model.User;
import myDentist.model.dao.appointmentsDao;
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
		System.out.println(user.getUserType());
		for(User u : userDao.getUsers()){
			if(user.getUsername().equals(u.getUsername())&& user.getUserPassword().equals(u.getUserPassword())){
				if(u.getUserType().equals("patient")){
					return "redirect:PatientHome.html";
				}else if(u.getUserType().equals("doctor")){
					return "redirect:DoctorHome.html";
				}else if(u.getUserType().equals("admin")){
					return "redirect:display.html";
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
		return "redirect:loginPage.html";
	}
	
	@RequestMapping(value="/appointment.html", method=RequestMethod.GET)
	public String takeAppointment(ModelMap models)
	{
		models.put("appointments", new Appointments());
		return "appointment";
		
	}
	
	@RequestMapping(value="/appointment.html",method=RequestMethod.POST)
	public String takeAppointment(@ModelAttribute("appointments") Appointments appointment,@RequestParam Integer id,BindingResult results)
	{		
		System.out.println("-------------"+id);
		appointment.setPatientId(patientDao.getPatient(id));
		System.out.println("value is :"+appointment.getAppointmentDate());
		appointment=appointmentsDao.saveAppointment(appointment);
		return "redirect:display.html";		
	}
	
	@RequestMapping(value="/PatientHome.html", method=RequestMethod.GET)
	public String PatientHom(ModelMap models)
	{
		return "PatientHome";
		
	}
}
