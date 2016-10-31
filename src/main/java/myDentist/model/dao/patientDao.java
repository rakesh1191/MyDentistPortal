package myDentist.model.dao;
import java.util.List;

import myDentist.model.Patient;

public interface patientDao {

	Patient getPatient(Integer patientId);
	
	Patient savePatient(Patient Patient);
	
	List<Patient> getPatientbyUserId(Integer userId);
}
