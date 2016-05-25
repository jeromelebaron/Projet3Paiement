package fr.s2re.api.webservice;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import fr.s2re.banque.dto.CarteBancaireDto;
import fr.s2re.banque.dto.ClientDto;
import fr.s2re.banque.dto.CompteBancaireDto;
import fr.s2re.banque.dto.OperationBancaireDto;

@WebService(targetNamespace = "http://servicebanque.banque.s2re.fr")
public interface IServiceBanqueWebService {
	//Services pour le Compte bancaire
    @WebMethod(operationName="verifierSolde")
	boolean verifierSolde(@WebParam(name="paramNomClient")String nomClient, @WebParam(name="paramMontantCommande")double montantCommande, @WebParam(name="paramcarteBancairee")CarteBancaireDto carteBancaire);
	//Service pour operationsbancaire
	@WebMethod(operationName="insertDebit")
	OperationBancaireDto insertDebit(@WebParam(name="idOperation")int idOperation,@WebParam(name="dateOperation") Date dateOperation, @WebParam(name="montant")double montant,
			@WebParam(name="typeOperation")String typeOperation, @WebParam(name="comptebancaire")CompteBancaireDto comptebancaire);
	@WebMethod(operationName="insertCredit")
	OperationBancaireDto insertCredit(@WebParam(name="idOperation")int idOperation,@WebParam(name="dateOperation") Date dateOperation, @WebParam(name="montant")double montant,
			@WebParam(name="typeOperation")String typeOperation, @WebParam(name="comptebancaire")CompteBancaireDto comptebancaire);
	//Service pour le client
	@WebMethod(operationName="getCLientByNom")
	ClientDto getCLientByNom(@WebParam(name="paramNom")String nom);
	//Service pour la carte bancaire
	@WebMethod(operationName="getCarteByClient")
	List<CarteBancaireDto> getCarteByClient(@WebParam(name="paramidClient")Integer idClient);
	
}
