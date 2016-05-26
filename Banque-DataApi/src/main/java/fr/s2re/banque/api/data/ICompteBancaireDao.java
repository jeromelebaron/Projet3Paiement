package fr.s2re.banque.api.data;

import java.util.List;

import fr.s2re.banque.entity.Comptebancaire;

public interface ICompteBancaireDao {

    List<Comptebancaire> getCompteByClient(Integer idClient);

    Comptebancaire getCompteById(Integer idCompte);

}
