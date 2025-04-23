package be.technifutur.mechanofiliback.api.models.mechaComponents.generatorComponents.dtos;

import be.technifutur.mechanofiliback.api.models.comments.dtos.CommentDTO;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.GeneratorComponent;

import java.util.Set;
import java.util.stream.Collectors;

public record GeneratorComponentDTO(
        Long id,
        String name,
        int weight,
        Set<CommentDTO> comments,
        int powerCapacity,
        ComponentSize size
) {
    public static GeneratorComponentDTO fromGeneratorComponent(GeneratorComponent generatorComponent) {
        return new GeneratorComponentDTO(
                generatorComponent.getId(),
                generatorComponent.getName(),
                generatorComponent.getWeight(),
                generatorComponent.getComments().stream().map(CommentDTO::fromComment).collect(Collectors.toSet()),
                generatorComponent.getPowerCapacity(),
                generatorComponent.getSize()
        );
    }
}
