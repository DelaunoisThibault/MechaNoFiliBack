package be.technifutur.mechanofiliback.bll.implementations;

import be.technifutur.mechanofiliback.bll.MechaEquipementService;
import be.technifutur.mechanofiliback.dal.repositories.MechaEquipmentRepository;
import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MechaEquipementServiceImplementation implements MechaEquipementService {

    private final MechaEquipmentRepository mechaEquipmentRepository;

    @Override
    public MechaEquipment createMechaEquipement(MechaEquipment mechaEquipment) {
        mechaEquipment.setName(mechaEquipment.getName());
        mechaEquipment.setEquipmentType(mechaEquipment.getEquipmentType());
        mechaEquipment.setDurability(mechaEquipment.getDurability());
        mechaEquipment.setWeight(mechaEquipment.getWeight());
        mechaEquipment.setPowerConsumption(mechaEquipment.getPowerConsumption());
        mechaEquipmentRepository.save(mechaEquipment);
        return mechaEquipment;
    }

    @Override
    public MechaEquipment saveMechaEquipement(MechaEquipment mechaEquipment) {
        if(mechaEquipmentRepository.existsById(mechaEquipment.getId())) {
            throw new RuntimeException("id already exists");
        }
        mechaEquipmentRepository.save(mechaEquipment);
        return mechaEquipment;
    }

    @Override
    public MechaEquipment findById(Long id) {
        return mechaEquipmentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
    }

    @Override
    public Page<MechaEquipment> findAll(Pageable pageable) {
        return mechaEquipmentRepository.findAll(pageable);
    }

    @Override
    public void update(Long id, MechaEquipment mechaEquipment) {
        MechaEquipment existingMechaEquipement = mechaEquipmentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
        existingMechaEquipement.setName(mechaEquipment.getName());
        existingMechaEquipement.setEquipmentType(mechaEquipment.getEquipmentType());
        existingMechaEquipement.setDurability(mechaEquipment.getDurability());
        existingMechaEquipement.setWeight(mechaEquipment.getWeight());
        existingMechaEquipement.setPowerConsumption(mechaEquipment.getPowerConsumption());
        mechaEquipmentRepository.save(existingMechaEquipement);
    }

    @Override
    public void deleteById(Long id) {
        if(!mechaEquipmentRepository.existsById(id)) {
            throw new RuntimeException("id not found");
        }
        mechaEquipmentRepository.deleteById(id);

    }
}
