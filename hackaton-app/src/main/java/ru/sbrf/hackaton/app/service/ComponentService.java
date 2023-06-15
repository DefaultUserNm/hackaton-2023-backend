package ru.sbrf.hackaton.app.service;

import ru.sbrf.hackaton.app.model.dto.ComponentDTO;

import java.util.Set;

public interface ComponentService {

    void saveAllComponents(Set<ComponentDTO> components);
}
