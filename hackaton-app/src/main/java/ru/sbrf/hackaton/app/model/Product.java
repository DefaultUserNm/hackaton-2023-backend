package ru.sbrf.hackaton.app.model;

import lombok.Data;
import org.bson.types.ObjectId;
import ru.sbrf.hackaton.app.model.dto.ComponentDTO;
import ru.sbrf.hackaton.app.model.dto.ProductDTO;

import java.util.Set;

@Data
public class Product {

    ObjectId id;
    String name;
    Set<ProductDTO> productDTOs;
    Set<ComponentDTO> componentDTOs;
    // Set<Team> teams;
}
