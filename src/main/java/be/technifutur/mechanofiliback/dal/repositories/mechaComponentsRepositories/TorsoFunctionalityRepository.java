package be.technifutur.mechanofiliback.dal.repositories.mechaComponentsRepositories;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.TorsoFunctionnality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface TorsoFunctionalityRepository extends JpaRepository<TorsoFunctionnality, Long>, JpaSpecificationExecutor<TorsoFunctionnality> {
    Optional<TorsoFunctionnality> findById(Long id);
    boolean existsById(Long id);
}
