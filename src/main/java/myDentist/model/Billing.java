package myDentist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "billing")
public class Billing {

    @Id
    @GeneratedValue
    private Integer billingID;

    @OneToOne
    private Appointments appointmentID;

    @OneToOne
    private User patientName;
    
    private Long payments;

	public Integer getBillingID() {
		return billingID;
	}

	public void setBillingID(Integer billingID) {
		this.billingID = billingID;
	}

	public Appointments getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(Appointments appointmentID) {
		this.appointmentID = appointmentID;
	}

	public User getPatientName() {
		return patientName;
	}

	public void setPatientName(User patientName) {
		this.patientName = patientName;
	}

	public Long getPayments() {
		return payments;
	}

	public void setPayments(Long payments) {
		this.payments = payments;
	}
    
    
}