package fr.s2re.banque.assembleur;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import fr.s2re.banque.dto.BanqueDto;
import fr.s2re.banque.dto.CarteBancaireDto;
import fr.s2re.banque.dto.ClientDto;
import fr.s2re.banque.dto.CompteBancaireDto;
import fr.s2re.banque.dto.CreditDto;
import fr.s2re.banque.dto.DebitDto;
import fr.s2re.banque.dto.DeviseDto;
import fr.s2re.banque.dto.OperationBancaireDto;
import fr.s2re.banque.entity.Banque;
import fr.s2re.banque.entity.Cartebancaire;
import fr.s2re.banque.entity.Client;
import fr.s2re.banque.entity.Comptebancaire;
import fr.s2re.banque.entity.Credit;
import fr.s2re.banque.entity.Debit;
import fr.s2re.banque.entity.Devise;
import fr.s2re.banque.entity.Operationbancaire;

public class DtoToEntity {
    private static DozerBeanMapper dbm = new DozerBeanMapper();
	private DtoToEntity() {

	}
	
	public static Devise fromDeviseDtoToDeviseEntity(DeviseDto deviseDto) {
		Devise devise = new Devise();
		dbm.map(deviseDto, devise);
		return devise;
	}
	
	public static Banque fromBanqueDtoToBanqueEntity(BanqueDto banqueDto){
		Banque banque = new Banque();
		dbm.map(banqueDto, banque);
		return banque;	
	}
	
	public static Cartebancaire fromCarteBancaireDtoToCarteBancaireEntity(CarteBancaireDto carteBancaireDto){
		Cartebancaire carteBancaire = new Cartebancaire();
		dbm.map(carteBancaireDto, carteBancaire);
		return carteBancaire;	
	}
	
	public static Client fromClientDtoToClientEntity(ClientDto clientDto){
		Client client = new Client();
		client.setAdresseClient(clientDto.getAdresseClient());
		client.setIdClient(clientDto.getIdClient());
		client.setNomClient(clientDto.getNomClient());
		client.setPrenomClient(clientDto.getPrenomClient());
		client.setBanque(null);
		List<CompteBancaireDto> listeComptesDto = clientDto.getComptebancaires();
		client.setComptebancaires(fromListeComptesDtoToListeComptesEntity(listeComptesDto));
		return client;	
	}
	
	public static List<Comptebancaire> fromListeComptesDtoToListeComptesEntity(List<CompteBancaireDto> listeComptesDto){
		final List<Comptebancaire> listeComptes = new ArrayList<>();
		for(CompteBancaireDto compteBancaireDto : listeComptesDto){
			final Comptebancaire compte = DtoToEntity.fromCompteBancaireDtoToCompteBancaireEntity(compteBancaireDto);
			listeComptes.add(compte);
		}
		return listeComptes;	
	}
	

	
	public static Comptebancaire fromCompteBancaireDtoToCompteBancaireEntity(CompteBancaireDto compteBancaireDto){
		Comptebancaire compteBancaire = new Comptebancaire();
		dbm.map(compteBancaireDto, compteBancaire);
		compteBancaire.setClient(null);
		return compteBancaire;
	}
	
	public static Operationbancaire fromOperationBancaireDtoToOperationBancaireEntity(OperationBancaireDto operationBancairDto){
		Operationbancaire operationBancaire = new Operationbancaire();
		dbm.map(operationBancairDto, operationBancaire);
		operationBancaire.setComptebancaire(DtoToEntity.fromCompteBancaireDtoToCompteBancaireEntity(operationBancairDto.getComptebancaire()));
		return operationBancaire;
	}
	
	public static Credit fromCreditDtoToCreditEntity(CreditDto creditDto){
		Credit credit = new Credit();
		dbm.map(creditDto, credit);
		credit.setComptebancaire(DtoToEntity.fromCompteBancaireDtoToCompteBancaireEntity(creditDto.getComptebancaire()));
		return credit;
	}
	
	public static Debit fromDebitDtoToDebitEntity(DebitDto debitDto){
		Debit debit = new Debit();
		dbm.map(debitDto, debit);
		debit.setComptebancaire(DtoToEntity.fromCompteBancaireDtoToCompteBancaireEntity(debitDto.getComptebancaire()));
		return debit;
	}
	
}
