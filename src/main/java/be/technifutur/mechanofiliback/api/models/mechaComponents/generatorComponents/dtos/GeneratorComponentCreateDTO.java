package be.technifutur.mechanofiliback.api.models.mechaComponents.generatorComponents.dtos;

import be.technifutur.mechanofiliback.api.models.comments.dtos.CommentDTO;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.GeneratorComponent;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;

import java.util.Set;
import java.util.stream.Collectors;

public record GeneratorComponentCreateDTO(
        Long id,
        String name,
        int weight,
        String imageUrl,
        int powerCapacity,
        WeightCategory weightCategory,
        ComponentSize size
) {
    public static GeneratorComponentCreateDTO fromGeneratorComponent(GeneratorComponent generatorComponent) {
        return new GeneratorComponentCreateDTO(
                generatorComponent.getId(),
                generatorComponent.getName(),
                generatorComponent.getWeight(),
                generatorComponent.getImageUrl(),
                generatorComponent.getPowerCapacity(),
                generatorComponent.getWeightCategory(),
                generatorComponent.getSize()
        );
    }
}
