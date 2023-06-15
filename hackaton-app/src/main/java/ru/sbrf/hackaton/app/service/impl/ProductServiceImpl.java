package ru.sbrf.hackaton.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import ru.sbrf.hackaton.app.exception.HackatonBaseException;
import ru.sbrf.hackaton.app.mapper.ProductMapper;
import ru.sbrf.hackaton.app.model.domain.entity.ProductEntity;
import ru.sbrf.hackaton.app.model.dto.ProductDTO;
import ru.sbrf.hackaton.app.repository.ProductRepository;
import ru.sbrf.hackaton.app.service.ComponentService;
import ru.sbrf.hackaton.app.service.ProductService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static ru.sbrf.hackaton.app.exception.HackatonBaseExceptionCode.FAILED_TO_GET_PRODUCT_ENTITY;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final ComponentService componentService;

    @Override
    public List<ProductDTO> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductDTO)
                .sorted(comparing(p -> p.getProducts().size(), reverseOrder()))
                .toList();
    }

    @Override
    public ProductDTO getProduct(ObjectId productId) {
        return productMapper.toProductDTO(
                handleProductEntity(
                    productRepository.findById(productId)
                )
        );
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        componentService.saveAllComponents(productDTO.getComponents());
        if (productDTO.getProducts() != null) {
            saveAllProducts(productDTO.getProducts());
        }
        productRepository.save(productMapper.toProductEntity(productDTO));
        return productDTO;
    }

    private ProductEntity handleProductEntity(Optional<ProductEntity> optionalProductEntity) {
        return optionalProductEntity
                .orElseThrow(
                        () -> new HackatonBaseException(FAILED_TO_GET_PRODUCT_ENTITY.name())
                );
    }

    private void saveAllProducts(Set<ProductDTO> products) {
        products.stream()
                .filter(Objects::nonNull)
                .forEach(this::saveProduct);
    }
}
