package com.MCloud.facture.controleur;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.MCloud.facture.models.*;
import com.MCloud.facture.entities.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MCloud.facture.metier.FactureRemote;



@Controller
public class FactureServlet {
	@Inject
	FactureRemote metier;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home() {
			
		return "index";
	}
	@RequestMapping(value = "/creerArticle", method = RequestMethod.GET)
	public String ajouterArticle(@Valid ArticleModel am, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "creerArticle";
		}
		Article a = new Article(am.getPrix());
		metier.addArticle(a, am.getIdDescription());
		return "creerArticle";
	}
	@RequestMapping(value = "/creerArticleDescription", method = RequestMethod.GET)
	public String creerArticleDescription(@Valid ArticleDescriptionModel adm, BindingResult bindingResult, Model model) {
		return "creerArticleDescription";
	}
	@RequestMapping(value = "/creerArticleDescription2", method = RequestMethod.GET)
	public String creerArticleDescription2(@Valid ArticleDescriptionModel adm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "creerArticleDescription";
		}
		ArticleDescription ad = new ArticleDescription(adm.getNom(), adm.getDescription());
		metier.addArticleDescription(ad);
		return "creerArticleDescription";
	}
	@RequestMapping(value = "/creerClient", method = RequestMethod.GET)
	public String ajouterClient(@Valid ClientModel cm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "creerClient";
		}
		Client c = new Client(cm.getNomClient(), cm.getPrenomClient());
		metier.addClient(c, cm.getIdAdresseLivraison(), cm.getIdAdresseFacturation());	
		return "creerClient";
	}
	@RequestMapping(value = "/creerFacture", method = RequestMethod.GET)
	public String creerFacture(@Valid FactureModel fm,	BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "creerFacture";
		}
		Facture f = new Facture(fm.getCommentaires());		
		metier.addFacture(fm.getIdClient(), fm.getIdAdresseLivraison(), f);	
		return "creerFacture";
	}
	@RequestMapping(value = "/creerLignes", method = RequestMethod.GET)
	public String creerLignes(@Valid LigneFactureModel lfm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "creerLignes";
		}
		LigneFacture lf = new LigneFacture(lfm.getNbrArticle());		
		metier.addLigneFacture(lf, lfm.getIdFacture(), lfm.getIdArticle());	
		return "creerLignes";
	}
	@RequestMapping(value = "/listerArticles", method = RequestMethod.GET)
	public String listerArticles(@Valid ListeArticleDescriptionModel adm,	BindingResult bindingResult, Model model) {
		model.addAttribute("listeArt",metier.listArticles());
		//adm.setArticles(metier.listArticles());
		return "listerArticles";
	}
	@RequestMapping(value = "/listerClients", method = RequestMethod.GET)
	public String listerClients(@Valid ListeClientAdresseModel cam,	BindingResult bindingResult, Model model) {
		model.addAttribute("laliste",metier.listClients());
		//cam.setClients(metier.listClients());
		return "listerClients";
	}	
	@RequestMapping(value = "/listerFactures", method = RequestMethod.GET)
	public String listerLignes(@Valid ListeLigneFactureModel lfm, BindingResult bindingResult, Model model) {		
		model.addAttribute("lignes",metier.listLigneFacture(lfm.getIdFacture()));
		return "listerFactures";	
	}
	@RequestMapping(value = "/suppLigneFacture", method = RequestMethod.GET)
	public String suppLigneFacture(@Valid ListeLigneFactureModel lfm, @RequestParam("idl") String idl, Model model) {
		Long l = Long.parseLong(idl);		
		metier.suppLigne(l);
		return "listerFactures";
	}
}
