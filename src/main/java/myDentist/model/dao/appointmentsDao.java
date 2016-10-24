package myDentist.model.dao;

import java.util.List;

import myDentist.model.Appointments;
import myDentist.model.Patient;
import myDentist.model.User;

public interface appointmentsDao {
	
	Appointments getAppointment(Integer patientId);
	
	Appointments getAppointmentbyAptid(Integer appointmentId);
	
	Appointments saveAppointment(Appointments appointments);
	
	List getappointmentId(Integer userid);
	
	List<Appointments> getAppointments();	

}
