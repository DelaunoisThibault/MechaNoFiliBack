package be.technifutur.mechanofiliback.api.models.mechaComponents.generatorComponents.forms;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.GeneratorComponent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record GeneratorComponentForm(
        @NotBlank @Size(max = 100)
        String name,
        int weight,
        List<String> comments,
        int powerCapacity,
        ComponentSize size
) {
    public GeneratorComponent toGeneratorComponent() {
        return new GeneratorComponent(
                name,
                weight,
                powerCapacity,
                size
        );
    }
}
