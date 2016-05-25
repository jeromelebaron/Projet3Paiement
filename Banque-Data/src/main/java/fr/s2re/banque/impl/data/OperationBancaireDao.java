package fr.s2re.banque.impl.data;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.s2re.banque.api.data.IOperationBancaireDao;
import fr.s2re.banque.entity.Credit;
import fr.s2re.banque.entity.Debit;
import fr.s2re.banque.entity.Operationbancaire;

@Remote(IOperationBancaireDao.class)
@Stateless
public class OperationBancaireDao implements IOperationBancaireDao {
	@PersistenceContext(unitName="Banque-Data")
	EntityManager em;
	@Override
	public Operationbancaire insertOperation(Operationbancaire paramOperation) {
	em.persist(paramOperation);
		return paramOperation;
	}

	@Override
	public List<Operationbancaire> getOperationByCompte(
			Integer idCompte) {
	Query req = em.createQuery("Select distinct o FROM Operationbancaire o WHERE o.comptebancaire.idCompte = :idCompte");
	req.setParameter("idCompte", idCompte);
	return req.getResultList();
	}

	@Override
	public Operationbancaire insertDebit(Debit debit) {
		em.persist(debit);
		return debit;

	}

	@Override
	public Operationbancaire insertCredit(Credit credit) {
		em.persist(credit);
		return credit;
	}

}
