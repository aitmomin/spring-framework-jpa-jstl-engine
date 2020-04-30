package com.MCloud.facture.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;


public class ClientModel {
	@NotEmpty
	@Size(min=3,max=30)
	private String nomClient;
	@NotEmpty
	@Size(min=3,max=30)
	private String prenomClient;
	private String erreur;
	@NotNull
	private Long idAdresseLivraison;
	@NotNull
	private Long idAdresseFacturation;
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getErreur() {
		return erreur;
	}
	public void setErreur(String erreur) {
		this.erreur = erreur;
	}
	public Long getIdAdresseLivraison() {
		return idAdresseLivraison;
	}
	public void setIdAdresseLivraison(Long idAdresseLivraison) {
		this.idAdresseLivraison = idAdresseLivraison;
	}
	public Long getIdAdresseFacturation() {
		return idAdresseFacturation;
	}
	public void setIdAdresseFacturation(Long idAdresseFacturation) {
		this.idAdresseFacturation = idAdresseFacturation;
	}
	
	
}
