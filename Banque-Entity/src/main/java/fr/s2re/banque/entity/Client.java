package fr.s2re.banque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the client database table.
 */
@Entity
@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int idClient;

    @Column(name = "adresse_client")
    private String adresseClient;

    @Column(name = "nom_client")
    private String nomClient;

    @Column(name = "prenom_client")
    private String prenomClient;

    // bi-directional many-to-one association to Banque
    @ManyToOne
    @JoinColumn(name = "id_banque")
    private Banque banque;

    // bi-directional many-to-one association to Comptebancaire
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Comptebancaire> comptebancaires;

    public Client() {
    }

    public int getIdClient() {
        return this.idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getAdresseClient() {
        return this.adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public String getNomClient() {
        return this.nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return this.prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public Banque getBanque() {
        return this.banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public List<Comptebancaire> getComptebancaires() {
        return this.comptebancaires;
    }

    public void setComptebancaires(List<Comptebancaire> comptebancaires) {
        this.comptebancaires = comptebancaires;
    }

    public Comptebancaire addComptebancaire(Comptebancaire comptebancaire) {
        getComptebancaires().add(comptebancaire);
        comptebancaire.setClient(this);

        return comptebancaire;
    }

    public Comptebancaire removeComptebancaire(Comptebancaire comptebancaire) {
        getComptebancaires().remove(comptebancaire);
        comptebancaire.setClient(null);

        return comptebancaire;
    }

    @Override
    public String toString() {
        return "Client [idClient=" + idClient + ", adresseClient=" + adresseClient + ", nomClient="
                + nomClient + ", prenomClient=" + prenomClient + ", banque=" + banque
                + ", comptebancaires=" + comptebancaires + "]";
    }

}