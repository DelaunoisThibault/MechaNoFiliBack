package be.technifutur.mechanofiliback.dal.repositories.mechaComponentsRepositories;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ArmsComponent;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.GeneratorComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface GeneratorComponentRepository extends JpaRepository<GeneratorComponent, Long>, JpaSpecificationExecutor<GeneratorComponent> {
    Optional<GeneratorComponent> findById(Long id);
    boolean existsById(Long id);
}
