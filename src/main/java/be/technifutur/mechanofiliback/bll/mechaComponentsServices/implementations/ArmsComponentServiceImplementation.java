package be.technifutur.mechanofiliback.bll.mechaComponentsServices.implementations;

import be.technifutur.mechanofiliback.bll.mechaComponentsServices.ArmsComponentService;
import be.technifutur.mechanofiliback.dal.repositories.mechaComponentsRepositories.ArmsComponentRepository;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ArmsComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArmsComponentServiceImplementation implements ArmsComponentService {

    private final ArmsComponentRepository armsComponentRepository;

    @Override
    public ArmsComponent createArmsComponentNoImage(ArmsComponent armsComponent) {
        armsComponentRepository.save(armsComponent);
        return armsComponent;
    }

    @Override
    public ArmsComponent createArmsComponentNoComment(ArmsComponent armsComponent) {
        armsComponentRepository.save(armsComponent);
        return armsComponent;
    }

    @Override
    public ArmsComponent createArmsComponent(ArmsComponent armsComponent) {
        armsComponent.setComments(armsComponent.getComments());
        armsComponentRepository.save(armsComponent);
        return armsComponent;
    }

    @Override
    public ArmsComponent saveArmsComponent(ArmsComponent armsComponent) {
        if(armsComponentRepository.existsById(armsComponent.getId())) {
            throw new RuntimeException("id already exists");
        }
        armsComponentRepository.save(armsComponent);
        return armsComponent;
    }

    @Override
    public ArmsComponent findArmsComponentById(Long id) {
        return armsComponentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
    }

    @Override
    public Page<ArmsComponent> findAllArmsComponent(Pageable pageable) {
        return armsComponentRepository.findAll(pageable);
    }

    @Override
    public void updateArmsComponentNoImage(Long id, ArmsComponent armsComponent) {
        ArmsComponent existingArmsComponent = armsComponentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
        existingArmsComponent.setName(armsComponent.getName());
        existingArmsComponent.setWeight(armsComponent.getWeight());
        existingArmsComponent.setPowerConsumption(armsComponent.getPowerConsumption());
        existingArmsComponent.setDurability(armsComponent.getDurability());
        existingArmsComponent.setStrength(armsComponent.getStrength());
        existingArmsComponent.setWeightCategory(armsComponent.getWeightCategory());
        existingArmsComponent.setType(armsComponent.getType());
        existingArmsComponent.setSize(armsComponent.getSize());
    }

    @Override
    public void updateArmsComponentNoComment(Long id, ArmsComponent armsComponent) {
        ArmsComponent existingArmsComponent = armsComponentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
        existingArmsComponent.setName(armsComponent.getName());
        existingArmsComponent.setWeight(armsComponent.getWeight());
        existingArmsComponent.setImageUrl(armsComponent.getImageUrl());
        existingArmsComponent.setPowerConsumption(armsComponent.getPowerConsumption());
        existingArmsComponent.setDurability(armsComponent.getDurability());
        existingArmsComponent.setStrength(armsComponent.getStrength());
        existingArmsComponent.setWeightCategory(armsComponent.getWeightCategory());
        existingArmsComponent.setType(armsComponent.getType());
        existingArmsComponent.setSize(armsComponent.getSize());
    }

    @Override
    public void updateArmsComponent(Long id, ArmsComponent armsComponent) {
        ArmsComponent existingArmsComponent = armsComponentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
        existingArmsComponent.setName(armsComponent.getName());
        existingArmsComponent.setWeight(armsComponent.getWeight());
        existingArmsComponent.setComments(armsComponent.getComments());
        existingArmsComponent.setImageUrl(armsComponent.getImageUrl());
        existingArmsComponent.setPowerConsumption(armsComponent.getPowerConsumption());
        existingArmsComponent.setDurability(armsComponent.getDurability());
        existingArmsComponent.setStrength(armsComponent.getStrength());
        existingArmsComponent.setWeightCategory(armsComponent.getWeightCategory());
        existingArmsComponent.setType(armsComponent.getType());
        existingArmsComponent.setSize(armsComponent.getSize());
    }

    @Override
    public void deleteArmsComponentById(Long id) {
        if(!armsComponentRepository.existsById(id)) {
            throw new RuntimeException("id not found");
        }
        armsComponentRepository.deleteById(id);
    }
}
