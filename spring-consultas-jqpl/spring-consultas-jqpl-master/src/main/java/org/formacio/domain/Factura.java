package org.formacio.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Table(name = "t_factures")
@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fac_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fac_client")
	private Client totalClient;

	@OneToMany
	@JoinColumn(name = "lin_factura")
	private Set<LiniaFactura> linies = new HashSet<>();


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return this.totalClient;
	}

	public void setClient(Client client) {
		this.totalClient = client;
	}

	public Set<LiniaFactura> getLinies() {
		return linies;
	}

	public void setLinies(Set<LiniaFactura> linies) {
		this.linies = linies;
	}
	
	
}
