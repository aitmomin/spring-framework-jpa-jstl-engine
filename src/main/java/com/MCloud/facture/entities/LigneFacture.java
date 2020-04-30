package com.MCloud.facture.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ligne_facture")
public class LigneFacture {
	@Override
	public String toString() {
		return "LigneFacture [idLigneFacture=" + idLigneFacture + ", nbrArticle=" + nbrArticle + ", facture=" + facture
				+ ", article=" + article + "]";
	}
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLigneFacture;
	private int nbrArticle;
	@ManyToOne
	@JoinColumn(name="IdFacture")
	private Facture facture;
	@OneToOne
	@JoinColumn(name="IdArticle")
	private Article article;
	
	public LigneFacture(int nbrArticle) {
		super();
		this.nbrArticle = nbrArticle;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public LigneFacture(Long idLigneFacture, int nbrArticle) {
		super();
		this.idLigneFacture = idLigneFacture;
		this.nbrArticle = nbrArticle;
	}
	public LigneFacture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdLigneFacture() {
		return idLigneFacture;
	}
	public void setIdLigneFacture(Long idLigneFacture) {
		this.idLigneFacture = idLigneFacture;
	}
	public int getNbrArticle() {
		return nbrArticle;
	}
	public void setNbrArticle(int nbrArticle) {
		this.nbrArticle = nbrArticle;
	}
	public double total() {
		double tot=0;
		tot = this.nbrArticle*this.article.getPrix();
		return tot;
	}
}
