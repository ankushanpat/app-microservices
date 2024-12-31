package com.microservice.app.productservice.services;

import com.microservice.app.productservice.model.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@FeignClient(name="api-gateway")
public interface InventoryClient {
    @GetMapping("/inventory/{productid}")
    public Inventory getInventoryDetails(@PathVariable("productid") Long productid);
}
