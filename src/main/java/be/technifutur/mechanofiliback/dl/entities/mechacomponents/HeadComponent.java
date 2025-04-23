package be.technifutur.mechanofiliback.dl.entities.mechacomponents;

import be.technifutur.mechanofiliback.dl.entities.Comment;
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

    @Embedded
    private ComponentSize size;

    public HeadComponent(String name, int weight, int powerConsumption, int durability, String sensors, String fireControlSystem, ComponentSize size) {
        super(name, weight);
        this.powerConsumption = powerConsumption;
        this.durability = durability;
        this.sensors = sensors;
        this.fireControlSystem = fireControlSystem;
        this.size = size;
    }

    public HeadComponent(String name, int weight, List<Comment> comments, int powerConsumption, int durability, String sensors, String fireControlSystem, ComponentSize size) {
        super(name, weight, comments);
        this.powerConsumption = powerConsumption;
        this.durability = durability;
        this.sensors = sensors;
        this.fireControlSystem = fireControlSystem;
        this.size = size;
    }
}
