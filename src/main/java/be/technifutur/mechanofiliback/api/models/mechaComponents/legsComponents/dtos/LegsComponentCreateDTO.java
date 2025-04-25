package be.technifutur.mechanofiliback.api.models.mechaComponents.legsComponents.dtos;

import be.technifutur.mechanofiliback.api.models.comments.dtos.CommentDTO;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.LegsComponent;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;

import java.util.Set;
import java.util.stream.Collectors;

public record LegsComponentCreateDTO(
        Long id,
        String name,
        int weight,
        String imageUrl,
        int powerConsumption,
        int durability,
        int strength,
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
                legsComponent.getStrength(),
                legsComponent.getWeightCategory(),
                legsComponent.getType(),
                legsComponent.getSize()
        );
    }
}
