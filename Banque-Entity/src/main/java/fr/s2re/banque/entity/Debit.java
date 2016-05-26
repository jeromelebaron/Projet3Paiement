package fr.s2re.banque.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "debit")
public class Debit extends Operationbancaire {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Debit() {
        super();

    }

    public Debit(Date dateOperation, double montant, Comptebancaire comptebancaire) {
        super(dateOperation, montant, comptebancaire);

    }

    public Debit(int idOperation, Date dateOperation, double montant, Comptebancaire comptebancaire) {
        super(idOperation, dateOperation, montant, comptebancaire);

    }

    public Debit(double montant, Comptebancaire comptebancaire) {
        super(montant, comptebancaire);

    }

}
