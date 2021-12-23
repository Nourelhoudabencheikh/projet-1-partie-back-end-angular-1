package isitc.com.Fullproject.isitc.com.Fullproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isitc.com.Fullproject.isitc.com.Fullproject.entities.Product;
import services.ProductMetier;



@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductMetier prodMetier;

	@GetMapping("/produits")
	public List<Product> listeProduits() {
		return prodMetier.listProduits();
	}

	@PostMapping("/produit")
	public Product ajouterProduit(@RequestBody Product p) {
		return prodMetier.ajouterProduit(p);
	}

	@GetMapping("/produit/{id}")
	public Product recupereProduitParSonId(@PathVariable("id") Long id) {
		return prodMetier.recupererProduitParSonId(id);
	}

	@PutMapping("/produit")
	public Product modifierProduit(@RequestBody Product p) {
		return prodMetier.modifierProduit(p);
	}

	@DeleteMapping("/produit")
	public void supprimerProduit(@RequestBody Product p) {
		prodMetier.SupprimerProduit(p);
	}

}