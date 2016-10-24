package myDentist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointments {

    @Id
    @GeneratedValue
    private Integer appointmentId;

    @ManyToOne
    private User userId;
    
    public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@ManyToOne
    private Doctor doctorId;

    private String appointmentDate;
    
    public Doctor getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Doctor doctorId) {
		this.doctorId = doctorId;
	}

	private String appointmentTime;
    
    public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	
	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	
       
}