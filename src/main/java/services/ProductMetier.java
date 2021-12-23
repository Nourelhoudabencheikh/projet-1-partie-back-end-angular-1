package services;

import java.util.List;

import isitc.com.Fullproject.isitc.com.Fullproject.entities.Product;

public interface ProductMetier {
	// Ajouter un produit
		public Product ajouterProduit(Product c);

		// Lister tous les categories
		public List<Product> listProduits();

		// Recupérer un produit par son id
		public Product recupererProduitParSonId(Long id);

		// Recupérer un produit
		public Product recupererProduit(Product c);

		// Modifier un produit
		public Product modifierProduit(Product produitDetail);

		// Supprimer un produit
		public void SupprimerProduit(Product c);

}
