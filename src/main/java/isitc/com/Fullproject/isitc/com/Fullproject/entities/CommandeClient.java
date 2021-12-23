package isitc.com.Fullproject.isitc.com.Fullproject.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;

@Entity
public class CommandeClient implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private float montant;
	private Date dateCreation;
	private long numeroConfirmation;
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;
	@OneToMany(mappedBy = "cmdClient", fetch = FetchType.LAZY)
	private Set<ProductCommandeClient> prodCmdCli = new HashSet<ProductCommandeClient>();

	public CommandeClient() {
	}

	public CommandeClient(long id, float montant, Date dateCreation, long numeroConfirmation, Client client) {
		this.id = id;
		this.montant = montant;
		this.dateCreation = dateCreation;
		this.numeroConfirmation = numeroConfirmation;
		this.client = client;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public long getNumeroConfirmation() {
		return numeroConfirmation;
	}

	public void setNumeroConfirmation(long numeroConfirmation) {
		this.numeroConfirmation = numeroConfirmation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@JsonIgnore
	public Set<ProductCommandeClient> getProdCmdCli() {
		return prodCmdCli;
	}

	public void setProdCmdCli(Set<ProductCommandeClient> prodCmdCli) {
		this.prodCmdCli = prodCmdCli;
	}

}