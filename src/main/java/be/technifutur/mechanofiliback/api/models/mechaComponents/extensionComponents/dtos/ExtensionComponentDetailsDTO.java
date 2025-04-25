package be.technifutur.mechanofiliback.api.models.mechaComponents.extensionComponents.dtos;

import be.technifutur.mechanofiliback.api.models.comments.dtos.CommentDTO;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ExtensionComponent;

import java.util.Set;
import java.util.stream.Collectors;

public record ExtensionComponentDetailsDTO(
        Long id,
        String name,
        int weight,
        String imageUrl,
        Set<CommentDTO> comments,
        int powerConsumption
) {
    public static ExtensionComponentDetailsDTO fromExtensionComponent(ExtensionComponent extensionComponent) {
        return new ExtensionComponentDetailsDTO(
                extensionComponent.getId(),
                extensionComponent.getName(),
                extensionComponent.getWeight(),
                extensionComponent.getImageUrl(),
                extensionComponent.getComments().stream().map(CommentDTO::fromComment).collect(Collectors.toSet()),
                extensionComponent.getPowerConsumption()
        );
    }
}
