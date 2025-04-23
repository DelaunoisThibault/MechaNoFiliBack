package be.technifutur.mechanofiliback.api.models.mechaComponents.extensionComponents.forms;

import be.technifutur.mechanofiliback.dl.entities.Comment;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ExtensionComponent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ExtensionComponentDetailsForm(
        @NotBlank @Size(max = 100)
        String name,
        int weight,
        List<Comment> comments,
        int powerConsumption
) {
    public ExtensionComponent toExtensionComponent() {
        return new ExtensionComponent(
              name,
              weight,
              comments,
              powerConsumption
        );
    }
}
