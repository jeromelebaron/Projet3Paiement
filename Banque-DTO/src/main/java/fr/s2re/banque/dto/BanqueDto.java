package fr.s2re.banque.dto;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://servicebanque.banque.s2re.fr")
public class BanqueDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idBanque;

	private String adresseBanque;

	private String nomBanque;

	private List<ClientDto> clients;

	public int getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(int idBanque) {
		this.idBanque = idBanque;
	}

	public String getAdresseBanque() {
		return adresseBanque;
	}

	public void setAdresseBanque(String adresseBanque) {
		this.adresseBanque = adresseBanque;
	}

	public String getNomBanque() {
		return nomBanque;
	}

	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}

	public List<ClientDto> getClients() {
		return clients;
	}

	public void setClients(List<ClientDto> clients) {
		this.clients = clients;
	}

	public BanqueDto(int idBanque, String adresseBanque, String nomBanque, List<ClientDto> clients) {
		super();
		this.idBanque = idBanque;
		this.adresseBanque = adresseBanque;
		this.nomBanque = nomBanque;
		this.clients = clients;
	}

	public BanqueDto() {
		super();
	}

	public BanqueDto(String adresseBanque, String nomBanque,List<ClientDto> clients) {
		super();
		this.adresseBanque = adresseBanque;
		this.nomBanque = nomBanque;
		this.clients = clients;
	}
	
	
}
