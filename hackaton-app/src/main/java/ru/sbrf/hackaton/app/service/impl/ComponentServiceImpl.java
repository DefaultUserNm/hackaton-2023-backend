package ru.sbrf.hackaton.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbrf.hackaton.app.model.domain.entity.ComponentEntity;
import ru.sbrf.hackaton.app.model.dto.ComponentDTO;
import ru.sbrf.hackaton.app.repository.ComponentRepository;
import ru.sbrf.hackaton.app.service.ComponentService;

@Service
@RequiredArgsConstructor
public class ComponentServiceImpl implements ComponentService {

    private final ComponentRepository componentRepository;

    @Override
    public ComponentEntity saveComponent(ComponentDTO componentDTO) {


        ComponentEntity componentEntity = new ComponentEntity();

        componentRepository.save(componentEntity);
        return null;
    }
}
