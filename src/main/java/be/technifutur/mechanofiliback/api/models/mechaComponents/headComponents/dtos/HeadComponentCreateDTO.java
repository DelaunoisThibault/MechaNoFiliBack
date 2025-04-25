package be.technifutur.mechanofiliback.api.models.mechaComponents.headComponents.dtos;

import be.technifutur.mechanofiliback.api.models.comments.dtos.CommentDTO;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.HeadComponent;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;

import java.util.Set;
import java.util.stream.Collectors;

public record HeadComponentCreateDTO(
        Long id,
        String name,
        int weight,
        String imageUrl,
        int powerConsumption,
        int durability,
        String sensors,
        String fireControlSystem,
        WeightCategory weightCategory,
        ComponentSize size
) {
    public static HeadComponentCreateDTO fromHeadComponent(HeadComponent headComponent) {
        return new HeadComponentCreateDTO(
                headComponent.getId(),
                headComponent.getName(),
                headComponent.getWeight(),
                headComponent.getImageUrl(),
                headComponent.getPowerConsumption(),
                headComponent.getDurability(),
                headComponent.getSensors(),
                headComponent.getFireControlSystem(),
                headComponent.getWeightCategory(),
                headComponent.getSize()
        );
    }
}
