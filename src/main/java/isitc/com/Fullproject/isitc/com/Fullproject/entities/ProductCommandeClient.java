package isitc.com.Fullproject.isitc.com.Fullproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import isitc.com.Fullproject.isitc.com.Fullproject.entities.Product;


@Entity
public class ProductCommandeClient implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_CMDCLIENT_ID")
	private long id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CMDCLIENT_ID")
	private CommandeClient cmdClient;
	@Column(name = "REGISTERED_DATE")
	@Temporal(TemporalType.DATE)
	private Date registeredDate;
	private int quantite;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CommandeClient getCmdClient() {
		return cmdClient;
	}

	public void setCmdClient(CommandeClient cmdClient) {
		this.cmdClient = cmdClient;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}