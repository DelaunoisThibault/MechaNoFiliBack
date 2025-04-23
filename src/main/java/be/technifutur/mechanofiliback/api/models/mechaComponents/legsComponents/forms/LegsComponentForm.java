package be.technifutur.mechanofiliback.api.models.mechaComponents.legsComponents.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record LegsComponentForm(
        @NotBlank @Size(max = 100)
        String name,
        int weight,
        List<String> comments,
) {
}
