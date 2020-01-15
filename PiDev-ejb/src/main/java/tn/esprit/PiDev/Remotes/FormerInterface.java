package tn.esprit.PiDev.Remotes;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.Former;

@Remote
public interface FormerInterface {

	void addFormer(Former former);
	void deleteFormer(int idFormer);
	void updateFormer(Former former);
	List<Former> getAllFormer();
	Former getFormerById(int idFormer);
	Former getFormerByName(String nameFormer);
	Former getFormerBySpeciality(String specialty);
}
