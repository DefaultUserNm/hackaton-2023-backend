package ru.sbrf.hackaton.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbrf.hackaton.app.mapper.ComponentMapper;
import ru.sbrf.hackaton.app.model.domain.entity.ComponentEntity;
import ru.sbrf.hackaton.app.model.dto.ComponentDTO;
import ru.sbrf.hackaton.app.repository.ComponentRepository;
import ru.sbrf.hackaton.app.service.ComponentService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComponentServiceImpl implements ComponentService {

    private final ComponentRepository componentRepository;
    private final ComponentMapper componentMapper;

    @Override
    public ComponentDTO saveComponent(ComponentDTO componentDTO) {
        componentRepository.save(componentMapper.toComponentEntity(componentDTO));
        return componentDTO;
    }

    @Override
    public void saveAllComponents(Set<ComponentDTO> components) {
        componentRepository.saveAll(mapComponentDTOs(components));
    }

    private Set<ComponentEntity> mapComponentDTOs(Set<ComponentDTO> componentDTOs) {
        return componentDTOs.stream()
                .map(componentMapper::toComponentEntity)
                .collect(Collectors.toSet());
    }
}
