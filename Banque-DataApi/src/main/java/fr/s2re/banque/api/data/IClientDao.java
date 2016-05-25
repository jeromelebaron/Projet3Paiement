package fr.s2re.banque.api.data;

import fr.s2re.banque.entity.Client;

public interface IClientDao {
    Client getCLientByNom(String nom);
}
