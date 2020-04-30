package com.MCloud.facture.models;

import javax.validation.constraints.NotNull;

public class ArticleModel {
	private double prix;
	private String erreur;
	@NotNull
	private Long idDescription;
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getErreur() {
		return erreur;
	}
	public void setErreur(String erreur) {
		this.erreur = erreur;
	}
	public Long getIdDescription() {
		return idDescription;
	}
	public void setIdDescription(Long idDescription) {
		this.idDescription = idDescription;
	}
	
}
