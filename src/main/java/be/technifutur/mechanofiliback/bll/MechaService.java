package be.technifutur.mechanofiliback.bll;

import be.technifutur.mechanofiliback.dl.entities.Mecha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MechaService {

    Mecha createEmptyMecha(Mecha mecha);

    Mecha createBaseMecha(Mecha mecha);

    Mecha createMecha(Mecha mecha);

    Mecha saveMecha(Mecha mecha);

    Mecha findMechaById(Long id);

    List<Mecha> getMechasByUser(Long id);

    Mecha getSingleMechaByUser( Long mechaId, Long userId);

    Page<Mecha> findAll(Pageable pageable);

    void updateEmptyMecha(Long id, Mecha mecha);

    void updateBaseMecha(Long id, Mecha mecha);

    void updateMecha(Long id, Mecha mecha);

    void deleteMechaById(Long id);
}
