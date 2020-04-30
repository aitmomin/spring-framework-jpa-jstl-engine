package com.MCloud.facture.models;

import java.util.List;
import com.MCloud.facture.entities.*;

public class ListeLigneFactureModel {
	private Long idFacture;
	private List<Article> articles;
	private List<Facture> factures;
	
	public Long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public List<Facture> getFactures() {
		return factures;
	}
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	
}
