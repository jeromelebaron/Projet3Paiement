package fr.s2re.banque.impl.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.s2re.banque.api.business.IDeviseBusiness;
import fr.s2re.banque.api.data.IDeviseDao;
import fr.s2re.banque.assembleur.DtoToEntity;
import fr.s2re.banque.assembleur.EntityToDto;
import fr.s2re.banque.dto.DeviseDto;

@Remote(IDeviseBusiness.class)
@Stateless
public class DeviseBusiness implements IDeviseBusiness {
	@EJB
	IDeviseDao deviseDao;

	@Override
	public DeviseDto rechercherDeviseParCode(String code) {
		return EntityToDto.fromDeviseEntityToDeviseDto(deviseDao.getDeviseByCode(code));	
	}

	@Override
	public double convertir(Double amount, String src, String target) {
		double result= 0;
		DeviseDto srcDev= EntityToDto.fromDeviseEntityToDeviseDto(deviseDao.getDeviseByCode(src));
		DeviseDto targetDev= EntityToDto.fromDeviseEntityToDeviseDto(deviseDao.getDeviseByCode(target));
		result = amount * targetDev.getChange() / srcDev.getChange();
		return result;
	}

	@Override
	public DeviseDto updateDevise(DeviseDto dev) {
		DeviseDto deviseMiseAjour = null;
		deviseDao.addDevise(DtoToEntity.fromDeviseDtoToDeviseEntity(dev));
		DtoToEntity.fromDeviseDtoToDeviseEntity(dev);
		deviseMiseAjour = EntityToDto.fromDeviseEntityToDeviseDto(deviseDao.getDeviseByCode
				((DtoToEntity.fromDeviseDtoToDeviseEntity(dev)).getCode()));
		return deviseMiseAjour;

	}

	@Override
	public List<DeviseDto> rechercherDevises(Double changeMini) {
		List<DeviseDto> allDevises = EntityToDto.fromListeDeviseEntityToListeDeviseDto((deviseDao.getAllDevises()));
		if(changeMini==null){
			return allDevises;
		}else{
			List<DeviseDto> sousListe = new ArrayList<DeviseDto>();
			for(DeviseDto d : allDevises){
				if(d.getChange()>=changeMini) sousListe.add(d);
			}
			return sousListe;
		}

	}

}
