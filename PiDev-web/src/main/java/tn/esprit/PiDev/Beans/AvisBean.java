package tn.esprit.PiDev.Beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PiDev.entities.Score;

@ManagedBean
@SessionScoped
public class AvisBean implements Serializable{

private static final long serialVersionUID = 1L;
	
	public Score[] getAvis()
	{
		return Score.values();
	}
	
}
