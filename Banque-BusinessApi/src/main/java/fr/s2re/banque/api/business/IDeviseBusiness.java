package fr.s2re.banque.api.business;

import java.util.List;

import fr.s2re.banque.dto.DeviseDto;

public interface IDeviseBusiness {
	DeviseDto rechercherDeviseParCode(String code);
	public double convertir(Double amount ,String src, String target);
	public DeviseDto updateDevise(DeviseDto dev);
	List<DeviseDto> rechercherDevises(Double change);
	
}
