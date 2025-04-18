package be.technifutur.mechanofiliback.dal.repositories;

import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MechaEquipmentRepository extends JpaRepository<MechaEquipment, Long>, JpaSpecificationExecutor<MechaEquipment> {

    Optional<MechaEquipment> findById(Long id);
    boolean existsById(Long id);
}
