package com.MCloud.facture.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="client")
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	private String nomClient;
	private String prenomClient;
	@OneToOne(mappedBy="client",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Facture facture;
	@OneToOne
	@JoinColumn(name="IdAdresseLivraison")
	private Adresse adresseLivraison;
	@OneToOne
	@JoinColumn(name="IdAdresseFacturation")
	private Adresse adresseFacturation;
	
	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}
	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}
	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}
	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
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
	public Client(Long idClient, String nomClient, String prenomClient) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
	}
	public Client(String nomClient, String prenomClient) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
