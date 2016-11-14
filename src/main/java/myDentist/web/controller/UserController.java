package myDentist.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Dictionary;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
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
import myDentist.model.Doctor;
import myDentist.model.MakeAvailability;
import myDentist.model.Patient;
import myDentist.model.User;
import myDentist.model.dao.MakeAvailabilityDao;
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
	private doctorDao doctorDao;
	
	@Autowired
	private MakeAvailabilityDao makeAvailabilityDao;
	
	@RequestMapping("/display.html")
	public String displayUser(ModelMap models)
	{
		
		models.put("users", userDao.getUsers());
		return "display";
	}
	
	
	@RequestMapping("/adminHome.html")
	public String adminHome(ModelMap models)
	{
		models.put("appointments", appointmentsDao.getAppointments());
		return "adminHome";
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
		Set<String> roles =new HashSet<String>();
		roles.add("ROLE_USER");
		user.setRoles(roles);
		user=userDao.saveUser(user);
		System.out.println("Data saved in db :"+user.getUsername());
		
		//redirect to display page
		return "redirect:/users/Home.html?userid="+user.getUserId();
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
		Integer id=user.getUserId();
		Set<String> roles =new HashSet<String>();
		roles.add("ROLE_DOCTOR");
		user.setRoles(roles);
		user=userDao.saveUser(user);		
		System.out.println("Data saved in db :"+user.getUsername());
		//redirect to display page
		return "redirect:/users/Home.html?userid="+id;
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
		user.setPassword(u.getPassword());
		user.setUserType(u.getUserType());
		user.setDateOfBirth(u.getDateOfBirth());
		user.setUserId(userid);
		user=userDao.saveUser(user);
		return "redirect:/users/Home.html?userid="+userid;
	}
	
	@RequestMapping(value="/users/editUser.html", method=RequestMethod.GET)
	public String editUser(ModelMap models,@RequestParam Integer userid)
	{	
		User u=userDao.getUser(userid);
		models.put("alluser", u);
		models.put("userid", userid);
		return "/users/editUser";
	}
	

	@RequestMapping(value="/users/editUser.html", method=RequestMethod.POST)
	public String editUser(@RequestParam Integer userid,@RequestParam(required=false) String Enable,@RequestParam(required=false) String Disable)
	{	
		User u=userDao.getUser(userid);
		if(Enable!=null){
			u.setEnabled(true);
			Set<String> roles =new HashSet<String>();
			if(u.getUserType().matches("patient")){
				roles.add("ROLE_USER");
			}else if(u.getUserType().matches("doctor")){
				roles.add("ROLE_DOCTOR");
			}else{
				roles.add("ROLE_ADMIN");
			}
			u.setRoles(roles);
		}else{
			u.setEnabled(false);
		}
		userDao.saveUser(u);
		return "redirect:/users/Home.html?userid="+userid;
	}
	
	@RequestMapping(value="/setScheduleDoctor.html",method=RequestMethod.GET)
	public String setSDoctor(ModelMap models, @RequestParam Integer userid)	{
		
		Calendar now = Calendar.getInstance();
	    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	    String[] days = new String[7];
	    int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 2; 
	    for (int i = 0; i < 7; i++)
	    {
	        days[i] = format.format(now.getTime());
	        now.add(Calendar.DATE, 1);
	    }
	    System.out.println(Arrays.toString(days));
	    models.put("dates", days);
	    models.put("userid", userid);
	    java.util.List<String> slots=Arrays.asList("9-10","10-11","11-12","12-1","1-2","2-3","3-4","4-5");
	    models.put("slots",slots);
			//look for previous records
			List<Boolean> bslot=new ArrayList<>();
			HashMap<String, List<Boolean>> dc = new HashMap<String, List<Boolean>>();
			dc.put("date", bslot);
			List<MakeAvailability> make=makeAvailabilityDao.getAvailabilities();
			for (MakeAvailability mA : make) {
				if(mA.getDoctorId().getUserId().getUserId().equals(userid)&& Arrays.asList(days).contains(mA.getAvailableDate())){	
					bslot=Arrays.asList(mA.isSlot910(),mA.isSlot1011(),mA.isSlot1112(),mA.isSlot121(),
							mA.isSlot12(),mA.isSlot23(),mA.isSlot34(),mA.isSlot45());
					dc.put(mA.getAvailableDate(), bslot);
				}
			}
			models.put("hashset", dc);
			//
		 	
		return "setScheduleDoctor";
	}
	
	@RequestMapping(value="/setScheduleDoctor.html", method=RequestMethod.POST)
	public String setSDoctor(@RequestParam java.util.List<String> getindex, @RequestParam Integer userid, ModelMap models)	{
		
		System.out.println("result is"+getindex);
		
		for (String g : getindex) {
			String[] date=g.split(" ");
			String slot =date[0];
			String str = slot.replace("-", "");
			System.out.println("slot is  :"+str);
			String availableDate = date[1];
			//
			Random rand = new Random();
			int  n = rand.nextInt(1000) + 1;		
			Integer id = n;
			System.out.println("ID is : "+id);
			List<Doctor> d=doctorDao.getDoctorbyUserId(userid);
			List<MakeAvailability> m= makeAvailabilityDao.getAvailabilities();
			List<String> dts=new ArrayList<String>();
			int prevoiusID=0;
			for (MakeAvailability makeAvailability : m) {
				dts.add(makeAvailability.getAvailableDate());
				if(makeAvailability.getAvailableDate().matches(availableDate)){
					 prevoiusID= makeAvailability.getmId();
				}
			}
			if(dts.contains(availableDate)){
				makeAvailabilityDao.updateSlots(str, availableDate,prevoiusID, d.get(0));
			}else{
				makeAvailabilityDao.setSlots(str,availableDate,id,d.get(0));
			}
		}
		return "redirect:/users/Home.html?userid="+userid;
	}
	
	@RequestMapping(value="/users/changePassword.html", method=RequestMethod.GET)
	public String changePassword(ModelMap models,@RequestParam Integer userid)
	{	
		User u=userDao.getUser(userid);
		models.put("user", u);
		models.put("userid", userid);
		return "/users/changePassword";
	}
	
	@RequestMapping(value="/users/changePassword.html", method=RequestMethod.POST)
	public String changePassword(@RequestParam Integer userid,@RequestParam String inputPassword,@RequestParam String previousPassword)
	{	
		User u=userDao.getUser(userid);
		if(previousPassword.equals(u.getPassword())){
			//System.out.println(previousPassword);
			u.setPassword(inputPassword);
			userDao.saveUser(u);
		}
		return "redirect:/users/Home.html?userid="+userid;
	}
}
