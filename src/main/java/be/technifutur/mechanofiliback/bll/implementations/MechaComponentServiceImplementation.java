package be.technifutur.mechanofiliback.bll.implementations;

import be.technifutur.mechanofiliback.bll.MechaComponentService;
import be.technifutur.mechanofiliback.dal.repositories.MechaComponentRepository;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.MechaComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MechaComponentServiceImplementation implements MechaComponentService {

    private final MechaComponentRepository mechaComponentRepository;

    @Override
    public MechaComponent saveMechaComponent(MechaComponent mechaComponent) {
        return null;
    }

    @Override
    public MechaComponent createMechaComponent(MechaComponent mechaComponent) {
        return null;
    }

    @Override
    public MechaComponent findMechaComponentById(Long id) {
        return null;
    }

    @Override
    public Page<MechaComponent> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void update(Long id, MechaComponent mechaComponent) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
