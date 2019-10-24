package tn.esprit.PiDev.entities;

import java.io.Serializable;


import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class ReclamationFrais implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRec ;
	private String description;
	@Enumerated(EnumType.STRING)
	private Type type ;
	@Enumerated(EnumType.STRING)
	private Periority periority ;
	
	
	
	

}
