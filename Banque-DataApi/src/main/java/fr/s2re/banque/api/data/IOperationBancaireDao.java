package fr.s2re.banque.api.data;

import java.util.List;
import fr.s2re.banque.entity.Credit;
import fr.s2re.banque.entity.Debit;
import fr.s2re.banque.entity.Operationbancaire;

public interface IOperationBancaireDao {

	  Operationbancaire insertOperation(Operationbancaire paramOperation);
	  Operationbancaire insertDebit(Debit debit);
	  Operationbancaire insertCredit(Credit credit);
	  List<Operationbancaire> getOperationByCompte(Integer paramIdCompte);
	  
}
