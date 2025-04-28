package be.technifutur.mechanofiliback.api.models.mechaComponents.legsComponents.dtos;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.LegsComponent;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;

public record LegsComponentCreateDTO(
        Long id,
        String name,
        int weight,
        String imageUrl,
        int powerConsumption,
        int durability,
        int loadLimit,
        WeightCategory weightCategory,
        String type,
        ComponentSize size
) {
    public static LegsComponentCreateDTO fromLegsComponent(LegsComponent legsComponent) {
        return new LegsComponentCreateDTO(
                legsComponent.getId(),
                legsComponent.getName(),
                legsComponent.getWeight(),
                legsComponent.getImageUrl(),
                legsComponent.getPowerConsumption(),
                legsComponent.getDurability(),
                legsComponent.getLoadLimit(),
                legsComponent.getWeightCategory(),
                legsComponent.getType(),
                legsComponent.getSize()
        );
    }
}
