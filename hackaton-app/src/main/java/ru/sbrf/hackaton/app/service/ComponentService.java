package ru.sbrf.hackaton.app.service;

import ru.sbrf.hackaton.app.model.dto.ComponentDTO;
import java.util.Set;


public interface ComponentService {

    ComponentDTO saveComponent(ComponentDTO componentDTO);

    void saveAllComponents(Set<ComponentDTO> components);

}
