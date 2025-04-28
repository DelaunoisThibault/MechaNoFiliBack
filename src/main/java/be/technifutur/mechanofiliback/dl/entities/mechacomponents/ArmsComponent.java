package be.technifutur.mechanofiliback.dl.entities.mechacomponents;

import be.technifutur.mechanofiliback.dl.entities.Comment;
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
public class ArmsComponent extends MechaComponent {

    @Column(nullable = false)
    private int powerConsumption;

    @Column(nullable = false)
    private int durability;

    @Column(nullable = false)
    private int strength;

    @Column(nullable = false)
    private WeightCategory weightCategory;

    @Column(nullable = false)
    private String type;

    @Embedded
    private ComponentSize size;

    public ArmsComponent(String name, int weight, int powerConsumption, int durability, int strength, WeightCategory weightCategory, String type, ComponentSize size) {
        super(name, weight);
        this.powerConsumption = powerConsumption;
        this.durability = durability;
        this.strength = strength;
        this.weightCategory = weightCategory;
        this.type = type;
        this.size = size;
    }

    public ArmsComponent(String name, int weight, String imageUrl, int powerConsumption, int durability, int strength, WeightCategory weightCategory, String type, ComponentSize size) {
        super(name, weight, imageUrl);
        this.powerConsumption = powerConsumption;
        this.durability = durability;
        this.strength = strength;
        this.weightCategory = weightCategory;
        this.type = type;
        this.size = size;
    }

    public ArmsComponent(String name, int weight, List<Comment> comments, String imageUrl, int powerConsumption, int durability, int strength, WeightCategory weightCategory, String type, ComponentSize size) {
        super(name, weight, comments, imageUrl);
        this.powerConsumption = powerConsumption;
        this.durability = durability;
        this.strength = strength;
        this.weightCategory = weightCategory;
        this.type = type;
        this.size = size;
    }
}
