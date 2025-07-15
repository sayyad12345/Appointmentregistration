package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="apointmentdetails")
public class ApointmentEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int apointant_id;

@Column(name ="first_name")
private String firstName;

@Column(name ="last_name")
private String lastName;

@Column(name="address")
private String address;

@Column(name="apointment_date")
private java.sql.Date apointmentDate;

public ApointmentEntity() {}

public int getApt_id() {
	return apointant_id;
}

public void setApt_id(int ap_id) {
	this.apointant_id = ap_id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getAddress() {
	return address;
}

public void setEmail(String email) {
	this.address = email;
}

public java.sql.Date getAptDate() {
	return apointmentDate;
}

public void setAptDate(java.sql.Date aptDate) {
	this.apointmentDate = aptDate;
}

}