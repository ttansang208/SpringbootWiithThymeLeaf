package com.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")

public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private String producer;
	

	@Column(nullable = false)
	private double price;
	
	@Column
	private String description;
	
	@Column(nullable = false)
	private Boolean status;
	
	public ProductEntity(Integer id, String name, String type, String producer, double price, String description, Boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.producer = producer;
		this.price = price;
		this.description = description;
		this.status = status;
	}
	
	
	public ProductEntity() {
		super();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
		

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", type=" + type + ", producer=" + producer + ", price="
				+ price + ", description=" + description + ", status=" + status + "]";
	}

	
}
