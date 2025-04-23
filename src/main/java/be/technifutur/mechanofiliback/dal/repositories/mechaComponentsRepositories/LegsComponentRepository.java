package be.technifutur.mechanofiliback.dal.repositories.mechaComponentsRepositories;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.LegsComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface LegsComponentRepository extends JpaRepository<LegsComponent, Long>, JpaSpecificationExecutor<LegsComponent> {
    Optional<LegsComponent> findById(Long id);
    boolean existsById(Long id);
}
