package be.technifutur.mechanofiliback.bll.mechaComponentsServices;

import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ArmsComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArmsComponentService {
    ArmsComponent createArmsComponentNoImage(ArmsComponent armsComponent);

    ArmsComponent createArmsComponentNoComment(ArmsComponent armsComponent);

    ArmsComponent createArmsComponent(ArmsComponent armsComponent);

    ArmsComponent saveArmsComponent(ArmsComponent armsComponent);

    ArmsComponent findArmsComponentById(Long id);

    Page<ArmsComponent> findAllArmsComponent(Pageable pageable);

    void updateArmsComponentNoImage(Long id, ArmsComponent armsComponent);

    void updateArmsComponentNoComment(Long id, ArmsComponent armsComponent);

    void updateArmsComponent(Long id, ArmsComponent armsComponent);

    void deleteArmsComponentById(Long id);
}
