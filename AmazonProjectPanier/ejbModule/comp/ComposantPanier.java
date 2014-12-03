package comp;

import interf.ComposantPanierRemote;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
@Remote(ComposantPanierRemote.class)
public class ComposantPanier implements ComposantPanierRemote
{
	@PersistenceContext (unitName = "AmazonProjectPersist")
	EntityManager em;

	@Override
	public void ajouterProduit()
	{
		System.err.println("TEST Ajout Produit !");	
		Produit produit = new Produit();
		produit.setNom("tamere");
		produit.setPrix("10");
		produit.setQuantite("1");
		em.persist(produit);
	}

}
