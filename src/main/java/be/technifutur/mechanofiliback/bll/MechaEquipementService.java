package be.technifutur.mechanofiliback.bll;

import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MechaEquipementService {

    MechaEquipment createMechaEquipementNoImage(MechaEquipment mechaEquipment);

    MechaEquipment createMechaEquipementNoComment(MechaEquipment mechaEquipment);

    MechaEquipment createMechaEquipement(MechaEquipment mechaEquipment);

    MechaEquipment saveMechaEquipement(MechaEquipment mechaEquipment);

    MechaEquipment findMechaEquipementById(Long id);

    Page<MechaEquipment> findAllMechaEquipement(Pageable pageable);

    void updateMechaEquipementNoImage(Long id, MechaEquipment mechaEquipment);

    void updateMechaEquipementNoComment(Long id, MechaEquipment mechaEquipment);

    void updateMechaEquipement(Long id, MechaEquipment mechaEquipment);

    void deleteMechaEquipementById(Long id);
}
