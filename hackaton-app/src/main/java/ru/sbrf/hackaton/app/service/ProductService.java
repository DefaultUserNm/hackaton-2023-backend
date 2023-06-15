package ru.sbrf.hackaton.app.service;

import org.bson.types.ObjectId;
import ru.sbrf.hackaton.app.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getProducts();
    ProductDTO getProduct(ObjectId productId);
    ProductDTO saveProduct(ProductDTO productDTO);
}
