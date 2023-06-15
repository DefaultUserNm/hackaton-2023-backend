package ru.sbrf.hackaton.app.service;

import ru.sbrf.hackaton.app.model.domain.entity.ComponentEntity;
import ru.sbrf.hackaton.app.model.dto.ComponentDTO;

public interface ComponentService {

    ComponentEntity saveComponent(ComponentDTO componentDTO);
}
