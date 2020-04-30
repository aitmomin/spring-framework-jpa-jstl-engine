package com.MCloud.facture.models;

import javax.validation.constraints.NotNull;

public class FactureModel {
	private String erreur;
	private String commentaires;
	@NotNull
	private Long idClient;
	@NotNull
	private Long idAdresseLivraison;
	public String getErreur() {
		return erreur;
	}
	public void setErreur(String erreur) {
		this.erreur = erreur;
	}
	public String getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public Long getIdAdresseLivraison() {
		return idAdresseLivraison;
	}
	public void setIdAdresseLivraison(Long idAdresseLivraison) {
		this.idAdresseLivraison = idAdresseLivraison;
	}
	
	
}
