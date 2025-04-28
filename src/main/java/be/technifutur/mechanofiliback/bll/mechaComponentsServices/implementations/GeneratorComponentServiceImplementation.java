package be.technifutur.mechanofiliback.bll.mechaComponentsServices.implementations;

import be.technifutur.mechanofiliback.bll.mechaComponentsServices.GeneratorComponentService;
import be.technifutur.mechanofiliback.dal.repositories.mechaComponentsRepositories.GeneratorComponentRepository;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.GeneratorComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeneratorComponentServiceImplementation implements GeneratorComponentService {

    private final GeneratorComponentRepository generatorComponentRepository;

    @Override
    public GeneratorComponent createGeneratorComponentNoImage(GeneratorComponent generatorComponent) {
        generatorComponentRepository.save(generatorComponent);
        return generatorComponent;
    }

    @Override
    public GeneratorComponent createGeneratorComponentNoComment(GeneratorComponent generatorComponent) {
        generatorComponentRepository.save(generatorComponent);
        return generatorComponent;
    }

    @Override
    public GeneratorComponent createGeneratorComponent(GeneratorComponent generatorComponent) {
        generatorComponent.setComments(generatorComponent.getComments());
        generatorComponentRepository.save(generatorComponent);
        return generatorComponent;
    }

    @Override
    public GeneratorComponent saveGeneratorComponent(GeneratorComponent generatorComponent) {
        if(generatorComponentRepository.existsById(generatorComponent.getId())) {
            throw new RuntimeException("id already exists");
        }
        generatorComponentRepository.save(generatorComponent);
        return generatorComponent;
    }

    @Override
    public GeneratorComponent findGeneratorComponentById(Long id) {
        return generatorComponentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
    }

    @Override
    public Page<GeneratorComponent> findAllGeneratorComponent(Pageable pageable) {
        return generatorComponentRepository.findAll(pageable);
    }

    @Override
    public void updateGeneratorComponentNoImage(Long id, GeneratorComponent generatorComponent) {

    }

    @Override
    public void updateGeneratorComponentNoComment(Long id, GeneratorComponent generatorComponent) {

    }

    @Override
    public void updateGeneratorComponent(Long id, GeneratorComponent generatorComponent) {

    }

    @Override
    public void deleteGeneratorComponentById(Long id) {

    }
}
