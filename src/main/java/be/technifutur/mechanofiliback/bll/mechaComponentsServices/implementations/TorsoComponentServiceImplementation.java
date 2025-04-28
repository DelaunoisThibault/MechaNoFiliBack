package be.technifutur.mechanofiliback.bll.mechaComponentsServices.implementations;

import be.technifutur.mechanofiliback.bll.mechaComponentsServices.TorsoComponentService;
import be.technifutur.mechanofiliback.dal.repositories.mechaComponentsRepositories.TorsoComponentRepository;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.TorsoComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TorsoComponentServiceImplementation implements TorsoComponentService {

    private final TorsoComponentRepository torsoComponentRepository;

    @Override
    public TorsoComponent createTorsoComponentNoImage(TorsoComponent torsoComponent) {
        torsoComponentRepository.save(torsoComponent);
        return torsoComponent;
    }

    @Override
    public TorsoComponent createTorsoComponentNoComment(TorsoComponent torsoComponent) {
        return null;
    }

    @Override
    public TorsoComponent createTorsoComponent(TorsoComponent torsoComponent) {
        torsoComponent.setComments(torsoComponent.getComments());
        torsoComponentRepository.save(torsoComponent);
        return torsoComponent;
    }

    @Override
    public TorsoComponent saveTorsoComponent(TorsoComponent torsoComponent) {
        if(torsoComponentRepository.existsById(torsoComponent.getId())) {
            throw new RuntimeException("id already exists");
        }
        torsoComponentRepository.save(torsoComponent);
        return torsoComponent;
    }

    @Override
    public TorsoComponent findTorsoComponentById(Long id) {
        return torsoComponentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
    }

    @Override
    public Page<TorsoComponent> findAllTorsoComponent(Pageable pageable) {
        return torsoComponentRepository.findAll(pageable);
    }

    @Override
    public void updateTorsoComponentNoImage(Long id, TorsoComponent torsoComponent) {

    }

    @Override
    public void updateTorsoComponentNoComment(Long id, TorsoComponent torsoComponent) {

    }

    @Override
    public void updateTorsoComponent(Long id, TorsoComponent torsoComponent) {

    }

    @Override
    public void deleteTorsoComponentById(Long id) {

    }
}
