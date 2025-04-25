package be.technifutur.mechanofiliback.api.models.mechaEquipements.dtos;

import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import be.technifutur.mechanofiliback.dl.enums.EquipmentType;

public record MechaEquipementCreateDTO(
        Long id,
        String name,
        int weight,
        EquipmentType equipmentType,
        int powerConsumption,
        int durability
) {
    public static MechaEquipementCreateDTO fromMechaEquipement(MechaEquipment mechaEquipment) {
        return new MechaEquipementCreateDTO(
                mechaEquipment.getId(),
                mechaEquipment.getName(),
                mechaEquipment.getWeight(),
                mechaEquipment.getEquipmentType(),
                mechaEquipment.getPowerConsumption(),
                mechaEquipment.getDurability()
        );
    }
}
