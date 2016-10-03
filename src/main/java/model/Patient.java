package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue
    private Integer patientId;
    
    @OneToMany
    private List<Appointments> patientAppId;
    
    @ManyToOne
    private User userId;
    
    @OneToOne
    private User userName;

    public User getUserName() {
		return userName;
	}
	public void setUserName(User userName) {
		this.userName = userName;
	}
	private String address;
    
    private String contactNo;
    
    private String diseaseType;
    private String allergies;
    private String labResult;
    private String immunizations;
    private String medicines;
    private String doctorComments;
    private String billingInfo;
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getDiseaseType() {
		return diseaseType;
	}
	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getLabResult() {
		return labResult;
	}
	public void setLabResult(String labResult) {
		this.labResult = labResult;
	}
	public String getImmunizations() {
		return immunizations;
	}
	public void setImmunizations(String immunizations) {
		this.immunizations = immunizations;
	}
	public String getMedicines() {
		return medicines;
	}
	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}
	public String getDoctorComments() {
		return doctorComments;
	}
	public void setDoctorComments(String doctorComments) {
		this.doctorComments = doctorComments;
	}
	public String getBillingInfo() {
		return billingInfo;
	}
	public void setBillingInfo(String billingInfo) {
		this.billingInfo = billingInfo;
	}

	
    

   
}
