package be.technifutur.mechanofiliback.api.models.mechaComponents.armsComponents.dtos;

import be.technifutur.mechanofiliback.api.models.comments.dtos.CommentDTO;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ArmsComponent;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;

import java.util.Set;
import java.util.stream.Collectors;

public record ArmsComponentDetailsDTO(
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
    public static ArmsComponentDetailsDTO fromArmsComponent(ArmsComponent armsComponent) {
        return new ArmsComponentDetailsDTO(
                armsComponent.getId(),
                armsComponent.getName(),
                armsComponent.getWeight(),
                armsComponent.getImageUrl(),
                armsComponent.getComments().stream().map(CommentDTO::fromComment).collect(Collectors.toSet()),
                armsComponent.getPowerConsumption(),
                armsComponent.getDurability(),
                armsComponent.getStrength(),
                armsComponent.getWeightCategory(),
                armsComponent.getType(),
                armsComponent.getSize()
        );
    }
}
