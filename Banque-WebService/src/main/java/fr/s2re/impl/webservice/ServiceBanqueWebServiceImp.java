package fr.s2re.impl.webservice;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import fr.s2re.api.webservice.IServiceBanqueWebService;
import fr.s2re.banque.api.business.ICarteBancaireBusiness;
import fr.s2re.banque.api.business.IClientBusiness;
import fr.s2re.banque.api.business.ICompteBancaireBusiness;
import fr.s2re.banque.api.business.IOperationBancaireBusiness;
import fr.s2re.banque.dto.CarteBancaireDto;
import fr.s2re.banque.dto.ClientDto;
import fr.s2re.banque.dto.CompteBancaireDto;
import fr.s2re.banque.dto.OperationBancaireDto;

@Remote(IServiceBanqueWebService.class)
@Stateless
@WebService(endpointInterface = "fr.s2re.api.webservice.IServiceBanqueWebService", targetNamespace = "http://servicebanque.banque.s2re.fr", serviceName = "ServiceBanqueWS")
public class ServiceBanqueWebServiceImp implements IServiceBanqueWebService {

	private Logger logger = Logger.getLogger(ServiceBanqueWebServiceImp.class);

	@EJB
	ICompteBancaireBusiness compteBancaireBusiness;
	@EJB
	IClientBusiness clientBusiness;
	@EJB
	ICarteBancaireBusiness carteBancaireBusiness;
	@EJB
	IOperationBancaireBusiness operationBancaireBusiness;


	@Override
	public boolean verifierSolde(String nomClient, double montantCommande, CarteBancaireDto carteBancaire) {
		logger.debug("verification du solde dans le compte client");
		return compteBancaireBusiness.verifierSolde(nomClient, montantCommande,carteBancaire );
	}

	@Override
	public ClientDto getCLientByNom(String nom) {
		logger.debug("recuperer le client par son nom");
		return clientBusiness.getCLientByNom(nom);

	}

	@Override
	public List<CarteBancaireDto>  getCarteByClient(Integer idClient) {
		return carteBancaireBusiness.getCarteByClient(idClient);

	}

	@Override
	public OperationBancaireDto insertDebit(int idOperation,
			Date dateOperation, double montant, String typeOperation,
			CompteBancaireDto comptebancaire) {
		return operationBancaireBusiness.insertDebit(idOperation, dateOperation, montant, typeOperation, comptebancaire);
	}

	@Override
	public OperationBancaireDto insertCredit(int idOperation,
			Date dateOperation, double montant, String typeOperation,
			CompteBancaireDto comptebancaire) {
		return operationBancaireBusiness.insertCredit(idOperation, dateOperation, montant, typeOperation, comptebancaire);
	}

}
