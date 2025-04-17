package be.technifutur.mechanofiliback.bll.implementations;

import be.technifutur.mechanofiliback.bll.ExtensionComponentService;
import be.technifutur.mechanofiliback.bll.MechaComponentService;
import be.technifutur.mechanofiliback.dal.repositories.ExtensionComponentRepository;
import be.technifutur.mechanofiliback.dal.repositories.MechaComponentRepository;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ExtensionComponent;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.MechaComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExtensionComponentServiceImplementation implements ExtensionComponentService {

    private final ExtensionComponentRepository extensionComponentRepository;

    @Override
    public ExtensionComponent saveExtensionComponent(ExtensionComponent extensionComponent) {
        return null;
    }

    @Override
    public ExtensionComponent createExtensionComponent(ExtensionComponent extensionComponent) {
        return null;
    }

    @Override
    public ExtensionComponent findExtensionComponentById(Long id) {
        return null;
    }

    @Override
    public Page<ExtensionComponent> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void update(Long id, ExtensionComponent extensionComponent) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
