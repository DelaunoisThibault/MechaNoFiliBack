package be.technifutur.mechanofiliback.bll.mechaComponentsServices.implementations;

import be.technifutur.mechanofiliback.bll.mechaComponentsServices.TorsoFunctionalityService;
import be.technifutur.mechanofiliback.dal.repositories.mechaComponentsRepositories.TorsoFunctionalityRepository;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ExtensionComponent;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.TorsoFunctionnality;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TorsoFunctionalityServiceImplementation implements TorsoFunctionalityService {

    private final TorsoFunctionalityRepository torsoFunctionalityRepository;

    @Override
    public TorsoFunctionnality createTorsoFunctionnality(TorsoFunctionnality torsoFunctionnality) {
        torsoFunctionalityRepository.save(torsoFunctionnality);
        return torsoFunctionnality;
    }

    @Override
    public TorsoFunctionnality saveTorsoFunctionnality(TorsoFunctionnality torsoFunctionnality) {
        if(torsoFunctionalityRepository.existsById(torsoFunctionnality.getId())) {
            throw new RuntimeException("id already exists");
        }
        torsoFunctionalityRepository.save(torsoFunctionnality);
        return torsoFunctionnality;
    }

    @Override
    public TorsoFunctionnality findTorsoFunctionnalityById(Long id) {
        return torsoFunctionalityRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
    }

    @Override
    public Page<TorsoFunctionnality> findAllTorsoFunctionnality(Pageable pageable) {
        return torsoFunctionalityRepository.findAll(pageable);
    }

    @Override
    public void updateTorsoFunctionnality(Long id, TorsoFunctionnality torsoFunctionnality) {
        TorsoFunctionnality existingTorsoFunctionality = torsoFunctionalityRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
        existingTorsoFunctionality.setName(torsoFunctionnality.getName());
    }

    @Override
    public void deleteTorsoFunctionnalityById(Long id) {
        if(!torsoFunctionalityRepository.existsById(id)) {
            throw new RuntimeException("id not found");
        }
        torsoFunctionalityRepository.deleteById(id);

    }
}
