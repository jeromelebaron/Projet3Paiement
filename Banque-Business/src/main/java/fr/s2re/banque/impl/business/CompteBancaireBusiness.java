package fr.s2re.banque.impl.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.s2re.banque.api.business.ICompteBancaireBusiness;
import fr.s2re.banque.api.business.IOperationBancaireBusiness;
import fr.s2re.banque.api.data.ICarteBancaireDao;
import fr.s2re.banque.api.data.IClientDao;
import fr.s2re.banque.api.data.ICompteBancaireDao;
import fr.s2re.banque.api.data.IOperationBancaireDao;
import fr.s2re.banque.assembleur.DtoToEntity;
import fr.s2re.banque.assembleur.EntityToDto;
import fr.s2re.banque.dto.CarteBancaireDto;
import fr.s2re.banque.dto.ClientDto;
import fr.s2re.banque.dto.CompteBancaireDto;
import fr.s2re.banque.dto.CreditDto;
import fr.s2re.banque.dto.DebitDto;
import fr.s2re.banque.dto.OperationBancaireDto;
import fr.s2re.banque.entity.Comptebancaire;
import fr.s2re.banque.entity.Debit;
import fr.s2re.banque.entity.Operationbancaire;

@Remote(ICompteBancaireBusiness.class)
@Stateless
public class CompteBancaireBusiness implements ICompteBancaireBusiness{
	@EJB
	ICompteBancaireDao compteBancaireDao;
	@EJB
	IOperationBancaireDao operationBancaireDao;
	@EJB
	IClientDao clientDao;
	@EJB
	ICarteBancaireDao carteBancaireDao;

	@EJB 
	IOperationBancaireDao operationBancairedao;

	private Double calculSoldeActuel(Double soldeInitial, Integer idCompteBancaire){
		Double soldeActuel = null;
		List<OperationBancaireDto> operationsBancaireDto = EntityToDto.fromListeOperationsEntityToListeOperationsDto(operationBancaireDao.getOperationByCompte(idCompteBancaire));
		for(OperationBancaireDto operation : operationsBancaireDto){
			if(operation instanceof CreditDto){
				soldeActuel = soldeInitial + operation.getMontant();
			}
			if(operation instanceof DebitDto){
				soldeActuel = soldeInitial - operation.getMontant();	
			}
		}
		return soldeActuel;
	}


	@Override
	public boolean verifierSolde(String nomClient, double montantCommande, CarteBancaireDto carteDto) {
		ClientDto client = EntityToDto.fromClientEntityToClientDto(clientDao.getCLientByNom(nomClient));
		List<CompteBancaireDto> comptes = new ArrayList<>();
		List<CarteBancaireDto> cartesBancaire = new ArrayList<>();
		Double soldeActuel;
		if(client !=null){
			comptes = EntityToDto.fromListeComptesEntityToListeComptesDto(compteBancaireDao.getCompteByClient(client.getIdClient()));
		}
		if(!comptes.isEmpty()){
			for(CompteBancaireDto compte : comptes){
				cartesBancaire = EntityToDto.fromListeCartesEntityToListeCartesDto(carteBancaireDao.getCarteByCompte(compte.getIdCompte()));
			}
		}

		for(CarteBancaireDto carte : cartesBancaire){
			if(verifierCarte(carte,carteDto)){
				soldeActuel = 	calculSoldeActuel(carte.getComptebancaire().getSolde(), carte.getComptebancaire().getIdCompte());
				if(soldeActuel !=null){
					if(soldeActuel <= montantCommande){
						return false;
					}
					if(soldeActuel > montantCommande){
						operationBancairedao.insertDebit(new Debit(new Date(), montantCommande,
								DtoToEntity.fromCompteBancaireDtoToCompteBancaireEntity
								(carte.getComptebancaire())));
						return true;
					}
				}
			}
		}


		return false;
	}

	private boolean verifierCarte(CarteBancaireDto carte,
			CarteBancaireDto carteDto) {
		if(carte.getCryptogramme() == carteDto.getCryptogramme()){
			if(carte.getNumeroCarte().equals(carteDto.getNumeroCarte())){
				return true;
			}

		}
		else{
			return false;
		}
		return false;
	}


	@Override
	public List<CompteBancaireDto> getCompteByClient(Integer idClient) {
		final List<Comptebancaire> listeComptes = compteBancaireDao.getCompteByClient(idClient);
		final List<CompteBancaireDto> listeComptesDto = new ArrayList<>();
		for(Comptebancaire compteBancaire : listeComptes){
			final CompteBancaireDto compteDto = EntityToDto.fromCompteBancaireEntityToCompteBancaireDto(compteBancaire);
			listeComptesDto.add(compteDto);
		}
		return listeComptesDto;


	}

}
