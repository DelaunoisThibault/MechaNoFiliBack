package be.technifutur.mechanofiliback.dal.repositories.mechaComponentsRepositories;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ExtensionComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ExtensionComponentRepository extends JpaRepository<ExtensionComponent, Long>, JpaSpecificationExecutor<ExtensionComponent> {
    Optional<ExtensionComponent> findById(Long id);
    boolean existsById(Long id);
}
