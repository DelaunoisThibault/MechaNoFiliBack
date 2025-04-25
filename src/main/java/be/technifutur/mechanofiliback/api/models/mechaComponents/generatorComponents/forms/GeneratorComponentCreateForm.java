package be.technifutur.mechanofiliback.api.models.mechaComponents.generatorComponents.forms;

import be.technifutur.mechanofiliback.dl.entities.Comment;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.GeneratorComponent;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record GeneratorComponentCreateForm(
        @NotBlank @Size(max = 100)
        String name,
        int weight,
        String imageUrl,
        int powerCapacity,
        WeightCategory weightCategory,
        ComponentSize size
) {
    public GeneratorComponent toGeneratorComponent() {
        return new GeneratorComponent(
                name,
                weight,
                imageUrl,
                powerCapacity,
                weightCategory,
                size
        );
    }
}
