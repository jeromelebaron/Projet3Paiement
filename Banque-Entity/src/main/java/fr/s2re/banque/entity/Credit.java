package fr.s2re.banque.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "credit")
public class Credit extends Operationbancaire {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    public Credit() {
        super();

    }

    public Credit(Date dateOperation, double montant, Comptebancaire comptebancaire) {
        super(dateOperation, montant, comptebancaire);

    }

    public Credit(int idOperation, Date dateOperation, double montant, Comptebancaire comptebancaire) {
        super(idOperation, dateOperation, montant, comptebancaire);

    }

    public Credit(double montant, Comptebancaire comptebancaire) {
        super(montant, comptebancaire);
    }

}
