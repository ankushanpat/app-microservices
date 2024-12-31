package com.microservice.app.productservice.services;

import com.microservice.app.productservice.model.Price;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@FeignClient(name="api-gateway")
public interface PriceClient {
    @GetMapping("/price/{productid}")
    public Price getPriceDetails(@PathVariable("productid") Long productid);
}
