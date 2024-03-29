package org.formacio.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_liniesfact")
public class LiniaFactura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lin_id")
	private Long id;

	@Column(name = "lin_producte")
	private String producte;

	@Column(name = "lin_total")
	private Integer total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProducte() {
		return producte;
	}

	public void setProducte(String producte) {
		this.producte = producte;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
}
