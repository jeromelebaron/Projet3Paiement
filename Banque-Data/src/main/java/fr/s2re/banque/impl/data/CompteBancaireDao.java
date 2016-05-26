package fr.s2re.banque.impl.data;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.s2re.banque.api.data.ICompteBancaireDao;
import fr.s2re.banque.entity.Client;
import fr.s2re.banque.entity.Comptebancaire;
import fr.s2re.banque.entity.Credit;
import fr.s2re.banque.entity.Debit;

@Remote(ICompteBancaireDao.class)
@Stateless
public class CompteBancaireDao implements ICompteBancaireDao {
    @PersistenceContext(unitName = "Banque-Data")
    EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Comptebancaire> getCompteByClient(Integer idClient) {
        javax.persistence.Query req = em
                .createQuery("Select distinct c FROM Comptebancaire c inner join fetch c.operationbancaires WHERE c.client.idClient = :idClient");
        req.setParameter("idClient", idClient);
        List<Comptebancaire> comptes = req.getResultList();
        return comptes;
    }

    @Override
    public Comptebancaire getCompteById(Integer idCompte) {
        javax.persistence.TypedQuery<Comptebancaire> req = em
                .createQuery("Select c FROM Comptebancaire c WHERE c.idCompte = :idCompte",
                        Comptebancaire.class);
        req.setParameter("idCompte", idCompte);
        return req.getSingleResult();
    }

}
