package be.technifutur.mechanofiliback.bll.mechaComponentsServices;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.GeneratorComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GeneratorComponentService {
    GeneratorComponent createGeneratorComponentNoImage(GeneratorComponent generatorComponent);

    GeneratorComponent createGeneratorComponentNoComment(GeneratorComponent generatorComponent);

    GeneratorComponent createGeneratorComponent(GeneratorComponent generatorComponent);

    GeneratorComponent saveGeneratorComponent(GeneratorComponent generatorComponent);

    GeneratorComponent findGeneratorComponentById(Long id);

    Page<GeneratorComponent> findAllGeneratorComponent(Pageable pageable);

    void updateGeneratorComponentNoImage(Long id, GeneratorComponent generatorComponent);

    void updateGeneratorComponentNoComment(Long id, GeneratorComponent generatorComponent);

    void updateGeneratorComponent(Long id, GeneratorComponent generatorComponent);

    void deleteGeneratorComponentById(Long id);
}
