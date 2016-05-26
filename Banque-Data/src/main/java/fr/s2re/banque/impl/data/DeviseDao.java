package fr.s2re.banque.impl.data;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.s2re.banque.api.data.IDeviseDao;
import fr.s2re.banque.entity.Devise;

@Remote(IDeviseDao.class)
@Stateless
public class DeviseDao implements IDeviseDao {
    @PersistenceContext(unitName = "Banque-Data")
    EntityManager em;

    private List<Devise> listeDevises = new ArrayList<>();

    @Override
    public Devise getDeviseByCode(String code) {
        TypedQuery<Devise> req = em.createQuery("select d from Devise d where d.code = :code",
                Devise.class);
        req.setParameter("code", code);
        return req.getSingleResult();
    }

    @Override
    public List<Devise> getAllDevises() {
        Query req = em.createQuery("select * from Devise ");
        return req.getResultList();
    }

    @Override
    public void addDevise(Devise d) {
        em.persist(d);

    }

    @Override
    public void deleteDevise(String code) {
        for (Devise d : listeDevises) {
            if (d.getCode().equals(code)) {
                em.remove(d);
            }
        }

    }

}
