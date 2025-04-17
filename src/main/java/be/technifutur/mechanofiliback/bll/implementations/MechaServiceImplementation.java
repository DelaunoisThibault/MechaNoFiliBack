package be.technifutur.mechanofiliback.bll.implementations;

import be.technifutur.mechanofiliback.bll.MechaService;
import be.technifutur.mechanofiliback.dal.repositories.MechaComponentRepository;
import be.technifutur.mechanofiliback.dal.repositories.MechaRepository;
import be.technifutur.mechanofiliback.dl.entities.Mecha;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MechaServiceImplementation implements MechaService {

    private final MechaRepository mechaRepository;
    private final MechaComponentRepository mechaComponentRepository;

    @Override
    public Mecha createMecha(Mecha mecha) {
        mechaRepository.save(mecha);
        return mecha;
    }

    @Override
    public Mecha saveMecha(Mecha mecha) {
        if(mechaRepository.existsById(mecha.getId())) {
            throw new RuntimeException("id already exists");
        }
        mechaRepository.save(mecha);
        return mecha;
    }

    @Override
    public Mecha findById(Long id) {
        return mechaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
    }

    @Override
    public Page<Mecha> findAll(Pageable pageable) {
        return mechaRepository.findAll(pageable);
    }

    @Override
    public void update(Long id, Mecha mecha) {
        Mecha existingMecha = mechaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
        existingMecha.setMechaType(mecha.getMechaType());
        existingMecha.setName(mecha.getName());
        mechaRepository.save(existingMecha);
    }

    @Override
    public void deleteById(Long id) {
        if(!mechaRepository.existsById(id)) {
            throw new RuntimeException("id not found");
        }
        mechaRepository.deleteById(id);
    }
}
