package be.technifutur.mechanofiliback.bll.mechaComponentsServices.implementations;

import be.technifutur.mechanofiliback.bll.mechaComponentsServices.HeadComponentService;
import be.technifutur.mechanofiliback.dal.repositories.mechaComponentsRepositories.HeadComponentRepository;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.HeadComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeadComponentServiceImplementation implements HeadComponentService {

    private final HeadComponentRepository headComponentRepository;

    @Override
    public HeadComponent createHeadComponentNoImage(HeadComponent headComponent) {
        headComponentRepository.save(headComponent);
        return headComponent;
    }

    @Override
    public HeadComponent createHeadComponentNoComment(HeadComponent headComponent) {
        headComponentRepository.save(headComponent);
        return headComponent;
    }

    @Override
    public HeadComponent createHeadComponent(HeadComponent headComponent) {
        headComponent.setComments(headComponent.getComments());
        headComponentRepository.save(headComponent);
        return headComponent;
    }

    @Override
    public HeadComponent saveHeadComponent(HeadComponent headComponent) {
        if(headComponentRepository.existsById(headComponent.getId())) {
            throw new RuntimeException("id already exists");
        }
        headComponentRepository.save(headComponent);
        return headComponent;
    }

    @Override
    public HeadComponent findHeadComponentById(Long id) {
        return headComponentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
    }

    @Override
    public Page<HeadComponent> findAllHeadComponent(Pageable pageable) {
        return headComponentRepository.findAll(pageable);
    }

    @Override
    public void updateHeadComponentNoImage(Long id, HeadComponent headComponent) {

    }

    @Override
    public void updateHeadComponentNoComment(Long id, HeadComponent headComponent) {

    }

    @Override
    public void updateHeadComponent(Long id, HeadComponent headComponent) {

    }

    @Override
    public void deleteHeadComponentById(Long id) {

    }
}
