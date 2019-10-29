package tn.esprit.PiDev.Beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;

import tn.esprit.PiDev.Services.EmployeService;
import tn.esprit.PiDev.entities.DevTeam;
import tn.esprit.PiDev.entities.Employe;
import tn.esprit.PiDev.entities.Role;
import tn.esprit.PiDev.entities.WorkedOn;

@javax.faces.bean.ManagedBean(name = "employeBean")
@SessionScoped
public class EmployeBean implements Serializable {
	
private int cin ;
	
	private String firstName;
	private String lastName;
	private Date  birthDate;
	private String address;
	private int phoneNb;
	private String email;
	private Date hiringDate;
	private float salary;
	private Role role;
	private List<WorkedOn> workedOn;
	private DevTeam devTeam;

	
	@EJB
	EmployeService employeService;
	public void addEmploye() {
		employeService.ajouterEmploye(new Employe(cin, firstName, lastName, birthDate, address, phoneNb, email, hiringDate, salary, role));
		
	}
	
	public void deletProject() {
		
	}
	public List<Employe> employes;
	public List<Employe> getEmployes(){
		
		employes=employeService.getListEmployes();
		return employes;
	}
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
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public EmployeService getEmployeService() {
		return employeService;
	}
	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	public EmployeBean(int cin, String firstName, String lastName, Date birthDate, String address, int phoneNb,
			String email, Date hiringDate, float salary, Role role, List<WorkedOn> workedOn, DevTeam devTeam,
			EmployeService employeService, List<Employe> employes) {
		super();
		this.cin = cin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.address = address;
		this.phoneNb = phoneNb;
		this.email = email;
		this.hiringDate = hiringDate;
		this.salary = salary;
		this.role = role;
		this.workedOn = workedOn;
		this.devTeam = devTeam;
		this.employeService = employeService;
		this.employes = employes;
	}
	
	public void goToAdd() {
		
		return ;
	}	
	
	
	


}
