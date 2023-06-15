package ru.sbrf.hackaton.app.model.dto;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.Set;

@Data
public class ProductDTO {

    ObjectId id;
    String name;
    Set<ProductDTO> productDTOs;
    Set<ComponentDTO> componentDTOs;
    // Set<Team> teams;
}
