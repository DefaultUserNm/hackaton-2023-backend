package ru.sbrf.hackaton.app.service;

import ru.sbrf.hackaton.app.model.domain.entity.ComponentEntity;
import ru.sbrf.hackaton.app.model.dto.ComponentDTO;
import java.util.Set;


public interface ComponentService {

    ComponentEntity saveComponent(ComponentDTO componentDTO);

    void saveAllComponents(Set<ComponentDTO> components);

}
