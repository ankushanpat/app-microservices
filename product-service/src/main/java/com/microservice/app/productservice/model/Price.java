package com.microservice.app.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
	private Long priceID;
	private Long productID;
	private Integer originalPrice;
	private Integer discountedPrice;

	public Price() {
	}

	public Price(Long priceID, Integer discountedPrice, Integer originalPrice, Long productID) {
		this.priceID = priceID;
		this.discountedPrice = discountedPrice;
		this.originalPrice = originalPrice;
		this.productID = productID;
	}

	public Long getPriceID() {
		return priceID;
	}

	public void setPriceID(Long priceID) {
		this.priceID = priceID;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public Integer getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Integer originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Integer getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Integer discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
}
