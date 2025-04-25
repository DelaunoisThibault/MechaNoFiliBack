package be.technifutur.mechanofiliback.dl.entities.mechacomponents;

import be.technifutur.mechanofiliback.dl.entities.Comment;
import be.technifutur.mechanofiliback.dl.enums.CockpitComfortLevel;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
@Setter
public class TorsoComponent extends MechaComponent {

    @Column(nullable = false)
    private int powerConsumption;

    @Column(nullable = false)
    private int durability;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CockpitComfortLevel cockpitComfortLevel;

    @OneToMany(cascade = CascadeType.ALL)
    @Setter
    private List<TorsoFunctionnality> functionnality;

    @Column(nullable = false)
    private int nbrPossiblePilots;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private WeightCategory weightCategory;

    @Embedded
    private ComponentSize size;

    public TorsoComponent(String name, int weight, String imageUrl, int powerConsumption, int durability, CockpitComfortLevel cockpitComfortLevel, List<TorsoFunctionnality> functionnality, int nbrPossiblePilots, String type, WeightCategory weightCategory, ComponentSize size) {
        super(name, weight, imageUrl);
        this.powerConsumption = powerConsumption;
        this.durability = durability;
        this.cockpitComfortLevel = cockpitComfortLevel;
        this.functionnality = functionnality;
        this.nbrPossiblePilots = nbrPossiblePilots;
        this.type = type;
        this.weightCategory = weightCategory;
        this.size = size;
    }

    public TorsoComponent(String name, int weight, List<Comment> comments, String imageUrl, int powerConsumption, int durability, CockpitComfortLevel cockpitComfortLevel, List<TorsoFunctionnality> functionnality, int nbrPossiblePilots, String type, WeightCategory weightCategory, ComponentSize size) {
        super(name, weight, comments, imageUrl);
        this.powerConsumption = powerConsumption;
        this.durability = durability;
        this.cockpitComfortLevel = cockpitComfortLevel;
        this.functionnality = functionnality;
        this.nbrPossiblePilots = nbrPossiblePilots;
        this.type = type;
        this.weightCategory = weightCategory;
        this.size = size;
    }
}
