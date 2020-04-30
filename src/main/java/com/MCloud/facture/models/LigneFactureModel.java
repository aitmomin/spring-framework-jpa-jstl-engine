package com.MCloud.facture.models;

import javax.validation.constraints.NotNull;

public class LigneFactureModel {
	private int nbrArticle;
	@NotNull
	private Long idFacture;
	@NotNull
	private Long idArticle;
	private String erreur;
	public int getNbrArticle() {
		return nbrArticle;
	}
	public void setNbrArticle(int nbrArticle) {
		this.nbrArticle = nbrArticle;
	}
	public Long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	public Long getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}
	public String getErreur() {
		return erreur;
	}
	public void setErreur(String erreur) {
		this.erreur = erreur;
	}
	
}
