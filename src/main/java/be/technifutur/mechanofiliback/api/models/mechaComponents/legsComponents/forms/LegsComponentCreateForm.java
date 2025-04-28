package be.technifutur.mechanofiliback.api.models.mechaComponents.legsComponents.forms;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.LegsComponent;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LegsComponentCreateForm(
        @NotBlank @Size(max = 100)
        String name,
        int weight,
        String imageUrl,
        int powerConsumption,
        int durability,
        int loadLimit,
        WeightCategory weightCategory,
        String type,
        ComponentSize size
) {
    public LegsComponent toLegsComponent() {
        return new LegsComponent(
                name,
                weight,
                imageUrl,
                powerConsumption,
                durability,
                loadLimit,
                type,
                weightCategory,
                size
        );
    }

}
