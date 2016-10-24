package myDentist.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
}
