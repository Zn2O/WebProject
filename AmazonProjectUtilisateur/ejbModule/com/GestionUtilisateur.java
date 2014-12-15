package com;

import interf.ComposantUtilisateurRemote;

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
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

import comp.Utilisateur;
@Stateful
@Remote(ComposantUtilisateurRemote.class)
public class GestionUtilisateur implements ComposantUtilisateurRemote {

	public static final String UTILISATEUR_SESSION_KEY = "utilisateur";

	@PersistenceContext (unitName = "AmazonProjectPersist")
	private EntityManager em;

	@Resource 
	private UserTransaction utx;

	private String pseudo;
	private String motDePasse;
	private String motDePasseVerification;
	private String nom;
	private String prenom;   

	/*---------------------------------------------------------------*/

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getMotDePasseVerification() {
		return motDePasseVerification;
	}

	public void setMotDePasseVerification(String motDePasseVerification) {
		this.motDePasseVerification = motDePasseVerification;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/*---------------------------------------------------------------*/
	
	public String UtilisateurValidation() {   
		FacesContext context = FacesContext.getCurrentInstance();
		Utilisateur utilisateur = getUtilisateur();
		if (utilisateur != null) {
			if (!utilisateur.getMotDePasse().equals(motDePasse)) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez saisir un login valide","Le mot de passe est incorrect.");                                           
				context.addMessage(null, message);
				return null;
			}

			context.getExternalContext().getSessionMap().put(UTILISATEUR_SESSION_KEY, utilisateur);
			return "app-main";
		} else {           
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Login erroné!",
					"Peudo '"+ pseudo+"' n'existe pas.");
			context.addMessage(null, message);
			return null;
		}
	}

	public String NouvelUtilisateur() {
		FacesContext context = FacesContext.getCurrentInstance();
		Utilisateur nouvelUtilisateur = getUtilisateur();
		if (nouvelUtilisateur == null) {
			if (!motDePasse.equals(motDePasseVerification)) {
				FacesMessage message = new FacesMessage("Les mots de passe ne sont pas identiques, idiot");
				context.addMessage(null, message);
				return null;
			}
			nouvelUtilisateur = new Utilisateur();
			nouvelUtilisateur.setNom(nom);
			nouvelUtilisateur.setPrenom(prenom);
			nouvelUtilisateur.setMotDePasse(motDePasse);
			nouvelUtilisateur.setPseudo(pseudo);

			try {
				utx.begin();
				em.persist(nouvelUtilisateur);
				utx.commit();
				return "login";
			} catch (Exception e) {               
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erreur lors de la création de l'utilisateur parce que t'es trop PD","Gros con tu sais pas créer un simple compte NAN MAIS ALLO QUOI ?!");
				context.addMessage(null, message);
				Logger.getAnonymousLogger().log(Level.SEVERE,"Peut pas creer un nouvel utilisateur je sais pas pourquoi, ce tp me fait chier srx",e);
				return null;
			}
		} else {           
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Pseudo '"+ pseudo+ "' pas disponible MA GUEULE. ","Prends en un autre stp");			
			context.addMessage(null, message);
			return null;
		}        
	}

	public String logout() {
		HttpSession session = (HttpSession)
				FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "login";

	}

	// --------------------------------------------------------- 

	private Utilisateur getUtilisateur() {
		try {
			Utilisateur utilisateur = (Utilisateur)
					em.createNamedQuery("Utilisateur.findByPseudo").
					setParameter("pseudo", pseudo).getSingleResult();
			return utilisateur; 
		} catch (NoResultException nre) {
			return null;
		}
	}

}