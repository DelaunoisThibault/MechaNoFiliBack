package be.technifutur.mechanofiliback.dl.entities.mechacomponents;

import be.technifutur.mechanofiliback.dl.entities.Comment;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
@Setter
public class LegsComponent extends MechaComponent {

    @Column(nullable = false)
    private int powerConsumption;

    @Column(nullable = false)
    private int durability;

    @Column(nullable = false)
    private int strength;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private WeightCategory weightCategory;

    @Embedded
    private ComponentSize size;

    public LegsComponent(String name, int weight, String imageUrl, int powerConsumption, int durability, int strength, String type, WeightCategory weightCategory, ComponentSize size) {
        super(name, weight, imageUrl);
        this.powerConsumption = powerConsumption;
        this.durability = durability;
        this.strength = strength;
        this.type = type;
        this.weightCategory = weightCategory;
        this.size = size;
    }

    public LegsComponent(String name, int weight, List<Comment> comments, String imageUrl, int powerConsumption, int durability, int strength, String type, WeightCategory weightCategory, ComponentSize size) {
        super(name, weight, comments, imageUrl);
        this.powerConsumption = powerConsumption;
        this.durability = durability;
        this.strength = strength;
        this.type = type;
        this.weightCategory = weightCategory;
        this.size = size;
    }
}
