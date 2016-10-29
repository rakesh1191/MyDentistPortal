package myDentist.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myDentist.model.Doctor;
import myDentist.model.MakeAvailability;
import myDentist.model.User;
import myDentist.model.dao.MakeAvailabilityDao;

@Repository
public class MakeAvailabilityDaoImpl implements MakeAvailabilityDao {

	@PersistenceContext
	private EntityManager entitymanager;
	
	@Override
	public MakeAvailability getAvailability(String availableDate) {
		
		return entitymanager.find(MakeAvailability.class,availableDate);
	}

	@Override
	@Transactional
	public MakeAvailability saveAvailability(MakeAvailability makeAvailability) {
		
		return entitymanager.merge(makeAvailability);
	}

	@Override
	public List<MakeAvailability> getAvailabilities() {
	
		return entitymanager.createQuery("from User order by availableDate", MakeAvailability.class).getResultList();
	}

	@Override
	@Transactional
	public void setSlots(String columnName,String availableDate, Integer id,Doctor userId) {
		//System.out.println("model----"+userId.getDoctorId());
		boolean b=true;
		String query = "insert into MakeAvailability (mId,availabledate,"+columnName+",doctorId_doctorId) values ("+id+",'"+availableDate+"',"+b+","+userId.getDoctorId()+")";
		entitymanager.createNativeQuery(query).executeUpdate();		
	}

	@Override
	@Transactional
	public void updateSlots(String columnName, String availableDate, Integer id, Doctor userId) {
		boolean b=true;
		String query = "update MakeAvailability set "+columnName+"="+b+" where mId="+id+"";
		entitymanager.createNativeQuery(query).executeUpdate();		
	
		
	}
}
