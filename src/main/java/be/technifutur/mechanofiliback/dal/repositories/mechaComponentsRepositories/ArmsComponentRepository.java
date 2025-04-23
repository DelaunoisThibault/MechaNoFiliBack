package be.technifutur.mechanofiliback.dal.repositories.mechaComponentsRepositories;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ArmsComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ArmsComponentRepository extends JpaRepository<ArmsComponent, Long>, JpaSpecificationExecutor<ArmsComponent> {
    Optional<ArmsComponent> findById(Long id);
    boolean existsById(Long id);
}
