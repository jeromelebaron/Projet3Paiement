package fr.s2re.banque.impl.data;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.s2re.banque.api.data.IClientDao;
import fr.s2re.banque.entity.Client;

@Remote(IClientDao.class)
@Stateless
public class ClientDao implements IClientDao {
    @PersistenceContext(unitName = "Banque-Data")
    EntityManager em;

    @Override
    public Client getCLientByNom(String nom) {
        TypedQuery<Client> req = em.createQuery("select c from Client c where c.nomClient = :nom",
                Client.class);
        req.setParameter("nom", nom);
        return req.getSingleResult();
    }

}
