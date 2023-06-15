package ru.sbrf.hackaton.app.service;

import org.bson.types.ObjectId;
import ru.sbrf.hackaton.app.model.dto.ProductDTO;

public interface ProductService {

    ProductDTO getProduct(ObjectId productId);
    void saveProduct(ProductDTO productDTO);
}
