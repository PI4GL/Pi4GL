package tn.esprit.PiDev.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCl ;
	
	private String Name;
	private int phNb;
	private String email;
	private String address;
	
	private static final long serialVersionUID = 1L;
	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Client(int idCl, String name, int phNb, String email, String address) {
		super();
		this.idCl = idCl;
		Name = name;
		this.phNb = phNb;
		this.email = email;
		this.address = address;
	}


	public int getIdCl() {
		return idCl;
	}
	public void setIdCl(int idCl) {
		this.idCl = idCl;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPhNb() {
		return phNb;
	}
	public void setPhNb(int phNb) {
		this.phNb = phNb;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
