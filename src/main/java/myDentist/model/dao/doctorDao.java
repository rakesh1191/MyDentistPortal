package myDentist.model.dao;

import java.util.List;

import myDentist.model.Appointments;
import myDentist.model.Doctor;
import myDentist.model.User;


public interface doctorDao {

	Doctor getDoctor(Integer doctorId);
	
	List<Doctor> getDoctors();
	
	Doctor saveDoctor(Doctor doctor);
	
}
