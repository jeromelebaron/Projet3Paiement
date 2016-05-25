package fr.s2re.banque.api.business;

import java.util.Date;

import fr.s2re.banque.dto.CompteBancaireDto;
import fr.s2re.banque.dto.OperationBancaireDto;

public interface IOperationBancaireBusiness {
	OperationBancaireDto insertDebit(int idOperation, Date dateOperation, double montant,
			String typeOperation, CompteBancaireDto comptebancaire);
	OperationBancaireDto insertCredit(int idOperation, Date dateOperation, double montant,
			String typeOperation, CompteBancaireDto comptebancaire);
	
}
