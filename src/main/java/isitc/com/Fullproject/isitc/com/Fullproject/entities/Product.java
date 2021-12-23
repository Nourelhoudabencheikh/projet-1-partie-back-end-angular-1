package isitc.com.Fullproject.isitc.com.Fullproject.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private float prix;
	private String description;
	@Column(name = "DERNIER_MAJ")
	@Temporal(TemporalType.DATE)
	private Date dernier_maj;
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Set<ProductCommandeClient> prodCmdClient = new HashSet<ProductCommandeClient>();
	@Lob
	private byte[] imgProduit;

	public Product() {
	}

	public Product(String nom, float prix, String description, Date dernier_maj) {

		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.dernier_maj = dernier_maj;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDernier_maj() {
		return dernier_maj;
	}

	public void setDernier_maj(Date dernier_maj) {
		this.dernier_maj = dernier_maj;
	}

	@JsonIgnore
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@JsonIgnore
	public Set<ProductCommandeClient> getProdCmdClient() {
		return prodCmdClient;
	}

	public void setProdCmdClient(Set<ProductCommandeClient> prodCmdClient) {
		this.prodCmdClient = prodCmdClient;
	}

	public byte[] getImgProduit() {
		return imgProduit;
	}

	public void setImgProduit(byte[] imgProduit) {
		this.imgProduit = imgProduit;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
