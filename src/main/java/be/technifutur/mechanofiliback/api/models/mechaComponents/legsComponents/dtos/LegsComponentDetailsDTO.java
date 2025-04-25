package be.technifutur.mechanofiliback.api.models.mechaComponents.legsComponents.dtos;

import be.technifutur.mechanofiliback.api.models.comments.dtos.CommentDTO;
import be.technifutur.mechanofiliback.api.models.mechaComponents.armsComponents.dtos.ArmsComponentDetailsDTO;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ArmsComponent;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.LegsComponent;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;

import java.util.Set;
import java.util.stream.Collectors;

public record LegsComponentDetailsDTO(
        Long id,
        String name,
        int weight,
        String imageUrl,
        Set<CommentDTO> comments,
        int powerConsumption,
        int durability,
        int strength,
        WeightCategory weightCategory,
        String type,
        ComponentSize size
) {

    public static LegsComponentDetailsDTO fromLegsComponent(LegsComponent legsComponent) {
        return new LegsComponentDetailsDTO(
                legsComponent.getId(),
                legsComponent.getName(),
                legsComponent.getWeight(),
                legsComponent.getImageUrl(),
                legsComponent.getComments().stream().map(CommentDTO::fromComment).collect(Collectors.toSet()),
                legsComponent.getPowerConsumption(),
                legsComponent.getDurability(),
                legsComponent.getStrength(),
                legsComponent.getWeightCategory(),
                legsComponent.getType(),
                legsComponent.getSize()
        );
    }
}
