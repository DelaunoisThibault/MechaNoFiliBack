package be.technifutur.mechanofiliback.api.models.mechaComponents.extensionComponents.dtos;

import be.technifutur.mechanofiliback.api.models.comments.dtos.CommentDTO;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ExtensionComponent;

import java.util.Set;
import java.util.stream.Collectors;

public record ExtensionComponentCreateDTO(
        Long id,
        String name,
        int weight,
        String imageUrl,
        int powerConsumption
) {
    public static ExtensionComponentCreateDTO fromExtensionComponent(ExtensionComponent extensionComponent) {
        return new ExtensionComponentCreateDTO(
                extensionComponent.getId(),
                extensionComponent.getName(),
                extensionComponent.getWeight(),
                extensionComponent.getImageUrl(),
                extensionComponent.getPowerConsumption()
        );
    }
}
