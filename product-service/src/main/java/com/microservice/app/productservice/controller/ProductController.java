package com.microservice.app.productservice.controller;

import java.util.ArrayList;
import java.util.List;

import com.microservice.app.productservice.model.Inventory;
import com.microservice.app.productservice.model.*;
import com.microservice.app.productservice.model.Product;
import com.microservice.app.productservice.model.ProductInfo;
import com.microservice.app.productservice.services.InventoryClient;
import com.microservice.app.productservice.services.PriceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

@RestController
public class ProductController {

	List<ProductInfo> productList = new ArrayList<ProductInfo>();
	
    @Autowired
	PriceClient priceClient;

	@Autowired
	InventoryClient inventoryClient;

	public WebClient client=WebClient.create();

	@GetMapping("/product/details/{productid}")
	public Product getProductDetails(@PathVariable Long productid) {
		// Get Name and Desc from product-service
	//	Mono<ProductInfo> productInfo = Mono.just(getProductInfo(productid));

		ProductInfo productInfo = getProductInfo(productid);


		// Get Price from pricing-service
		//Price price = restTemplate.getForObject("http://localhost:8002/price/"+productid, Price.class);

		Price price=priceClient.getPriceDetails(productid);
		// Get Stock Avail from inventory-service
		//Inventory inventory = restTemplate.getForObject("http://localhost:8003/inventory/"+productid, Inventory.class);
		//Mono<Inventory> inventory=client.get().uri("http://localhost:8003/inventory/{productid}",productid).retrieve().bodyToMono(Inventory.class);
		Inventory inventory = inventoryClient.getInventoryDetails(productid);

		return new Product(productInfo.getProductID(),productInfo.getProductName(),productInfo.getProductDesc(),price.getDiscountedPrice(),inventory.getInStock());
	}

	private Product buildProduct(Tuple3<ProductInfo, Price, Inventory> tuple3) {
       return new Product(tuple3.getT1().getProductID(), tuple3.getT1().getProductName(),
			   tuple3.getT1().getProductDesc(), tuple3.getT2().getDiscountedPrice(),
			   tuple3.getT3().getInStock());
	}

	private ProductInfo getProductInfo(Long productid) {
		populateProductList();

		for (ProductInfo p : productList) {
			if (productid.equals(p.getProductID())) {
				return p;
			}
		}

		return null;
	}

	private void populateProductList() {
		productList.add(new ProductInfo(101L, "iPhone", "iPhone is damn expensive!"));
		productList.add(new ProductInfo(102L, "Book", "Book is great!"));
		productList.add(new ProductInfo(103L, "Washing MC", "Washing MC is necessary"));
	}

}
