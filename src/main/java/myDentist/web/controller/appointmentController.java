package myDentist.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myDentist.model.Appointments;
import myDentist.model.Doctor;
import myDentist.model.MakeAvailability;
import myDentist.model.User;
import myDentist.model.dao.MakeAvailabilityDao;
import myDentist.model.dao.appointmentsDao;
import myDentist.model.dao.doctorDao;
import myDentist.model.dao.patientDao;
import myDentist.model.dao.userDao;

@Controller
public class appointmentController {
	
	@Autowired
	private userDao userDao;
	
	@Autowired
	private doctorDao doctorDao;
	
	@Autowired
	private appointmentsDao appointmentsDao;
	
	@Autowired
	private MakeAvailabilityDao availabilityDao;
	
	@Autowired
	private patientDao patientDao;
	
	@RequestMapping(value="/PatientHome.html", method=RequestMethod.GET)
	public String PatientHom(ModelMap models,@RequestParam Integer userid)
	{
		models.put("userid", userid);
		System.out.println("home page"+userid);
		models.put("users", userDao.getUser(userid));
		models.put("appointments",appointmentsDao.getAppointments());
		System.out.println("out of appoinment for loop");
		
		for(Appointments a:appointmentsDao.getAppointments())
		{
			System.out.println("In appoinment for loop");
			System.out.println(a.getAppointmentId());
			System.out.println(a.getAppointmentDate());
		}
		return "PatientHome";
		
	}
	
	@RequestMapping(value="/appointment.html", method=RequestMethod.GET)
	public String takeAppointment(ModelMap models,@RequestParam Integer userid)
	{
		List listA = new ArrayList();
		listA.add("10");
		listA.add("element 2");
		listA.add("element 3");
		models.put("list", listA);
		models.put("doctors", doctorDao.getDoctors());
		//System.out.println("doctor"+doctorDao.getDoctor(102).getDoctorName());
		models.put("userid", userid);
		return "appointment";
		
	}
	
	@RequestMapping(value="/appointment.html",method=RequestMethod.POST)
	public String takeAppointment(@ModelAttribute("appointments") Appointments appointment,@RequestParam Integer userid,BindingResult results,@ModelAttribute ("doctors") Doctor doctors)
	{		
		System.out.println("-------------"+userid);
		//appointment.setDoctorId("10");
		appointment.setUserId(userDao.getUser(userid));
		//Doctor d=doctorDao.getDoctor(doctorId);
		//appointment.setDoctorId(doctorDao.getDoctor(doctorId));		
		System.out.println("value is :"+appointment.getAppointmentDate());
		appointment=appointmentsDao.saveAppointment(appointment);
		return "redirect:PatientHome.html?userid="+userid;		
	}
	
	@RequestMapping(value="/rescheduleAppointment.html",method=RequestMethod.GET)
	public String rescheduleAppointment(ModelMap models,@RequestParam Integer id)
	{
		Appointments app = appointmentsDao.getAppointment(id);
		System.out.println("usssssssssssssssssssssseris"+app.getUserId());
		models.put("userid", app.getUserId());
		models.put("appointments", appointmentsDao.getAppointment(id));
		return "rescheduleAppointment";
	}
	
	@RequestMapping(value="/rescheduleAppointment.html",method=RequestMethod.POST)
	public String rescheduleAppointment(@ModelAttribute("appointments") Appointments appointment,@RequestParam Integer userid,@RequestParam Integer appid)
	{
		//System.out.println("userrrrrrrrrrrrrrrrrrrrr-----"+appointmentsDao.getappointmentId(id));
		//appointment.setPatientId(userDao.getUser(id));	
		//User user = userDao.getUser(userid);
		Appointments ap = appointmentsDao.getAppointmentbyAptid(appid);		
		
		System.out.println("value is :"+appointment.getAppointmentDate());
		System.out.println(appointment.getAppointmentId());
		//ap.setAppointmentDate(appointment.getAppointmentDate());
		//ap.setAppointmentTime(appointment.getAppointmentTime());
		appointment.setUserId(ap.getUserId());
		//appointment.setAppointmentId();
		appointment = appointmentsDao.saveAppointment(appointment);
		return "redirect:PatientHome.html?userid="+userid;
	}
	
	@RequestMapping(value="/SetSchedule.html",method=RequestMethod.GET)
	public String SetSchedule( ModelMap models,@RequestParam(required=false) String availableDate)
	{
		models.put("setdate", new MakeAvailability());
		if(availableDate !=null){
			System.out.println("Available date is : "+availableDate);
		}
		return "SetSchedule";
	}
	
	@RequestMapping(value="/SetSchedule.html",method=RequestMethod.POST)
	public String SetSchedule(@ModelAttribute("setdate") MakeAvailability makeAvailability, ModelMap models,@RequestParam String availableDate,@RequestParam(required=false) List<String> slot)
	{
		if(slot!=null){
			for (String s : slot) {
			System.out.println("column name"+s);
			System.out.println("date POST"+availableDate);
				availabilityDao.setSlots(s,availableDate);
			}			
		}else{
		models.put("availableDate", availableDate);}
		return "redirect:SetSchedule.html";
	}

}
