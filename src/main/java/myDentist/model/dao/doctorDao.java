package myDentist.model.dao;

import java.util.List;

import myDentist.model.Appointments;
import myDentist.model.Doctor;


public interface doctorDao {

	Doctor getDoctor(Integer doctorId);
	
	List<Doctor> getDoctors();
	
}
