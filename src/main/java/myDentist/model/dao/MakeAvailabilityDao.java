package myDentist.model.dao;

import java.util.List;

import myDentist.model.Doctor;
import myDentist.model.MakeAvailability;


public interface MakeAvailabilityDao {

	
	MakeAvailability getAvailability(String availableDate);
	
	MakeAvailability saveAvailability(MakeAvailability makeAvailability);
	
	void removeAvailability(Integer id);
	
	List<MakeAvailability> getAvailabilities();
	
	List<String> getSlotList(Doctor doctor);
	
	void setSlots(String columnName,String availableDate, Integer id,Doctor userId);
	
	void updateSlots(String columnName,String availableDate, Integer id,Doctor userId);
	
	
}