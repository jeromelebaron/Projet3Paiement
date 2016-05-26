package fr.s2re.banque.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the devise database table.
 */
@Entity
@NamedQuery(name = "Devise.findAll", query = "SELECT d FROM Devise d")
public class Devise implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devise")
    private int idDevise;

    private double change;

    private String code;

    private String monnaie;

    public Devise() {
    }

    public int getIdDevise() {
        return this.idDevise;
    }

    public void setIdDevise(int idDevise) {
        this.idDevise = idDevise;
    }

    public double getChange() {
        return this.change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMonnaie() {
        return this.monnaie;
    }

    public void setMonnaie(String monnaie) {
        this.monnaie = monnaie;
    }

}