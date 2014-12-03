package comp;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUIT")
@NamedQueries( {@NamedQuery(name = "Produit.findById", query = "SELECT p FROM Produit p  WHERE p.id = :id"),
	@NamedQuery(name = "Produit.findByNom", query = "SELECT p FROM Produit p WHERE p.Nom = :nom"),
	@NamedQuery(name = "Produit.findByPrix", query = "SELECT p FROM Produit p  WHERE p.Prix = :prix"),
	@NamedQuery(name = "Produit.findByQuantite", query = "SELECT p FROM Produit p WHERE p.Quantite = :quantite")})
public class Produit {

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name = "ID", nullable = false) 
	Integer id;

	@Column(name = "NOM",nullable = false)
	private String Nom;

	@Column(name = "QUANTITE",nullable = false)
	private String Quantite;

	@Column(name = "PRIX",nullable = false)
	private String Prix;

	public Produit(Integer id) {
		this.id = id;
	}

	public Produit() {
	}

	public Produit(Integer id, String Nom, String quantite, String prix) {
		this.id = id;
		this.Nom = Nom;
		this.Quantite  = quantite;
		this.Prix = prix;
	}
	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrix() {
		return Prix;
	}

	public void setPrix(String prix) {
		Prix = prix;
	}

	public void setQuantite(String quantite) {
		Quantite = quantite;
	}

	public String getQuantite() {
		return this.Quantite;
	} 

	public int hashCode() {
		int hash = 0;
		hash += (this.id != null ? this.id.hashCode() : 0);
		return hash;
	}

	public boolean equals(Object object) {
		if (object == null || !this.getClass().equals(object.getClass())) {
			return false;
		}
		Produit other = (Produit)object;
		if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
		return true;
	}

	public String toString() {
		return "" + this.id;
	}
}
