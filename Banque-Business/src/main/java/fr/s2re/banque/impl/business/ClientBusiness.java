package fr.s2re.banque.impl.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;




import fr.s2re.banque.api.business.IClientBusiness;
import fr.s2re.banque.api.data.IClientDao;
import fr.s2re.banque.assembleur.EntityToDto;
import fr.s2re.banque.dto.ClientDto;
import fr.s2re.banque.entity.Client;

@Remote(IClientBusiness.class)
@Stateless
public class ClientBusiness implements IClientBusiness {
	@EJB
	IClientDao clientDao; 
	
	@Override
	public ClientDto getCLientByNom(String nom) {
		Client client = clientDao.getCLientByNom(nom);
		ClientDto clientDto = EntityToDto.fromClientEntityToClientDto(client);
		return clientDto;
		
	}

}
