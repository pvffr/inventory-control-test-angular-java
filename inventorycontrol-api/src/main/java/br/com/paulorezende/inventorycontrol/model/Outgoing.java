package br.com.paulorezende.inventorycontrol.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Outgoing {
	
	@NotNull
	private String id;
	
	@Min(value = 1)
	private Integer quantity;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}