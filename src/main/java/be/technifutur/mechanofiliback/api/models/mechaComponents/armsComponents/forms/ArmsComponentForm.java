package be.technifutur.mechanofiliback.api.models.mechaComponents.armsComponents.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ArmsComponentForm(
        @NotBlank @Size(max = 100)
        String name,
        int weight,
) {
}
