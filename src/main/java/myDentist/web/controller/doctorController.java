package myDentist.web.controller;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myDentist.model.Appointments;
import myDentist.model.Doctor;
import myDentist.model.Patient;
import myDentist.model.User;
import myDentist.model.dao.appointmentsDao;
import myDentist.model.dao.doctorDao;
import myDentist.model.dao.patientDao;
import myDentist.model.dao.userDao;

@Controller
public class doctorController {

	@Autowired
	private userDao userDao;
	
	@Autowired
	private appointmentsDao appointmentsDao;
	
	@Autowired
	private doctorDao doctorDao;
	
	@Autowired
	private patientDao patientDao;
	
	@RequestMapping(value="/users/Home.html",method=RequestMethod.GET)
	public String doctorH(ModelMap models)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user= userDao.getUserByUsername(currentPrincipalName);
		models.put("userid",user.getUserId());
		models.put("users",user);
		models.put("alluser", userDao.getUsers());
		models.put("appointments",appointmentsDao.getAppointments());
		List<Doctor> d=doctorDao.getDoctorbyUserId(user.getUserId());
		try{
		models.put("doctorid", d.get(0).getDoctorId());
		}catch (Exception e) {
			// TODO: handle exception
		}
		//System.out.println("mmm"+);
		System.out.println("user 1"+currentPrincipalName);
		return "/users/Home";
	}
	
	@RequestMapping(value="/users/Home.html",method=RequestMethod.POST)
	public String doctorH(@RequestParam Integer userid)
	{
		System.out.println("user 2"+userid);
		return "redirect:/users/Home.html?userid="+userid;
	}
	
	@RequestMapping(value="/doctorHome.html",method=RequestMethod.GET)
	public String doctorHome(ModelMap models,@RequestParam Integer userid)
	{
		models.put("userid", userid);
		List<Doctor> d=doctorDao.getDoctorbyUserId(userid);
		models.put("doctorname", d.get(0).getDoctorName().toString());
		models.put("doctorid", d.get(0).getDoctorId());
		models.put("appointments", appointmentsDao.getAppointments());
		//System.out.println("mmm"+);
		System.out.println("user 1"+userid);
		return "doctorHome";
	}
	
	@RequestMapping(value="/doctorHome.html",method=RequestMethod.POST)
	public String doctorHome(@RequestParam Integer userid)
	{
		System.out.println("user 2"+userid);
		return "redirect:users/profile.html?userid="+userid;
	}
	
	@RequestMapping(value="users/doctorProfile.html",method=RequestMethod.GET)
	public String doctorProfile(ModelMap models,@RequestParam Integer userid)
	{
		System.out.println("user 3"+userid);
		models.put("userid", userid);
		models.put("users", userDao.getUsers());
		models.put("doctors", doctorDao.getDoctors());
		return "users/doctorProfile";
	}
	
	@RequestMapping(value="users/doctorProfile.html",method=RequestMethod.POST)
	public String doctorProfile(@ModelAttribute ("doctors") Doctor doctor,BindingResult result,@RequestParam Integer userid)
	{
		User us=userDao.getUser(userid);
		doctor.setUserId(us);
		System.out.println(doctor.getDesignation());
		doctorDao.saveDoctor(doctor);
		return "redirect:profile.html?userid="+userid;
	}

	@RequestMapping(value="users/GenerateReport.html",method=RequestMethod.GET)
	public String GenerateReport(ModelMap models,@RequestParam Integer userid,@RequestParam Integer user)
	{
		System.out.println("user 3"+userid);
		try{
		Patient p= patientDao.getPatientbyUserId(userid).get(0);
		models.put("report",p);
		models.put("Patientid", p.getPatientId());
		System.out.println("patient Id ="+p.getPatientId());
		}catch (Exception e) {
			models.put("report", new Patient());
		}
		models.put("userid", userid);
		models.put("user", user);
		
		return "users/GenerateReport";
	}
	
	@RequestMapping(value="users/GenerateReport.html",method=RequestMethod.POST)
	public String GenerateReport(@ModelAttribute ("report") Patient report,@RequestParam(required=false) Integer Patientid,@RequestParam Integer userid,@RequestParam Integer user)
	{
		
		User u=userDao.getUser(userid);
		report.setUserId(u);
		if(Patientid!=null){
			System.out.println("patient Id ="+Patientid);
			report.setPatientId(Patientid);			
		}
		//System.out.println(p.getAddress());
		report= patientDao.savePatient(report);
		return "redirect:profile.html?userid="+user;
	}
}
