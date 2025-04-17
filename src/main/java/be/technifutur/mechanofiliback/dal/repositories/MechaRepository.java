package be.technifutur.mechanofiliback.dal.repositories;

import be.technifutur.mechanofiliback.dl.entities.Mecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MechaRepository extends JpaRepository<Mecha, Long>, JpaSpecificationExecutor<Mecha> {
    Optional<Mecha> findById(Long id);
    boolean existsById(Long id);

}
