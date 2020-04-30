package com.MCloud.facture.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name="article")
public class Article implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ref;
	private double prix;
	@ManyToOne
	@JoinColumn(name="IdDescription")
	private ArticleDescription description;
	@OneToOne(mappedBy="article",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private LigneFacture ligne;
	
	public LigneFacture getLigne() {
		return ligne;
	}
	public void setLigne(LigneFacture ligne) {
		this.ligne = ligne;
	}
	public ArticleDescription getDescription() {
		return description;
	}
	public void setDescription(ArticleDescription description) {
		this.description = description;
	}
	public Article(double prix) {
		super();
		this.prix = prix;
	}
	public Article(Long ref, double prix) {
		super();
		this.ref = ref;
		this.prix = prix;
	}
	public Article() {
		super();
	}
	public Long getRef() {
		return ref;
	}
	public void setRef(Long ref) {
		this.ref = ref;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
}
