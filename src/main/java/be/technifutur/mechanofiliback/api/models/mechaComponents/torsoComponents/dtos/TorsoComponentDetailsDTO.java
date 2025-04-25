package be.technifutur.mechanofiliback.api.models.mechaComponents.torsoComponents.dtos;

import be.technifutur.mechanofiliback.api.models.comments.dtos.CommentDTO;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.TorsoComponent;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.TorsoFunctionnality;
import be.technifutur.mechanofiliback.dl.enums.CockpitComfortLevel;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record TorsoComponentDetailsDTO(
        Long id,
        String name,
        int weight,
        String imageUrl,
        Set<CommentDTO> comments,
        int powerConsumption,
        int durability,
        CockpitComfortLevel cockpitComfortLevel,
        List<TorsoFunctionnality> functionnality,
        int nbrPossiblePilots,
        String type,
        WeightCategory weightCategory,
        ComponentSize size
) {
    public static TorsoComponentDetailsDTO fromTorsoComponent(TorsoComponent torsoComponent) {
        return new TorsoComponentDetailsDTO(
                torsoComponent.getId(),
                torsoComponent.getName(),
                torsoComponent.getWeight(),
                torsoComponent.getImageUrl(),
                torsoComponent.getComments().stream().map(CommentDTO::fromComment).collect(Collectors.toSet()),
                torsoComponent.getPowerConsumption(),
                torsoComponent.getDurability(),
                torsoComponent.getCockpitComfortLevel(),
                torsoComponent.getFunctionnality(),
                torsoComponent.getNbrPossiblePilots(),
                torsoComponent.getType(),
                torsoComponent.getWeightCategory(),
                torsoComponent.getSize()
        );
    }
}
