package myDentist.model.dao;

import java.util.List;

import myDentist.model.Doctor;
import myDentist.model.MakeAvailability;


public interface MakeAvailabilityDao {

	
	MakeAvailability getAvailability(String availableDate);
	
	MakeAvailability saveAvailability(MakeAvailability makeAvailability);
	
	List<MakeAvailability> getAvailabilities();
	
	void setSlots(String columnName,String availableDate, Integer id,Doctor userId);
	
	void updateSlots(String columnName,String availableDate, Integer id,Doctor userId);
	
}