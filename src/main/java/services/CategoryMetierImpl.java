package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isitc.com.Fullproject.isitc.com.Fullproject.entities.Category;
import isitc.com.Fullproject.isitc.com.Fullproject.entities.Product;
import isitc.com.Fullproject.isitc.com.Fullproject.repository.CategoryRepository;
import isitc.com.Fullproject.isitc.com.Fullproject.repository.ProductRepository;

@Service
public class CategoryMetierImpl implements CategoryMetier {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Category ajouterCategory(Category c) {
		return categoryRepository.save(c);
	}

	@Override
	public List<Category> listCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category recupererCategoryParSonId(Long id) {
		//return categoryRepository.getOne(id); https://stackoverflow.com/questions/52656517/no-serializer-found-for-class-org-hibernate-proxy-pojo-bytebuddy-bytebuddyinterc
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category recupererCategory(Category c) {
		//return categoryRepository.getOne(c.getId());
		return categoryRepository.findById(c.getId()).get();
	}

	@Override
	public Category modifierCategory(Category categorieDetail) {
		Category categ = recupererCategory(categorieDetail);

		categ.setNom(categorieDetail.getNom());

		Category updateCategory = ajouterCategory(categ);

		return updateCategory;
	}

	@Override
	public void SupprimerCategory(Category c) {
		categoryRepository.deleteById(c.getId());

	}

	@Override
	public List<Product> recuperProduitsCategorie(Category categ) {
		return productRepository.findByCategory(categ);

	}

}