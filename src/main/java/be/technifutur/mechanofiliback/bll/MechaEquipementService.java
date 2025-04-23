package be.technifutur.mechanofiliback.bll;

import be.technifutur.mechanofiliback.dl.entities.Mecha;
import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MechaEquipementService {

    MechaEquipment createMechaEquipement(MechaEquipment mechaEquipment);

    MechaEquipment saveMechaEquipement(MechaEquipment mechaEquipment);

    MechaEquipment findById(Long id);

    Page<MechaEquipment> findAll(Pageable pageable);

    void update(Long id, MechaEquipment mechaEquipment);

    void deleteById(Long id);
}
