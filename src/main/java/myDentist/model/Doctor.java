package myDentist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue
    private Integer doctorId;
    
    private String doctorName;

    public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	@OneToOne
    private User userId;

    private String designation;
    
    private String specialization;
    
    private Integer dateOfBirth;
        
	private String address;
    
    private String contactNo;

    public Integer getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Integer dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
    
	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
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

    
}