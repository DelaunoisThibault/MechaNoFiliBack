package be.technifutur.mechanofiliback.dal.repositories;

import be.technifutur.mechanofiliback.dl.entities.Mecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MechaRepository extends JpaRepository<Mecha, Long>, JpaSpecificationExecutor<Mecha> {
    Optional<Mecha> findById(Long id);
    boolean existsById(Long id);
    @Query("SELECT m FROM Mecha m WHERE m.user.id = :id")
    Optional<List<Mecha>>  findAllByUser(Long id);
    @Query("SELECT m FROM Mecha m WHERE m.user.id = :userId AND m.id = :mechaId")
    Optional<Mecha>  findSpecificMechaByUser(Long mechaId, Long userId);

}
