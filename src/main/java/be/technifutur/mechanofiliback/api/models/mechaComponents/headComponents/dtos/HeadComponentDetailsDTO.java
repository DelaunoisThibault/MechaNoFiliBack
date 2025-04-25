package be.technifutur.mechanofiliback.api.models.mechaComponents.headComponents.dtos;

import be.technifutur.mechanofiliback.api.models.comments.dtos.CommentDTO;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.HeadComponent;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;

import java.util.Set;
import java.util.stream.Collectors;

public record HeadComponentDetailsDTO(
        Long id,
        String name,
        int weight,
        String imageUrl,
        Set<CommentDTO> comments,
        int powerConsumption,
        int durability,
        String sensors,
        String fireControlSystem,
        WeightCategory weightCategory,
        ComponentSize size
) {
    public static HeadComponentDetailsDTO fromHeadComponent(HeadComponent headComponent) {
        return new HeadComponentDetailsDTO(
                headComponent.getId(),
                headComponent.getName(),
                headComponent.getWeight(),
                headComponent.getImageUrl(),
                headComponent.getComments().stream().map(CommentDTO::fromComment).collect(Collectors.toSet()),
                headComponent.getPowerConsumption(),
                headComponent.getDurability(),
                headComponent.getSensors(),
                headComponent.getFireControlSystem(),
                headComponent.getWeightCategory(),
                headComponent.getSize()
        );
    }
}
