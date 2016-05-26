package fr.s2re.banque.impl.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.s2re.banque.api.business.ICarteBancaireBusiness;
import fr.s2re.banque.api.data.ICarteBancaireDao;
import fr.s2re.banque.assembleur.EntityToDto;
import fr.s2re.banque.dto.CarteBancaireDto;
import fr.s2re.banque.entity.Cartebancaire;

@Remote(ICarteBancaireBusiness.class)
@Stateless
public class CarteBancaireBusiness implements ICarteBancaireBusiness {
    @EJB
    ICarteBancaireDao carteBancaireDao;

    @Override
    public List<CarteBancaireDto> getCarteByClient(Integer idClient) {
        final List<Cartebancaire> listecarte = carteBancaireDao.getCarteByClient(idClient);
        final List<CarteBancaireDto> listeCartesDto = new ArrayList<>();
        for (Cartebancaire cartebancaire : listecarte) {
            final CarteBancaireDto carteDto = EntityToDto
                    .fromCarteBancaireEntityToCarteBancaireDto(cartebancaire);
            listeCartesDto.add(carteDto);

        }
        return listeCartesDto;

    }

}
