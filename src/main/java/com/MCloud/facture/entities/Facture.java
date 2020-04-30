package com.MCloud.facture.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Facture")
public class Facture implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFacture;
	private String commentaires;
	@OneToMany(mappedBy="facture")
	private Collection<LigneFacture> lignes;
	@OneToOne
	@JoinColumn(name="IdClient")
	private Client client;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdAdresse")
	private Adresse adresseLivraison;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}
	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}
	public Long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	public Collection<LigneFacture> getLignes() {
		return lignes;
	}
	public void setLignes(Collection<LigneFacture> lignes) {
		this.lignes = lignes;
	}
	public Long getIdArticleDescrition() {
		return idFacture;
	}
	public void setIdArticleDescrition(Long idFacture) {
		this.idFacture = idFacture;
	}
	public String getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	public Facture(Long idFacture, String commentaires) {
		super();
		this.idFacture = idFacture;
		this.commentaires = commentaires;
	}
	public Facture(String commentaires) {
		super();
		this.commentaires = commentaires;
	}
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static double total(Collection<LigneFacture> lig) {
		double tot=0;
		for(LigneFacture l : lig) {
			tot+=l.total();
		}
		return tot;
	}
	public static int nbrArticle(Collection<LigneFacture> lig) {
		int nbr=0;
		for(LigneFacture l : lig) {
			nbr+=l.getNbrArticle();
		}
		return nbr;
	}
}
