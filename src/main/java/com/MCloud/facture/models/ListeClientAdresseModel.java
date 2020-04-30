package com.MCloud.facture.models;

import java.util.List;
import com.MCloud.facture.entities.*;


public class ListeClientAdresseModel {
	private List<Client> clients;
	private List<Adresse> adresses;
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public List<Adresse> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}
	
}
