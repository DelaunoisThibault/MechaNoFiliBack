package be.technifutur.mechanofiliback.bll.mechaComponentsServices;

import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.TorsoComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TorsoComponentService {

    TorsoComponent createTorsoComponentNoImage(TorsoComponent torsoComponent);

    TorsoComponent createTorsoComponentNoComment(TorsoComponent torsoComponent);

    TorsoComponent createTorsoComponent(TorsoComponent torsoComponent);

    TorsoComponent saveTorsoComponent(TorsoComponent torsoComponent);

    TorsoComponent findTorsoComponentById(Long id);

    Page<TorsoComponent> findAllTorsoComponent(Pageable pageable);

    void updateTorsoComponentNoImage(Long id, TorsoComponent torsoComponent);

    void updateTorsoComponentNoComment(Long id, TorsoComponent torsoComponent);

    void updateTorsoComponent(Long id, TorsoComponent torsoComponent);

    void deleteTorsoComponentById(Long id);
}
