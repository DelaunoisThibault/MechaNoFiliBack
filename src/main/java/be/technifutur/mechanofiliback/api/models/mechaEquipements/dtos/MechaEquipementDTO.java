package be.technifutur.mechanofiliback.api.models.mechaEquipements.dtos;

import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import be.technifutur.mechanofiliback.dl.enums.EquipmentType;

public record MechaEquipementDTO(
        Long id,
        String name,
        int weight,
        EquipmentType equipmentType,
        int powerConsumption,
        int durability
) {
    public static MechaEquipementDTO fromMechaEquipement(MechaEquipment mechaEquipment) {
        return new MechaEquipementDTO(
                mechaEquipment.getId(),
                mechaEquipment.getName(),
                mechaEquipment.getWeight(),
                mechaEquipment.getEquipmentType(),
                mechaEquipment.getPowerConsumption(),
                mechaEquipment.getDurability()
        );
    }
}
