package fr.s2re.banque.api.business;

import fr.s2re.banque.dto.ClientDto;

public interface IClientBusiness {
    ClientDto getCLientByNom(String nom);
}
