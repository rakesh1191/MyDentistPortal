package myDentist.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myDentist.model.Appointments;
import myDentist.model.User;
import myDentist.model.dao.appointmentsDao;
import myDentist.model.dao.userDao;


@Repository
public class appointmentsDaoImpl implements appointmentsDao{

	@PersistenceContext
	private EntityManager entitymanager;

	
	@Override
	@Transactional
	public Appointments saveAppointment(Appointments appointment) {
		
		return entitymanager.merge(appointment);
	}

	@Override
	public Appointments getAppointment(Integer patientId) {
		
		return entitymanager.find(Appointments.class,patientId);
	}
	
	@Override
	public Appointments getAppointmentbyAptid(Integer appointmentId) {
		
		return entitymanager.find(Appointments.class,appointmentId);
	}

	@Override
	public List getappointmentId(Integer appointmentId) {
		javax.persistence.Query query = entitymanager.createQuery("select appointmentId from Appointments where patientId="+appointmentId);
		//query.setParameter(1, appointmentId);
		return query.getResultList();
	}

	@Override
	public List<Appointments> getAppointments() {
		
		return entitymanager.createQuery("from Appointments order by appointmentId", Appointments.class).getResultList();
	}
	
	//@Override
	//public Appointments updateAppointments(Appointments appointments)
	//{
		//return entitymanager.createQuery("update Appointments set");
	//}
}
