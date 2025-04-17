package be.technifutur.mechanofiliback.bll;

import be.technifutur.mechanofiliback.dl.entities.Mecha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MechaService {
    Mecha createMecha(Mecha mecha);

    Mecha saveMecha(Mecha mecha);

    Mecha findById(Long id);

    Page<Mecha> findAll(Pageable pageable);

    void update(Long id, Mecha mecha);

    void deleteById(Long id);
}
