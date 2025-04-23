package be.technifutur.mechanofiliback.dal.repositories.mechaComponentsRepositories;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ArmsComponent;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.TorsoComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface TorsoComponentRepository extends JpaRepository<TorsoComponent, Long>, JpaSpecificationExecutor<TorsoComponent> {
    Optional<TorsoComponent> findById(Long id);
    boolean existsById(Long id);
}
