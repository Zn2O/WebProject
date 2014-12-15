package com;

import interf.ComposantProduitRemote;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServlet;
import javax.transaction.UserTransaction;

import comp.Produit;

@SuppressWarnings("serial")
@Stateful
@Remote(ComposantProduitRemote.class)
public class GestionProduit extends HttpServlet implements ComposantProduitRemote{
	
	public static final String PRODUIT_SESSION_KEY = "produit";

	@PersistenceContext (unitName = "AmazonProjectPersist")
	private EntityManager em;

    private String Nom;    
    private String Quantite;
    private String Prix;

	public String NouveauProduit() {
		FacesContext context = FacesContext.getCurrentInstance();
		Produit nouveauProduit = getProduit();		
		if (nouveauProduit == null) {
			
			nouveauProduit = new Produit();
			nouveauProduit.setNom(Nom);
			nouveauProduit.setQuantite(Quantite);
			nouveauProduit.setPrix(Prix);
			try {
				//utx.begin();
				em.persist(nouveauProduit);
				//utx.commit();
				return "produit";
			} catch (Exception e) {               
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erreur lors de la création du produit parce que t'es trop PD","Gros con tu sais pas créer un simple produit NAN MAIS ALLO QUOI ?!");
				context.addMessage(null, message);
				Logger.getAnonymousLogger().log(Level.SEVERE,"Peut pas creer un produit je sais pas pourquoi, ce tp me fait chier srx",e);
				return null;
			}
		} else {           
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Produit '"+ Nom+ "' pas disponible MA GUEULE. ","Prends en un autre stp");			
			context.addMessage(null, message);
			return null;
		}        
	}
	private Produit getProduit() {
		try {
			Produit produit = (Produit)
					em.createNamedQuery("Produit.findByNom").
					setParameter("Produit", Nom).getSingleResult();
			return produit; 
		} catch (NoResultException nre) {
			return null;
		}
	}
	public String getQuantite() {
		return Quantite;
	}
	public void setQuantite(String quantite) {
		Quantite = quantite;
	}
	public String getPrix() {
		return Prix;
	}
	public void setPrix(String prix) {
		Prix = prix;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}

}
