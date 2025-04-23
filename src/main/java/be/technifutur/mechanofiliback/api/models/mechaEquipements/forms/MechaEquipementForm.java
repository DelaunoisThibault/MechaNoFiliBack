package be.technifutur.mechanofiliback.api.models.mechaEquipements.forms;

import be.technifutur.mechanofiliback.dl.entities.Mecha;
import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import be.technifutur.mechanofiliback.dl.enums.EquipmentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MechaEquipementForm (
        @NotBlank @Size(max = 100)
        String name,
        int weight,
        EquipmentType equipmentType,
        int powerConsumption,
        int durability
) {
    public MechaEquipment toMechaEquipment() {
        return new MechaEquipment(
                name,
                weight,
                equipmentType,
                powerConsumption,
                durability
        );
    }
}
