package ru.sbrf.hackaton.app.controller;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.hackaton.app.model.dto.ProductDTO;
import ru.sbrf.hackaton.app.service.ProductService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/products", produces = "application/json")
@RequiredArgsConstructor
@Validated
public class ProductEndpoint {

    private final ProductService productService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ProductDTO getProduct(@PathVariable(value = "id") String productId) {
        return productService.getProduct(new ObjectId(productId));
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }
}
