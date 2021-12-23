package isitc.com.Fullproject.isitc.com.Fullproject.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
//hedhy besh na3mlou une entit" qui sera une table fel BD w hakeka k trunni yasna3 table toul fl bd
public class Category implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//hedha besh ykoun l Id auto-incriment
	private Long id;
	private String nom;
	@Lob 
	//Lob : Long Object Binary 
	private byte[] imgCategory;
	// hedhy de type byte lel les images mtaa les catégories
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//une catégorie contient plusieurs produit
	private Set<Product> products;

	public Category() {
	}

	public Category(String nom, Set<Product> products) {
		this.nom = nom;
		this.products = products;
	}

	public Category(String nom) {
		this.nom = nom;
	}

	@JsonIgnore
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public byte[] getImgCategory() {
		return imgCategory;
	}

	public void setImgCategory(byte[] imgCategory) {
		this.imgCategory = imgCategory;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}
}
