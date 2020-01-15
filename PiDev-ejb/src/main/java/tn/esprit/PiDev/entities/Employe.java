package tn.esprit.PiDev.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;






@Entity
public class Employe implements Serializable {
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cin ;
	
	private String firstName;
	private String lastName;
	private Date  birthDate;
	private String Address;
	private int phoneNb;
	private String email;
	private Date hiringDate;
	private float salary;
	
	/*@OneToMany(mappedBy="employe")
	private List<Test> test;
	
	@OneToMany(mappedBy="employe")
	private List<Avis> avis;*/
	
	@OneToMany(mappedBy="employe")
	private List<WorkedOn> workedOn;
	
	/*@ManyToMany(mappedBy="employe")
	private List<Formation> formation = new ArrayList<Formation>();*/
	
	
	
	public List<WorkedOn> getWorkedOn() {
		return workedOn;
	}

	public void setWorkedOn(List<WorkedOn> workedOn) {
		this.workedOn = workedOn;
	}

	public DevTeam getDevTeam() {
		return devTeam;
	}

	public void setDevTeam(DevTeam devTeam) {
		this.devTeam = devTeam;
	}

	@Enumerated(EnumType.STRING)
    private Role role;
	
	@ManyToOne
	private DevTeam devTeam;
	
	

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getPhoneNb() {
		return phoneNb;
	}

	public void setPhoneNb(int phoneNb) {
		this.phoneNb = phoneNb;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Employe(int cin, String firstName, String lastName, Date birthDate, String address, int phoneNb,
			String email, Date hiringDate, float salary, Role role) {
		super();
		this.cin = cin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		Address = address;
		this.phoneNb = phoneNb;
		this.email = email;
		this.hiringDate = hiringDate;
		this.salary = salary;
		this.role = role;
	}

	public Employe() {
		
		
	}
/*
	public List<Formation> getFormation() {
		return formation;
	}

	public void setFormation(List<Formation> formation) {
		this.formation = formation;
	}*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
/*
	public List<Test> getTest() {
		return test;
	}

	public void setTest(List<Test> test) {
		this.test = test;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}
	
	*/
	
}
