package tn.esprit.PiDev.Beans;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.PiDev.Services.SettingsServicesR;
import tn.esprit.PiDev.entities.Settings;

@ManagedBean
@ViewScoped
public class SettingsBean {

	private Settings settings = new Settings();

	@EJB
	SettingsServicesR settingsService;

	@PostConstruct
	public void init() {
		try {
			settings = settingsService.getSettings();
			if (settings == null) {
				settings = new Settings();
			}
		} catch (Exception e) {
			settings = new Settings();
			e.printStackTrace();
		}
	}

	public void addSettings() {
		settings = settingsService.addSettings(settings);
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

}
