package com.MCloud.facture.metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.MCloud.facture.entities.*;
import org.springframework.transaction.annotation.Transactional;

import com.MCloud.facture.entities.*;


@Transactional
public class FactureBean implements FactureRemote{
	@PersistenceContext
	EntityManager em;

	
	@Override
	public Article addArticle(Article a, Long description) {
		ArticleDescription ad=em.find(ArticleDescription.class, description);
		a.setDescription(ad);
		em.persist(a);
		return a;
	}
	@Override
	public ArticleDescription addArticleDescription(ArticleDescription ad) {
		em.persist(ad);
		return ad;
	}	
	@Override
	public Client addClient(Client c, Long AdresseLivraison, Long AdresseFacturation) {
		Adresse al=em.find(Adresse.class, AdresseLivraison);
		Adresse af=em.find(Adresse.class, AdresseFacturation);
		c.setAdresseLivraison(al);
		c.setAdresseFacturation(af);
		em.persist(c);
		return c;
	}
	@Override
	public Adresse addAdresse(Adresse a) {
		em.persist(a);
		return a;
	}	
	@Override
	public void suppLigne(Long idL) {
		/*LigneFacture lf = em.find(LigneFacture.class, idF);
		Facture f = em.find(Facture.class, idF);
		Article a = em.find(Article.class, idA);
		lf.setArticle(a);
		lf.setFacture(f);
		System.out.println(lf);
		em.remove(lf);	*/
		Query query = em.createQuery("DELETE FROM LigneFacture lf WHERE lf.idLigneFacture=:id");
		int deletedCount = query.setParameter("id", idL).executeUpdate();
	}
	@Override
	public Facture addFacture(Long idClient, Long idAdresse, Facture f) {
		Client c = em.find(Client.class, idClient);
		Adresse a = em.find(Adresse.class, idAdresse);
		f.setClient(c);
		f.setAdresseLivraison(a);
		em.persist(f);
		return f;
	}
	@Override
	public LigneFacture addLigneFacture(LigneFacture lf, Long idFacture, Long idArticle) {
		Facture f = em.find(Facture.class, idFacture);
		Article a = em.find(Article.class, idArticle);
		lf.setArticle(a);
		lf.setFacture(f);
		em.persist(lf);
		return lf;
	}
	@Override
	public List<Client> listClients() {
		Query req=em.createQuery("select cl from Client cl");
		return req.getResultList();
	}
	@Override
	public List<Article> listArticles() {
		Query req=em.createQuery("select ar from Article ar");
		return req.getResultList();
	}
	@Override
	public List<LigneFacture> listLigneFacture(Long idFacture) {
		Query req=em.createQuery("select lf from LigneFacture lf where lf.facture.idFacture=:x");
		req.setParameter("x", idFacture);
		return req.getResultList();
	}
	@Override
	public void delFacture(Facture f) {
		em.remove(f);
	}

}
