package be.technifutur.mechanofiliback.api.models.mechaComponents.armsComponents.forms;

import be.technifutur.mechanofiliback.api.models.comments.dtos.CommentDTO;
import be.technifutur.mechanofiliback.dl.entities.Comment;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ArmsComponent;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

public record ArmsComponentDetailsForm(
        @NotBlank @Size(max = 100)
        String name,
        int weight,
        String imageUrl,
        List<Comment> comments,
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
                comments,
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
