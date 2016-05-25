package fr.s2re.banque.impl.data;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.s2re.banque.api.data.ICarteBancaireDao;
import fr.s2re.banque.api.data.ICompteBancaireDao;
import fr.s2re.banque.entity.Cartebancaire;

@Remote(ICarteBancaireDao.class)
@Stateless
public class CarteBancaireDao implements ICarteBancaireDao {

	@PersistenceContext(unitName="Banque-Data")
	EntityManager em;
	@Override
	public List<Cartebancaire> getCarteByClient(Integer idClient) {
		javax.persistence.Query req = em.createQuery("Select distinct c FROM Cartebancaire c WHERE c.comptebancaire.client.idClient = :idClient");
		req.setParameter("idClient", idClient);
		return req.getResultList();
		
		
	}
	@Override
	public List<Cartebancaire> getCarteByCompte(Integer idCompte) {
		javax.persistence.Query req = em.createQuery("Select distinct c FROM Cartebancaire c WHERE c.comptebancaire.idCompte = :idCompte");
		req.setParameter("idCompte", idCompte);
		return req.getResultList();
	}

}
