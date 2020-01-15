package tn.esprit.PiDev.Beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PiDev.entities.Specialty;

@ManagedBean
@SessionScoped
public class SpecialtyBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Specialty[] getSpec()
	{
		return Specialty.values();
	}
}
