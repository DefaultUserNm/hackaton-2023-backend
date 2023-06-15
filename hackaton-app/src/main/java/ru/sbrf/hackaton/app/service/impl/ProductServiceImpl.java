package ru.sbrf.hackaton.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import ru.sbrf.hackaton.app.exception.HackatonBaseException;
import ru.sbrf.hackaton.app.mapper.ProductMapper;
import ru.sbrf.hackaton.app.model.domain.entity.ProductEntity;
import ru.sbrf.hackaton.app.model.dto.ProductDTO;
import ru.sbrf.hackaton.app.repository.ProductRepository;
import ru.sbrf.hackaton.app.service.ProductService;

import java.util.Optional;

import static ru.sbrf.hackaton.app.exception.HackatonBaseExceptionCode.FAILED_TO_GET_PRODUCT_ENTITY;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public ProductDTO getProduct(ObjectId productId) {

        return productMapper.toProductDTO(
                handleProductEntity(
                    productRepository.findById(productId)
                )
        );
    }

    private ProductEntity handleProductEntity(Optional<ProductEntity> optionalProductEntity) {
        return optionalProductEntity
                .orElseThrow(
                        () -> new HackatonBaseException(FAILED_TO_GET_PRODUCT_ENTITY.name())
                );
    }
}
