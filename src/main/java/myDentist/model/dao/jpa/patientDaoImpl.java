package myDentist.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myDentist.model.Doctor;
import myDentist.model.Patient;
import myDentist.model.dao.patientDao;

@Repository
public class patientDaoImpl implements patientDao{

	@PersistenceContext
	private EntityManager entitymanager;
	
	@Override
	public Patient getPatient(Integer patientId) {
	
		return entitymanager.find(Patient.class,patientId);
	}

	@Override
	@Transactional
	public Patient savePatient(Patient Patient) {
		return entitymanager.merge(Patient);
	}

	@Override
	public List<Patient> getPatientbyUserId(Integer userId) {
		
		return entitymanager.createQuery("from Patient where userId="+userId, Patient.class).getResultList();
	}
	
}
