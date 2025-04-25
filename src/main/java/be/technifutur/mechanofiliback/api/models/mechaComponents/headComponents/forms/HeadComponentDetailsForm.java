package be.technifutur.mechanofiliback.api.models.mechaComponents.headComponents.forms;

import be.technifutur.mechanofiliback.api.models.comments.dtos.CommentDTO;
import be.technifutur.mechanofiliback.dl.entities.Comment;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.HeadComponent;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

public record HeadComponentDetailsForm(
        @NotBlank @Size(max = 100)
        String name,
        int weight,
        String imageUrl,
        List<Comment> comments,
        int powerConsumption,
        int durability,
        String sensors,
        String fireControlSystem,
        WeightCategory weightCategory,
        ComponentSize size
) {
        public HeadComponent toHeadComponent() {
                return new HeadComponent(
                        name,
                        weight,
                        comments,
                        imageUrl,
                        powerConsumption,
                        durability,
                        sensors,
                        fireControlSystem,
                        weightCategory,
                        size
                );
        }
}
