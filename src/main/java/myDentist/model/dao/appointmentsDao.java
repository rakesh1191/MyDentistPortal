package myDentist.model.dao;

import myDentist.model.Appointments;
import myDentist.model.Patient;

public interface appointmentsDao {
	
	Appointments getAppointment(Integer patientId);
	
	Appointments saveAppointment(Appointments appointments);

}
