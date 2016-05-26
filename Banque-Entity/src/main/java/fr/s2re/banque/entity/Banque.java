package fr.s2re.banque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the banque database table.
 */
@Entity
@NamedQuery(name = "Banque.findAll", query = "SELECT b FROM Banque b")
public class Banque implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_banque")
    private int idBanque;

    @Column(name = "adresse_banque")
    private String adresseBanque;

    @Column(name = "nom_banque")
    private String nomBanque;

    // bi-directional many-to-one association to Client
    @OneToMany(mappedBy = "banque")
    private List<Client> clients;

    public Banque() {
    }

    public int getIdBanque() {
        return this.idBanque;
    }

    public void setIdBanque(int idBanque) {
        this.idBanque = idBanque;
    }

    public String getAdresseBanque() {
        return this.adresseBanque;
    }

    public void setAdresseBanque(String adresseBanque) {
        this.adresseBanque = adresseBanque;
    }

    public String getNomBanque() {
        return this.nomBanque;
    }

    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    public List<Client> getClients() {
        return this.clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Client addClient(Client client) {
        getClients().add(client);
        client.setBanque(this);

        return client;
    }

    public Client removeClient(Client client) {
        getClients().remove(client);
        client.setBanque(null);

        return client;
    }

}