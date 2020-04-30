package com.MCloud.facture.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="article_description")
public class ArticleDescription implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idArticleDescrition;
	private String description;
	private String nom;
	@OneToMany(mappedBy="description")
	private Collection<Article> articles;
	
	
	public Long getIdArticleDescrition() {
		return idArticleDescrition;
	}
	public void setIdArticleDescrition(Long idArticleDescrition) {
		this.idArticleDescrition = idArticleDescrition;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArticleDescription(Long idArticleDescrition, String description, String nom) {
		super();
		this.idArticleDescrition = idArticleDescrition;
		this.description = description;
		this.nom = nom;
	}
	
	public ArticleDescription(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}
	public Collection<Article> getArticles() {
		return articles;
	}
	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}
	public ArticleDescription() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
