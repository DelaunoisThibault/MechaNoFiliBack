package be.technifutur.mechanofiliback.api.models.mechaComponents.legsComponents.forms;

import be.technifutur.mechanofiliback.dl.entities.Comment;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.LegsComponent;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record LegsComponentDetailsForm(
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
        public LegsComponent toLegsComponent() {
                return new LegsComponent(
                        name,
                        weight,
                        comments,
                        imageUrl,
                        powerConsumption,
                        durability,
                        strength,
                        type,
                        weightCategory,
                        size
                );
        }
}
