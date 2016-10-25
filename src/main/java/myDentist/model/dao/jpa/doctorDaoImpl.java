package myDentist.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myDentist.model.Appointments;
import myDentist.model.Doctor;
import myDentist.model.Patient;
import myDentist.model.dao.doctorDao;

@Repository
public class doctorDaoImpl implements doctorDao{

	@PersistenceContext
	private EntityManager entitymanager;
	
	@Override
	public Doctor getDoctor(Integer doctorId) {
	
		return entitymanager.find(Doctor.class,doctorId);
	}

	@Override
	public List<Doctor> getDoctors() {
		
		return entitymanager.createQuery("from Doctor order by doctorId", Doctor.class).getResultList();
	}

	@Override
	@Transactional
	public Doctor saveDoctor(Doctor doctor) {
		
		return entitymanager.merge(doctor);
	}

	@Override
	public List<Doctor> getDoctorbyUserId(Integer userId) {
		
		return entitymanager.createQuery("from Doctor where userId="+userId, Doctor.class).getResultList();
	}

	
}
