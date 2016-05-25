package fr.s2re.banque.api.data;

import java.util.List;

import fr.s2re.banque.entity.Devise;

public interface IDeviseDao {
	Devise getDeviseByCode(String code);
	List<Devise> getAllDevises();
	void addDevise(Devise d);
	void deleteDevise(String code);

}
