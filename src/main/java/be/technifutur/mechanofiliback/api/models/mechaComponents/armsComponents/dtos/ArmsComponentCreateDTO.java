package be.technifutur.mechanofiliback.api.models.mechaComponents.armsComponents.dtos;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ArmsComponent;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;

public record ArmsComponentCreateDTO(
        Long id,
        String name,
        int weight,
        int powerConsumption,
        int durability,
        int strength,
        String type,
        ComponentSize size
) {
    public static ArmsComponentCreateDTO fromArmsComponent(ArmsComponent armsComponent) {
        return new ArmsComponentCreateDTO(
                armsComponent.getId(),
                armsComponent.getName(),
                armsComponent.getWeight(),
                armsComponent.getPowerConsumption(),
                armsComponent.getDurability(),
                armsComponent.getStrength(),
                armsComponent.getType(),
                armsComponent.getSize()
        );
    }
}
