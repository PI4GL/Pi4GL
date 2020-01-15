package tn.esprit.PiDev.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity

public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	protected String cin;
	protected String Firstname;
	protected String LastName;
	protected String Phone;
	protected String mail;
	protected String login;
	protected String password;
	protected Double salary =0.0;	
	private String speciality;
	private String grade;
	private int rating;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	//=============================================================
	// association reflexive manager => employees
	//==============================================================
	
	@ManyToOne
	@JoinColumn(name ="manager_id" )
	private User manager;
	
	@OneToMany(mappedBy = "manager" , fetch = FetchType.EAGER) // Eager: pour pouvoir récuperer automatiquement toute la liste des employés associé à un manager  
	private List<User> employees;
	
	
	//=============================================================
	// Le reste des associations 
	//==============================================================
	

	

	
	@OneToMany(mappedBy = "employee")
	private List<Ticket> tickets;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getFirstname() {
		return Firstname;
	}


	public void setFirstname(String firstname) {
		Firstname = firstname;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public User getManager() {
		return manager;
	}


	public void setManager(User manager) {
		this.manager = manager;
	}


	public List<User> getEmployees() {
		return employees;
	}


	public void setEmployees(List<User> employees) {
		this.employees = employees;
	}


	public List<Ticket> getTickets() {
		return tickets;
	}


	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public User(int id, String cin, String firstname, String lastName, String phone, String mail, String login,
			String password, Double salary, String speciality, String grade, int rating, Role role, User manager,
			List<User> employees, List<Ticket> tickets) {
		super();
		this.id = id;
		this.cin = cin;
		Firstname = firstname;
		LastName = lastName;
		Phone = phone;
		this.mail = mail;
		this.login = login;
		this.password = password;
		this.salary = salary;
		this.speciality = speciality;
		this.grade = grade;
		this.rating = rating;
		this.role = role;
		this.manager = manager;
		this.employees = employees;
		this.tickets = tickets;
	}
	
	public User() {
		super();
	}


	public User(int id, String cin, String firstname, String lastName, String phone, String mail, String login,
			String password, Double salary, Role role) {
		super();
		this.id = id;
		this.cin = cin;
		Firstname = firstname;
		LastName = lastName;
		Phone = phone;
		this.mail = mail;
		this.login = login;
		this.password = password;
		this.salary = salary;
		this.role = role;
	}

	
	
}
