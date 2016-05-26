package fr.s2re.banque.impl.business;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.s2re.banque.api.business.IOperationBancaireBusiness;
import fr.s2re.banque.api.data.IOperationBancaireDao;
import fr.s2re.banque.assembleur.DtoToEntity;
import fr.s2re.banque.assembleur.EntityToDto;
import fr.s2re.banque.dto.CompteBancaireDto;
import fr.s2re.banque.dto.CreditDto;
import fr.s2re.banque.dto.DebitDto;
import fr.s2re.banque.dto.OperationBancaireDto;
import fr.s2re.banque.entity.Operationbancaire;

@Remote(IOperationBancaireBusiness.class)
@Stateless
public class OperationBancaireBusiness implements IOperationBancaireBusiness {
    @EJB
    IOperationBancaireDao operationBancaireDao;

    @Override
    public OperationBancaireDto insertDebit(int idOperation, Date dateOperation, double montant,
            String typeOperation, CompteBancaireDto comptebancaire) {
        Operationbancaire debit = operationBancaireDao.insertDebit(DtoToEntity
                .fromDebitDtoToDebitEntity(new DebitDto(idOperation, new Date(), montant,
                        typeOperation, comptebancaire)));
        return EntityToDto.fromOperationBancaireEntityToOperationBancaireDto(debit);
    }

    @Override
    public OperationBancaireDto insertCredit(int idOperation, Date dateOperation, double montant,
            String typeOperation, CompteBancaireDto comptebancaire) {
        Operationbancaire credit = operationBancaireDao.insertCredit(DtoToEntity
                .fromCreditDtoToCreditEntity(new CreditDto(idOperation, new Date(), montant,
                        typeOperation, comptebancaire)));
        return EntityToDto.fromOperationBancaireEntityToOperationBancaireDto(credit);

    }

}
