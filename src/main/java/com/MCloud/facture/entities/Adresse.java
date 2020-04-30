package com.MCloud.facture.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="adresse")
public class Adresse implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAdresse;
	private String ligne1;
	private String ligne2;
	private String ville;
	private String zipcode;
	private String pays;
	@OneToOne(mappedBy="adresseLivraison",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Facture facture;
	@OneToOne(mappedBy="adresseLivraison",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Client clientAL;
	@OneToOne(mappedBy="adresseFacturation",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Client clientAF;
	
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public Client getClientAL() {
		return clientAL;
	}
	public void setClientAL(Client clientAL) {
		this.clientAL = clientAL;
	}
	public Client getClientAF() {
		return clientAF;
	}
	public void setClientAF(Client clientAF) {
		this.clientAF = clientAF;
	}
	public Long getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(Long idAdresse) {
		this.idAdresse = idAdresse;
	}
	public String getLigne1() {
		return ligne1;
	}
	public void setLigne1(String ligne1) {
		this.ligne1 = ligne1;
	}
	public String getLigne2() {
		return ligne2;
	}
	public void setLigne2(String ligne2) {
		this.ligne2 = ligne2;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public Adresse(String ligne1, String ligne2, String ville, String zipcode, String pays) {
		super();
		this.ligne1 = ligne1;
		this.ligne2 = ligne2;
		this.ville = ville;
		this.zipcode = zipcode;
		this.pays = pays;
	}
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
