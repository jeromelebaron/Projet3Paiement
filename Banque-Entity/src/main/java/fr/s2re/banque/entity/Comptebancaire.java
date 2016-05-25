package fr.s2re.banque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the comptebancaire database table.
 * 
 */
@Entity
@NamedQuery(name="Comptebancaire.findAll", query="SELECT c FROM Comptebancaire c")
public class Comptebancaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compte")
	private int idCompte;

	@Column(name="code_bic")
	private String codeBic;

	@Column(name="code_iban")
	private String codeIban;

	private double solde;

	//bi-directional many-to-one association to Cartebancaire
	@OneToMany(mappedBy="comptebancaire")
	private List<Cartebancaire> cartebancaires;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	//bi-directional many-to-one association to Operationbancaire
	@OneToMany( mappedBy="comptebancaire")
	private List<Operationbancaire> operationbancaires;

	public Comptebancaire() {
	}

	public int getIdCompte() {
		return this.idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public String getCodeBic() {
		return this.codeBic;
	}

	public void setCodeBic(String codeBic) {
		this.codeBic = codeBic;
	}

	public String getCodeIban() {
		return this.codeIban;
	}

	public void setCodeIban(String codeIban) {
		this.codeIban = codeIban;
	}

	public double getSolde() {
		return this.solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public List<Cartebancaire> getCartebancaires() {
		return this.cartebancaires;
	}

	public void setCartebancaires(List<Cartebancaire> cartebancaires) {
		this.cartebancaires = cartebancaires;
	}

	public Cartebancaire addCartebancaire(Cartebancaire cartebancaire) {
		getCartebancaires().add(cartebancaire);
		cartebancaire.setComptebancaire(this);

		return cartebancaire;
	}

	public Cartebancaire removeCartebancaire(Cartebancaire cartebancaire) {
		getCartebancaires().remove(cartebancaire);
		cartebancaire.setComptebancaire(null);

		return cartebancaire;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Operationbancaire> getOperationbancaires() {
		return this.operationbancaires;
	}

	public void setOperationbancaires(List<Operationbancaire> operationbancaires) {
		this.operationbancaires = operationbancaires;
	}

	public Operationbancaire addOperationbancaire(Operationbancaire operationbancaire) {
		getOperationbancaires().add(operationbancaire);
		operationbancaire.setComptebancaire(this);

		return operationbancaire;
	}

	public Operationbancaire removeOperationbancaire(Operationbancaire operationbancaire) {
		getOperationbancaires().remove(operationbancaire);
		operationbancaire.setComptebancaire(null);

		return operationbancaire;
	}

	
}