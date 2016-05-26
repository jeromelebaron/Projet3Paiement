package fr.s2re.banque.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://servicebanque.banque.s2re.fr")
public class OperationBancaireDto implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private int idOperation;
    private Date dateOperation;
    private double montant;
    private String typeOperation;
    private CompteBancaireDto comptebancaire;

    public OperationBancaireDto(int idOperation, Date dateOperation, double montant,
            String typeOperation, CompteBancaireDto comptebancaire) {
        super();
        this.idOperation = idOperation;
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.typeOperation = typeOperation;
        this.comptebancaire = comptebancaire;
    }

    public OperationBancaireDto(Date dateOperation, double montant, String typeOperation,
            CompteBancaireDto comptebancaire) {
        super();
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.typeOperation = typeOperation;
        this.comptebancaire = comptebancaire;
    }

    public OperationBancaireDto() {
        super();
    }
    
    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public CompteBancaireDto getComptebancaire() {
        return comptebancaire;
    }

    public void setComptebancaire(CompteBancaireDto comptebancaire) {
        this.comptebancaire = comptebancaire;
    }

   

}
