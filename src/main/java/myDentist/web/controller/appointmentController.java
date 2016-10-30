package myDentist.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	public String takeAppointment(@ModelAttribute("appointments") Appointments appointment,ModelMap models,@RequestParam Integer userid,@RequestParam(required=false) String appointmentDate)
	{
		if(appointmentDate==null){
		models.put("appointments",appointment);
		models.put("doctors", doctorDao.getDoctors());
			
		models.put("doctors", doctorDao.getDoctors());
		System.out.println("Doctor ID is :"+userid+"||||| Selected date is (GET) : "+appointmentDate);
		//System.out.println("doctor"+doctorDao.getDoctor(102).getDoctorName());
		models.put("userid", userid);
		models.put("appointments",appointment);
		models.put("appointmentDate", appointmentDate);
		}
		return "appointment";
		
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value="/appointment.html",method=RequestMethod.POST)
	public String takeAppointment(@RequestParam Integer userid,@RequestParam Integer doctorId, @RequestParam String appointmentDate,ModelMap models,@RequestParam(required=false) String slot)
	{		
		if(slot!=null){
		System.out.println("Doctor ID is :"+userid+"||||| Selected date is : "+appointmentDate);
		//appointment.setDoctorId("10");
		System.out.println("selected slot = "+slot);
		//Doctor d=doctorDao.getDoctor(doctorId);
		//appointment.setDoctorId(doctorDao.getDoctor(doctorId));		
		//System.out.println("value is :"+appointment.getAppointmentDate());
		//appointment=appointmentsDao.saveAppointment(appointment);
		
		//	return "redirect:appointment.html";
		}
		else{
			List<String> slots = null;
			Doctor d=doctorDao.getDoctor(doctorId);
			List<String> mk= availabilityDao.getSlotList(d);
					
			System.out.println("LIST"+slots);
			models.put("appointmentDate", appointmentDate);
		}
		//models.put("appointments",new Appointments());
		return "redirect:appointment.html?userid="+userid;		
	}
	
	@RequestMapping(value="/rescheduleAppointment.html",method=RequestMethod.GET)
	public String rescheduleAppointment(ModelMap models,@RequestParam Integer id)
	{
		Appointments app = appointmentsDao.getAppointment(id);
		System.out.println("useris"+app.getUserId());
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
	public String SetSchedule( ModelMap models,@RequestParam Integer userid,@RequestParam(required=false) String availableDate)
	{
		System.out.println("new user"+userid);
		models.put("setdate", new MakeAvailability());
		models.put("userid", userid);
		if(availableDate !=null){
			System.out.println("Available date is : "+availableDate);			
		}
		return "SetSchedule";
	}
	
	@RequestMapping(value="/SetSchedule.html",method=RequestMethod.POST)
	public String SetSchedule(@ModelAttribute("setdate") MakeAvailability makeAvailability, ModelMap models,@RequestParam Integer userid,@RequestParam String availableDate,@RequestParam(required=false) List<String> slot)
	{
		
		
		Random rand = new Random();
		int  n = rand.nextInt(1000) + 1;		
		Integer id = n;
		System.out.println("ID is : "+id);
		List<Doctor> d=doctorDao.getDoctorbyUserId(userid);
		if(slot!=null){
			int count=0;
			for (String s : slot) {
			System.out.println("column name"+s);
			System.out.println("date POST"+availableDate);
			Integer temp=id;
			if(count==0){
				availabilityDao.setSlots(s,availableDate,id,d.get(0));
			}
			else{
					availabilityDao.updateSlots(s, availableDate, temp, d.get(0));
			}
			count++;
			}
			return "redirect:doctorHome.html?userid="+userid;
		}else{
		models.put("availableDate", availableDate);
		models.put("userid", userid);
		
		}
		return "redirect:SetSchedule.html";
	}

}
