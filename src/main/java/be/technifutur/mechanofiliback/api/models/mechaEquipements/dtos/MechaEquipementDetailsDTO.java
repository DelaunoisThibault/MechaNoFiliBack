package be.technifutur.mechanofiliback.api.models.mechaEquipements.dtos;

import be.technifutur.mechanofiliback.api.models.comments.dtos.CommentDTO;
import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import be.technifutur.mechanofiliback.dl.enums.EquipmentType;

import java.util.Set;
import java.util.stream.Collectors;

public record MechaEquipementDetailsDTO(
        Long id,
        String name,
        String imageUrl,
        int weight,
        EquipmentType equipmentType,
        int powerConsumption,
        int durability,
        Set<CommentDTO> comments
) {
    public static MechaEquipementDetailsDTO fromMechaEquipement(MechaEquipment mechaEquipment) {
        return new MechaEquipementDetailsDTO(
                mechaEquipment.getId(),
                mechaEquipment.getName(),
                mechaEquipment.getImageUrl(),
                mechaEquipment.getWeight(),
                mechaEquipment.getEquipmentType(),
                mechaEquipment.getPowerConsumption(),
                mechaEquipment.getDurability(),
                mechaEquipment.getComments().stream().map(CommentDTO::fromComment).collect(Collectors.toSet())
        );
    }
}
