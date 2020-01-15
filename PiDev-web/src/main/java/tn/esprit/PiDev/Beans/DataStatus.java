package tn.esprit.PiDev.Beans;

import javax.faces.bean.ManagedBean;

import tn.esprit.PiDev.entities.Status;

@ManagedBean
public class DataStatus {

	public Status[] getStatus()
	{
		return Status.values();
	}
}