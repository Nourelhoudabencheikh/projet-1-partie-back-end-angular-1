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

import isitc.com.Fullproject.isitc.com.Fullproject.entities.Category;
import services.CategoryMetier;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryMetier catMetier;

	@GetMapping("/categories")
	public List<Category> listeCategories() {
		return catMetier.listCategories();
	}

	@PostMapping("/categorie")
	public Category ajouterCategory(@RequestBody Category cat) {
		return catMetier.ajouterCategory(cat);
	}

	@GetMapping("/categorie/{id}")
	public Category recupereCategoryParSonId(@PathVariable("id") Long id) {
		return catMetier.recupererCategoryParSonId(id);
	}

	@PutMapping("/categorie")
	public Category modifierCategory(@RequestBody Category cat) {
		return catMetier.modifierCategory(cat);
	}

	@DeleteMapping("/categorie")
	public void supprimerCategory(@RequestBody Category cat) {
		catMetier.SupprimerCategory(cat);
	}

}