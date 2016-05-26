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

public class EntityToDto {
    private static DozerBeanMapper dbm = new DozerBeanMapper();

    private EntityToDto() {

    }

    public static DeviseDto fromDeviseEntityToDeviseDto(Devise devise) {
        DeviseDto deviseDto = new DeviseDto();
        dbm.map(devise, deviseDto);
        return deviseDto;
    }

    public static BanqueDto fromBanqueEntityToBanqueDto(Banque banque) {
        BanqueDto banqueDto = new BanqueDto();
        banqueDto.setAdresseBanque(banque.getAdresseBanque());
        banqueDto.setIdBanque(banque.getIdBanque());
        banqueDto.setNomBanque(banque.getNomBanque());
        banqueDto.setClients(null);
        return banqueDto;
    }

    public static List<CompteBancaireDto> fromListeComptesEntityToListeComptesDto(
            List<Comptebancaire> listeComptes) {
        final List<CompteBancaireDto> listeComptesDto = new ArrayList<>();
        for (Comptebancaire compteBancaire : listeComptes) {
            final CompteBancaireDto compteDto = EntityToDto
                    .fromCompteBancaireEntityToCompteBancaireDto(compteBancaire);
            listeComptesDto.add(compteDto);
        }
        return listeComptesDto;
    }

    public static List<CarteBancaireDto> fromListeCartesEntityToListeCartesDto(
            List<Cartebancaire> listeCartes) {
        final List<CarteBancaireDto> listeCartesDto = new ArrayList<>();
        for (Cartebancaire carteBancaire : listeCartes) {
            final CarteBancaireDto carteDto = EntityToDto
                    .fromCarteBancaireEntityToCarteBancaireDto(carteBancaire);
            listeCartesDto.add(carteDto);
        }

        return listeCartesDto;
    }

    public static List<OperationBancaireDto> fromListeOperationsEntityToListeOperationsDto(
            List<Operationbancaire> listeOperations) {
        final List<OperationBancaireDto> listeOperationsDto = new ArrayList<>();
        for (Operationbancaire operationBancaire : listeOperations) {
            final OperationBancaireDto operationDto = EntityToDto
                    .fromOperationBancaireEntityToOperationBancaireDto(operationBancaire);
            listeOperationsDto.add(operationDto);
        }

        return listeOperationsDto;
    }

    public static List<ClientDto> fromListeClientsEntityToListeClientsDto(List<Client> listeClients) {
        final List<ClientDto> listeClientDto = new ArrayList<>();
        for (Client Client : listeClients) {
            final ClientDto clientDto = EntityToDto.fromClientEntityToClientDto(Client);
            listeClientDto.add(clientDto);
        }

        return listeClientDto;
    }

    public static CarteBancaireDto fromCarteBancaireEntityToCarteBancaireDto(
            Cartebancaire carteBancaire) {
        CarteBancaireDto carteBancaireDto = new CarteBancaireDto();
        carteBancaireDto.setCryptogramme(carteBancaire.getCryptogramme());
        carteBancaireDto.setDateExpiration(carteBancaire.getDateExpiration());
        carteBancaireDto.setIdCarte(carteBancaire.getIdCarte());
        carteBancaireDto.setNumeroCarte(carteBancaire.getNumeroCarte());
        carteBancaireDto
                .setComptebancaire(fromCompteBancaireEntityToCompteBancaireDto(carteBancaire
                        .getComptebancaire()));
        return carteBancaireDto;
    }

    public static ClientDto fromClientEntityToClientDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setAdresseClient(client.getAdresseClient());
        clientDto.setIdClient(client.getIdClient());
        clientDto.setNomClient(client.getNomClient());
        clientDto.setPrenomClient(client.getPrenomClient());
        clientDto.setBanque(null);
        List<Comptebancaire> listeComptes = client.getComptebancaires();
        clientDto.setComptebancaires(fromListeComptesEntityToListeComptesDto(listeComptes));
        return clientDto;
    }

    public static CompteBancaireDto fromCompteBancaireEntityToCompteBancaireDto(
            Comptebancaire compteBancaire) {
        CompteBancaireDto compteBancaireDto = new CompteBancaireDto();
        compteBancaireDto.setCodeBic(compteBancaire.getCodeBic());
        compteBancaireDto.setCodeIban(compteBancaire.getCodeIban());
        compteBancaireDto.setSolde(compteBancaire.getSolde());
        compteBancaireDto.setIdCompte(compteBancaire.getIdCompte());
        compteBancaireDto.setClient(null);
        compteBancaire.setOperationbancaires(null);
        return compteBancaireDto;
    }

    public static OperationBancaireDto fromOperationBancaireEntityToOperationBancaireDto(
            Operationbancaire operationBancair) {
        OperationBancaireDto operationBancairDto = new OperationBancaireDto();
        operationBancairDto.setDateOperation(operationBancair.getDateOperation());
        operationBancairDto.setIdOperation(operationBancair.getIdOperation());
        operationBancairDto.setMontant(operationBancair.getMontant());
        operationBancairDto.setComptebancaire(EntityToDto
                .fromCompteBancaireEntityToCompteBancaireDto(operationBancair.getComptebancaire()));
        if (operationBancair instanceof Debit) {
            operationBancairDto = fromDebitEntityToDebitDto((Debit) operationBancair);
        }
        if (operationBancair instanceof Credit) {
            operationBancairDto = fromCreditEntityToCreditDto((Credit) operationBancair);
        }
        return operationBancairDto;
    }

    public static CreditDto fromCreditEntityToCreditDto(Credit credit) {
        CreditDto creditDto = new CreditDto();
        creditDto.setDateOperation(credit.getDateOperation());
        creditDto.setIdOperation(credit.getIdOperation());
        creditDto.setMontant(credit.getMontant());
        creditDto.setTypeOperation("Credit");
        creditDto.setComptebancaire(EntityToDto.fromCompteBancaireEntityToCompteBancaireDto(credit
                .getComptebancaire()));
        return creditDto;
    }

    public static DebitDto fromDebitEntityToDebitDto(Debit debit) {
        DebitDto debitDto = new DebitDto();
        debitDto.setDateOperation(debit.getDateOperation());
        debitDto.setIdOperation(debit.getIdOperation());
        debitDto.setMontant(debit.getMontant());
        debitDto.setTypeOperation("Debit");
        debitDto.setComptebancaire(EntityToDto.fromCompteBancaireEntityToCompteBancaireDto(debit
                .getComptebancaire()));
        return debitDto;
    }

    public static List<DeviseDto> fromListeDeviseEntityToListeDeviseDto(List<Devise> listeDevise) {
        final List<DeviseDto> listeDeviseDto = new ArrayList<>();
        for (Devise devise : listeDevise) {
            final DeviseDto deviseDto = EntityToDto.fromDeviseEntityToDeviseDto(devise);
            listeDeviseDto.add(deviseDto);
        }

        return listeDeviseDto;
    }
}
