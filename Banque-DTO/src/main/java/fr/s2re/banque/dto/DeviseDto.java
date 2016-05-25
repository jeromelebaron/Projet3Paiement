package fr.s2re.banque.dto;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://servicebanque.banque.s2re.fr")
public class DeviseDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idDevise;
	private double change;
	private String code;
	private String monnaie;
	public int getIdDevise() {
		return idDevise;
	}
	public void setIdDevise(int idDevise) {
		this.idDevise = idDevise;
	}
	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMonnaie() {
		return monnaie;
	}
	public void setMonnaie(String monnaie) {
		this.monnaie = monnaie;
	}
	public DeviseDto(int idDevise, double change, String code, String monnaie) {
		super();
		this.idDevise = idDevise;
		this.change = change;
		this.code = code;
		this.monnaie = monnaie;
	}
	public DeviseDto(double change, String code, String monnaie) {
		super();
		this.change = change;
		this.code = code;
		this.monnaie = monnaie;
	}
	public DeviseDto() {
		super();
	}


}
