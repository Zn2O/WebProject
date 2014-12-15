package comp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "UTILISATEUR")
@NamedQueries( {@NamedQuery(name = "Utilisateur.findById", query = "SELECT w FROM Utilisateur w WHERE w.id = :id"), @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT w FROM Utilisateur w WHERE w.Prenom = :prenom"), @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT w FROM Utilisateur w WHERE w.Nom = :nom"), @NamedQuery(name = "Utilisateur.findByPseudo", query = "SELECT w FROM Utilisateur w WHERE w.Pseudo = :pseudo"), @NamedQuery(name = "Utilisateur.findByMotDePasse", query = "SELECT w FROM Utilisateur w WHERE w.MotDePasse = :motdepasse")})
public class Utilisateur {	    

	    @Id
	    @GeneratedValue(strategy=IDENTITY)
	    Integer id;
	    private String Pseudo;
	    private String MotDePasse;
	    private String VerificationMotDePasse;
	    private String Prenom;
	    private String Nom;
	    
	    public Utilisateur() {
	    }

	    public Utilisateur(Integer id) {
	        this.id = id;
	    }

	    public Utilisateur(Integer id, String Pseudo, String MotDePasse, String Nom, String Prenom) {
	        this.id = id;
	        this.Pseudo = Pseudo;
	        this.MotDePasse = MotDePasse;
	        this.Nom = Nom;
	        this.Prenom = Prenom;
	    }
	    
	    /*---------------------------------------------------------------*/
    	    
		public String getPseudo() {
			return Pseudo;
		}
		public void setPseudo(String pseudo) {
			Pseudo = pseudo;
		}
		public String getMotDePasse() {
			return MotDePasse;
		}
		public void setMotDePasse(String motDePasse) {
			MotDePasse = motDePasse;
		}
		public String getVerificationMotDePasse() {
			return VerificationMotDePasse;
		}
		public void setVerificationMotDePasse(String verificationMotDePasse) {
			VerificationMotDePasse = verificationMotDePasse;
		}
		public String getPrenom() {
			return Prenom;
		}
		public void setPrenom(String prenom) {
			Prenom = prenom;
		}
		public String getNom() {
			return Nom;
		}
		public void setNom(String nom) {
			Nom = nom;
		}
		
		/*---------------------------------------------------------------*/

		public int hashCode() {
	        int hash = 0;
	        hash += (this.id != null ? this.id.hashCode() : 0);
	        return hash;
	    }

	    public boolean equals(Object object) {
	        if (object == null || !this.getClass().equals(object.getClass())) {
	            return false;
	        }
	        Utilisateur other = (Utilisateur)object;
	        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
	        return true;
	    }

	    public String toString() {
	        return "" + this.id;
	    }
}
