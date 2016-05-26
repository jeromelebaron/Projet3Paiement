package fr.s2re.banque.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://servicebanque.banque.s2re.fr")
public class DebitDto extends OperationBancaireDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public DebitDto() {
        super();
    }

    public DebitDto(Date dateOperation, double montant, String typeOperation,
            CompteBancaireDto comptebancaire) {
        super(dateOperation, montant, typeOperation, comptebancaire);
    }

    public DebitDto(int idOperation, Date dateOperation, double montant, String typeOperation,
            CompteBancaireDto comptebancaire) {
        super(idOperation, dateOperation, montant, typeOperation, comptebancaire);
    }

}
