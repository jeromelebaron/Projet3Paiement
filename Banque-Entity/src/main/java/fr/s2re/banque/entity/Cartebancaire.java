package fr.s2re.banque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the cartebancaire database table.
 */
@Entity
@NamedQuery(name = "Cartebancaire.findAll", query = "SELECT c FROM Cartebancaire c")
public class Cartebancaire implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carte")
    private int idCarte;

    private int cryptogramme;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_expiration")
    private Date dateExpiration;

    @Column(name = "numero_carte")
    private String numeroCarte;

    // bi-directional many-to-one association to Comptebancaire
    @ManyToOne
    @JoinColumn(name = "id_compte")
    private Comptebancaire comptebancaire;

    public Cartebancaire() {
    }

    public int getIdCarte() {
        return this.idCarte;
    }

    public void setIdCarte(int idCarte) {
        this.idCarte = idCarte;
    }

    public int getCryptogramme() {
        return this.cryptogramme;
    }

    public void setCryptogramme(int cryptogramme) {
        this.cryptogramme = cryptogramme;
    }

    public Date getDateExpiration() {
        return this.dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getNumeroCarte() {
        return this.numeroCarte;
    }

    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public Comptebancaire getComptebancaire() {
        return this.comptebancaire;
    }

    public void setComptebancaire(Comptebancaire comptebancaire) {
        this.comptebancaire = comptebancaire;
    }

}