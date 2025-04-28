package be.technifutur.mechanofiliback.api.models.mechaEquipements.forms;

import be.technifutur.mechanofiliback.dl.entities.Comment;
import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import be.technifutur.mechanofiliback.dl.enums.EquipmentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record MechaEquipementDetailsForm(
        @NotBlank @Size(max = 100)
        String name,
        String imageUrl,
        int weight,
        EquipmentType equipmentType,
        int powerConsumption,
        int durability,
        List<Comment> comments
) {
    public MechaEquipment toMechaEquipment() {
        return new MechaEquipment(
                name,
                imageUrl,
                weight,
                equipmentType,
                powerConsumption,
                durability,
                comments
        );
    }
}
