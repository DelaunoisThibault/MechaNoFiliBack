package be.technifutur.mechanofiliback.dl.entities.mechacomponents;

import be.technifutur.mechanofiliback.dl.entities.Comment;
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
public class ArmsComponent extends MechaComponent {

    @Column(nullable = false)
    private int powerConsumption;

    @Column(nullable = false)
    private int durability;

    @Column(nullable = false)
    private int strength;

    @Column(nullable = false)
    private String type;

    @Embedded
    private ComponentSize size;

    public ArmsComponent(String name, int weight, List<Comment> comments, int powerConsumption, int durability, int strength, String type, ComponentSize size) {
        super(name, weight, comments);
        this.powerConsumption = powerConsumption;
        this.durability = durability;
        this.strength = strength;
        this.type = type;
        this.size = size;
    }
}
