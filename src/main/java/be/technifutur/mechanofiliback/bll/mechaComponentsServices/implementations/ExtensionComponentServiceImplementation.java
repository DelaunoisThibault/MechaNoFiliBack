package be.technifutur.mechanofiliback.bll.mechaComponentsServices.implementations;

import be.technifutur.mechanofiliback.bll.mechaComponentsServices.ExtensionComponentService;
import be.technifutur.mechanofiliback.dal.repositories.mechaComponentsRepositories.ExtensionComponentRepository;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ExtensionComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExtensionComponentServiceImplementation implements ExtensionComponentService {

    private final ExtensionComponentRepository extensionComponentRepository;

    @Override
    public ExtensionComponent createExtensionComponent(ExtensionComponent extensionComponent) {
        extensionComponentRepository.save(extensionComponent);
        return extensionComponent;
    }

    @Override
    public ExtensionComponent saveExtensionComponent(ExtensionComponent extensionComponent) {

        if(extensionComponentRepository.existsById(extensionComponent.getId())) {
            throw new RuntimeException("id already exists");
        }
        extensionComponentRepository.save(extensionComponent);
        return extensionComponent;
    }

    @Override
    public ExtensionComponent findExtensionComponentById(Long id) {
        return extensionComponentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
    }

    @Override
    public Page<ExtensionComponent> findAll(Pageable pageable) {
        return extensionComponentRepository.findAll(pageable);
    }

    @Override
    public void update(Long id, ExtensionComponent extensionComponent) {
        ExtensionComponent existingExtension = extensionComponentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
        existingExtension.setName(extensionComponent.getName());
        existingExtension.setWeight(extensionComponent.getWeight());
        existingExtension.setPower_consumption(extensionComponent.getPower_consumption());
        existingExtension.setComments(extensionComponent.getComments());
    }
    @Override
    public void deleteById(Long id) {
        if(!extensionComponentRepository.existsById(id)) {
            throw new RuntimeException("id not found");
        }
        extensionComponentRepository.deleteById(id);

    }
}
