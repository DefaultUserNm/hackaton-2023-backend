package ru.sbrf.hackaton.app.controller;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.hackaton.app.model.dto.ProductDTO;
import ru.sbrf.hackaton.app.service.ProductService;

@RestController
@RequestMapping(path = "/api/v1/products", produces = "application/json")
@RequiredArgsConstructor
@Validated
public class ProductEndpoint {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ProductDTO> getProduct(@PathVariable(value = "id") String productId) {
        ProductDTO productDTO = productService.getProduct(new ObjectId(productId));
        return ResponseEntity.ok(productDTO);
    }
}
