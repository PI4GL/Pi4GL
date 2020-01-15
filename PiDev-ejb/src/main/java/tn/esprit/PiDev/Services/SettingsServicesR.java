package tn.esprit.PiDev.Services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.PiDev.Remotes.SettingsServicesRRemote;
import tn.esprit.PiDev.entities.Settings;

@Stateless
@LocalBean
public class SettingsServicesR implements SettingsServicesRRemote {
	
	@PersistenceContext
    EntityManager em;

	@Override
	public Settings addSettings(Settings settings) {
		return em.merge(settings);
	}
	
	  public SettingsServicesR() {
	        // TODO Auto-generated constructor stub
	    }
	
		public Settings getSettings() {
			Settings settings = null;
			
			settings = 	(Settings) em.createQuery("select s from Settings s ").setMaxResults(1).getSingleResult();
			return settings ;
		}
}
