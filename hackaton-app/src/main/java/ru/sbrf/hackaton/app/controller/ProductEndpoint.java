package ru.sbrf.hackaton.app.controller;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sbrf.hackaton.app.model.dto.ProductDTO;
import ru.sbrf.hackaton.app.service.impl.ProductServiceImpl;

import java.net.http.HttpResponse;

@RestController
@RequestMapping(path = "/api/v1/products", produces = "application/json")
@RequiredArgsConstructor
@Validated
public class ProductEndpoint {

    private final ProductServiceImpl productServiceImpl;

    @GetMapping
    public HttpResponse<ProductDTO> getProduct(@RequestParam("productId")ObjectId productId) {
        ProductDTO productDTO = productServiceImpl.getProduct(productId);
        return null;
    }
}
