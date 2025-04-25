package be.technifutur.mechanofiliback.api.models.mechaComponents.torsoComponents.forms;

import be.technifutur.mechanofiliback.dl.entities.Comment;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ArmsComponent;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.TorsoComponent;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.TorsoFunctionnality;
import be.technifutur.mechanofiliback.dl.enums.CockpitComfortLevel;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record TorsoComponentDetailsForm(
        @NotBlank @Size(max = 100)
        String name,
        int weight,
        String imageUrl,
        List<Comment> comments,
        int powerConsumption,
        int durability,
        CockpitComfortLevel cockpitComfortLevel,
        List<TorsoFunctionnality> functionnality,
        int nbrPossiblePilots,
        String type,
        WeightCategory weightCategory,
        ComponentSize size
) {
        public TorsoComponent toTorsoComponent() {
                return new TorsoComponent(
                        name,
                        weight,
                        comments,
                        imageUrl,
                        powerConsumption,
                        durability,
                        cockpitComfortLevel,
                        functionnality,
                        nbrPossiblePilots,
                        type,
                        weightCategory,
                        size
                );
        }
}
