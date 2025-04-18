package be.technifutur.mechanofiliback.dl.entities.mechacomponents;

import be.technifutur.mechanofiliback.dl.enums.CockpitComfortLevel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
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

    @Embedded
    private ComponentSize size;
}
