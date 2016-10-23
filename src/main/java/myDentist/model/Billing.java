package myDentist.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    
    @ManyToMany
    private List<Medicine> medicineId;
    
    @OneToOne
    private Medicine medicineName;
     
    @OneToOne
    private Medicine medicinePrice;
      
    private Integer quantity;
    
    private Long total;
    
	public List<Medicine> getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(List<Medicine> medicineId) {
		this.medicineId = medicineId;
	}

	public Medicine getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(Medicine medicineName) {
		this.medicineName = medicineName;
	}

	public Medicine getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(Medicine medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

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

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
    
    
}
