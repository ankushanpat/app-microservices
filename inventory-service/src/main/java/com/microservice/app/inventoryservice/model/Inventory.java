package com.microservice.app.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Inventory {
	private Long inventoryID;
	private Long productID;
	private Boolean inStock;

	public Inventory(Long inventoryID, Long productID, Boolean inStock) {
		this.inventoryID = inventoryID;
		this.productID = productID;
		this.inStock = inStock;
	}

	public Long getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(Long inventoryID) {
		this.inventoryID = inventoryID;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public Boolean getInStock() {
		return inStock;
	}

	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}
}
