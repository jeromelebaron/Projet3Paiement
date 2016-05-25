package fr.s2re.banque.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the operationbancaire database table.
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_operation")
@NamedQuery(name="Operationbancaire.findAll", query="SELECT o FROM Operationbancaire o")
public class Operationbancaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_operation")
	private int idOperation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_operation")
	private Date dateOperation;

	private double montant;

	//bi-directional many-to-one association to Comptebancaire
	@ManyToOne
	@JoinColumn(name="id_compte")
	private Comptebancaire comptebancaire;

	public Operationbancaire() {
	}

	public int getIdOperation() {
		return this.idOperation;
	}

	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}

	public Date getDateOperation() {
		return this.dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}


	public Comptebancaire getComptebancaire() {
		return this.comptebancaire;
	}

	public void setComptebancaire(Comptebancaire comptebancaire) {
		this.comptebancaire = comptebancaire;
	}

	public Operationbancaire(Date dateOperation, double montant,
			Comptebancaire comptebancaire) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.comptebancaire = comptebancaire;
	}

	public Operationbancaire(int idOperation, Date dateOperation,
			double montant, Comptebancaire comptebancaire) {
		super();
		this.idOperation = idOperation;
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.comptebancaire = comptebancaire;
	}

	public Operationbancaire(double montant, Comptebancaire comptebancaire) {
		super();
		this.montant = montant;
		this.comptebancaire = comptebancaire;
	}

	
	
}