package isitc.com.Fullproject.isitc.com.Fullproject.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import isitc.com.Fullproject.isitc.com.Fullproject.entities.Category;
import isitc.com.Fullproject.isitc.com.Fullproject.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("select p from Product p where p.nom like :x")
	public Page<Product> produitParMC(@Param("x") String mc, Pageable p);

	public List<Product> findByNom(String nom);

	public Page<Product> findByNom(String des, Pageable p);

	// public Page<Product> findByCategory(Category categorie, Pageable pageable);

	List<Product> findByCategory(Category categorie, Pageable pageable);

	List<Product> findByCategory(Category categ);
}
