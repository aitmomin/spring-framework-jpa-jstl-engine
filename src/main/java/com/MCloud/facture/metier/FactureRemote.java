package com.MCloud.facture.metier;

import java.util.List;

import com.MCloud.facture.entities.*;


public interface FactureRemote {
	
	 public ArticleDescription addArticleDescription(ArticleDescription ad);
	 public Article addArticle(Article a, Long description);	 
	 public Client addClient(Client c, Long AdresseLivraison, Long AdresseFacturation);
	 public Adresse addAdresse(Adresse a);
	 public void suppLigne(Long idL); 
	 public List<Client> listClients();
	 public List<Article> listArticles();
	 public Facture addFacture(Long idClient, Long idAdresse, Facture f);
	 public LigneFacture addLigneFacture(LigneFacture lf, Long idFacture, Long idArticle);	 
	 public List<LigneFacture> listLigneFacture(Long idFacture);
	 public void delFacture(Facture f);
}
