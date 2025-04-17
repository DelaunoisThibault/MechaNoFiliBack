package be.technifutur.mechanofiliback.bll;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.MechaComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MechaComponentService {

    MechaComponent saveMechaComponent(MechaComponent mechaComponent);

    MechaComponent createMechaComponent(MechaComponent mechaComponent);

    MechaComponent findMechaComponentById(Long id);

    Page<MechaComponent> findAll(Pageable pageable);

    void update(Long id, MechaComponent mechaComponent);

    void deleteById(Long id);
}
