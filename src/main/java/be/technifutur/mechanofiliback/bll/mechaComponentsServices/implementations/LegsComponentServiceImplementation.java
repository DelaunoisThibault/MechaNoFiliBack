package be.technifutur.mechanofiliback.bll.mechaComponentsServices.implementations;

import be.technifutur.mechanofiliback.bll.mechaComponentsServices.LegsComponentService;
import be.technifutur.mechanofiliback.dal.repositories.mechaComponentsRepositories.LegsComponentRepository;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.LegsComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LegsComponentServiceImplementation implements LegsComponentService {

    private final LegsComponentRepository legsComponentRepository;

    @Override
    public LegsComponent createLegsComponentNoImage(LegsComponent legsComponent) {
        legsComponentRepository.save(legsComponent);
        return legsComponent;
    }

    @Override
    public LegsComponent createLegsComponentNoComment(LegsComponent legsComponent) {
        legsComponentRepository.save(legsComponent);
        return legsComponent;
    }

    @Override
    public LegsComponent createLegsComponent(LegsComponent legsComponent) {
        legsComponent.setComments(legsComponent.getComments());
        legsComponentRepository.save(legsComponent);
        return legsComponent;
    }

    @Override
    public LegsComponent saveLegsComponent(LegsComponent legsComponent) {
        if(legsComponentRepository.existsById(legsComponent.getId())) {
            throw new RuntimeException("id already exists");
        }
        legsComponentRepository.save(legsComponent);
        return legsComponent;
    }

    @Override
    public LegsComponent findLegsComponentById(Long id) {
        return legsComponentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
    }

    @Override
    public Page<LegsComponent> findAllLegsComponent(Pageable pageable) {
        return legsComponentRepository.findAll(pageable);
    }

    @Override
    public void updateLegsComponentNoImage(Long id, LegsComponent legsComponent) {

    }

    @Override
    public void updateLegsComponentNoComment(Long id, LegsComponent legsComponent) {

    }

    @Override
    public void updateLegsComponent(Long id, LegsComponent legsComponent) {

    }

    @Override
    public void deleteLegsComponentById(Long id) {

    }
}
