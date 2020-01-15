package tn.esprit.PiDev.Remotes;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.Settings;



@Remote
public interface SettingsServicesRRemote {
	public Settings addSettings(Settings settings);
	//public List<Settings> getAllSettings();
}

