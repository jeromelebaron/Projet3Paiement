package fr.s2re.banque.dto;
import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://servicebanque.banque.s2re.fr")
public class CreditDto extends OperationBancaireDto implements Serializable {

	public CreditDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditDto(Date dateOperation, double montant, String typeOperation,
			CompteBancaireDto comptebancaire) {
		super(dateOperation, montant, typeOperation, comptebancaire);
		// TODO Auto-generated constructor stub
	}

	public CreditDto(int idOperation, Date dateOperation, double montant,
			String typeOperation, CompteBancaireDto comptebancaire) {
		super(idOperation, dateOperation, montant, typeOperation, comptebancaire);
		// TODO Auto-generated constructor stub
	}

}
