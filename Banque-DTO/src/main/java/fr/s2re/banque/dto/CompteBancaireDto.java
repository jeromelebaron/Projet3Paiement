package fr.s2re.banque.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://servicebanque.banque.s2re.fr")
public class CompteBancaireDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCompte;
	private String codeBic;
	private String codeIban;
	private double solde;
	private List<CarteBancaireDto> cartebancaires;
	private ClientDto client;
	private List<OperationBancaireDto> operationbancaires;
	public int getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	public String getCodeBic() {
		return codeBic;
	}
	public void setCodeBic(String codeBic) {
		this.codeBic = codeBic;
	}
	public String getCodeIban() {
		return codeIban;
	}
	public void setCodeIban(String codeIban) {
		this.codeIban = codeIban;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public List<CarteBancaireDto> getCartebancaires() {
		return cartebancaires;
	}
	public void setCartebancaires(List<CarteBancaireDto> cartebancaires) {
		this.cartebancaires = cartebancaires;
	}
	public ClientDto getClient() {
		return client;
	}
	public void setClient(ClientDto client) {
		this.client = client;
	}
	public List<OperationBancaireDto> getOperationbancaires() {
		return operationbancaires;
	}
	public void setOperationbancaires(List<OperationBancaireDto> operationbancaires) {
		this.operationbancaires = operationbancaires;
	}
	public CompteBancaireDto(String codeBic, String codeIban, double solde,
			List<CarteBancaireDto> cartebancaires, ClientDto client,
			List<OperationBancaireDto> operationbancaires) {
		super();
		this.codeBic = codeBic;
		this.codeIban = codeIban;
		this.solde = solde;
		this.cartebancaires = cartebancaires;
		this.client = client;
		this.operationbancaires = operationbancaires;
	}
	public CompteBancaireDto() {
		super();
	}
	
	
	
	
}
