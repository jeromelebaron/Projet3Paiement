package fr.s2re.impl.webservice;

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
import fr.s2re.banque.dto.CarteBancaireDto;
import fr.s2re.banque.dto.ClientDto;
import fr.s2re.banque.dto.CompteBancaireDto;

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
	@Override
	public void crediter(Integer idCompte, Double montant) {
		logger.debug("crediter le solde");
		compteBancaireBusiness.crediter(idCompte, montant);

	}

	@Override
	public void debiter(Integer idCompte, Double montant) {
		logger.debug("debiter le solde");
		compteBancaireBusiness.debiter(idCompte, montant);

	}

	@Override
	public double getSolde(Integer paramIdCompte) {
		logger.debug("recuperer le solde");
		return compteBancaireBusiness.getSolde(paramIdCompte);

	}

	@Override
	public boolean verifierSolde(int idCompte, double montantCommande) {
		logger.debug("verification du solde dans le compte client");
		return compteBancaireBusiness.verifierSolde(idCompte, montantCommande);
	}

	@Override
	public List<CompteBancaireDto> getCompteByClient(Integer idClient) {
		logger.debug("verification du solde dans le compte client");
		return compteBancaireBusiness.getCompteByClient(idClient);
	}

	@Override
	public ClientDto getCLientByNom(String nom) {
		logger.debug("recuperer le client par son nom");
		clientBusiness.getCLientByNom(nom);
		return null;
	}

	@Override
	public List<CarteBancaireDto>  getCarteByCompte(Integer idCompte) {
		carteBancaireBusiness.getCarteByCompte(idCompte);
		return null;
	}

}
