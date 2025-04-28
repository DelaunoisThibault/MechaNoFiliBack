package be.technifutur.mechanofiliback.bll.mechaComponentsServices;

import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.TorsoFunctionnality;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TorsoFunctionalityService {

    TorsoFunctionnality createTorsoFunctionnality(TorsoFunctionnality torsoFunctionnality);

    TorsoFunctionnality saveTorsoFunctionnality(TorsoFunctionnality torsoFunctionnality);

    TorsoFunctionnality findTorsoFunctionnalityById(Long id);

    Page<TorsoFunctionnality> findAllTorsoFunctionnality(Pageable pageable);

    void updateTorsoFunctionnality(Long id, TorsoFunctionnality torsoFunctionnality);

    void deleteTorsoFunctionnalityById(Long id);
}
