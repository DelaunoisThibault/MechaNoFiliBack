package be.technifutur.mechanofiliback.bll.mechaComponentsServices;

import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.LegsComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LegsComponentService {

    LegsComponent createLegsComponentNoImage(LegsComponent legsComponent);

    LegsComponent createLegsComponentNoComment(LegsComponent legsComponent);

    LegsComponent createLegsComponent(LegsComponent legsComponent);

    LegsComponent saveLegsComponent(LegsComponent legsComponent);

    LegsComponent findLegsComponentById(Long id);

    Page<LegsComponent> findAllLegsComponent(Pageable pageable);

    void updateLegsComponentNoImage(Long id, LegsComponent legsComponent);

    void updateLegsComponentNoComment(Long id, LegsComponent legsComponent);

    void updateLegsComponent(Long id, LegsComponent legsComponent);

    void deleteLegsComponentById(Long id);
}
