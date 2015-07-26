package br.com.paulorezende.inventorycontrol.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "incomings")
public class Incoming {
	
	@Id
	private String id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String description;
	
	@Min(value = 1)
	private Integer value;
	
	@Min(value = 1)
	private Integer quantity;
	
	@Min(value = 1)
	private Integer minQuantity;
	
	private boolean lowerQuantity;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getMinQuantity() {
		return minQuantity;
	}
	public void setMinQuantity(Integer minQuantity) {
		this.minQuantity = minQuantity;
	}
	public boolean isLowerQuantity() {
		return lowerQuantity;
	}
	public void setLowerQuantity(boolean lowerQuantity) {
		this.lowerQuantity = lowerQuantity;
	}
	
}