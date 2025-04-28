package be.technifutur.mechanofiliback.dal.repositories.mechaComponentsRepositories;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ArmsComponent;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.MechaComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MechaComponentRepository extends JpaRepository<MechaComponent, Long>, JpaSpecificationExecutor<MechaComponent> {
    Optional<MechaComponent> findById(Long id);
    boolean existsById(Long id);
}
