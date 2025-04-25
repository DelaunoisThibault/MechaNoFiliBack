package be.technifutur.mechanofiliback.api.models.mechaComponents.armsComponents.forms;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ArmsComponent;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ArmsComponentCreateForm(
        @NotBlank @Size(max = 100)
        String name,
        int weight,
        String imageUrl,
        int powerConsumption,
        int durability,
        int strength,
        WeightCategory weightCategory,
        String type,
        ComponentSize size
) {
        public ArmsComponent toArmsComponent() {
                return new ArmsComponent(
                        name,
                        weight,
                        imageUrl,
                        powerConsumption,
                        durability,
                        strength,
                        weightCategory,
                        type,
                        size
                );
        }
}
