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
public class HeadComponent extends MechaComponent {

    @Column(nullable = false)
    private int powerConsumption;

    @Column(nullable = false)
    private int durability;

    @Column(nullable = false)
    private String sensors;

    @Column(nullable = false)
    private String fireControlSystem;

    @Column(nullable = false)
    private WeightCategory weightCategory;

    @Embedded
    private ComponentSize size;

    public HeadComponent(String name, int weight, int powerConsumption, int durability, String sensors, String fireControlSystem, WeightCategory weightCategory, ComponentSize size) {
        super(name, weight);
        this.powerConsumption = powerConsumption;
        this.durability = durability;
        this.sensors = sensors;
        this.fireControlSystem = fireControlSystem;
        this.weightCategory = weightCategory;
        this.size = size;
    }

    public HeadComponent(String name, int weight, String imageUrl, int powerConsumption, int durability, String sensors, String fireControlSystem, WeightCategory weightCategory, ComponentSize size) {
        super(name, weight, imageUrl);
        this.powerConsumption = powerConsumption;
        this.durability = durability;
        this.sensors = sensors;
        this.fireControlSystem = fireControlSystem;
        this.weightCategory = weightCategory;
        this.size = size;
    }

    public HeadComponent(String name, int weight, List<Comment> comments, String imageUrl, int powerConsumption, int durability, String sensors, String fireControlSystem, WeightCategory weightCategory, ComponentSize size) {
        super(name, weight, comments, imageUrl);
        this.powerConsumption = powerConsumption;
        this.durability = durability;
        this.sensors = sensors;
        this.fireControlSystem = fireControlSystem;
        this.weightCategory = weightCategory;
        this.size = size;
    }
}
