package be.technifutur.mechanofiliback.dl.entities.mechacomponents;

import be.technifutur.mechanofiliback.dl.entities.Comment;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class GeneratorComponent extends MechaComponent {

    @Column(nullable = false)
    private int powerCapacity;

    @Embedded
    private ComponentSize size;

    public GeneratorComponent(String name, int weight, int powerCapacity, ComponentSize size) {
        super(name, weight);
        this.powerCapacity = powerCapacity;
        this.size = size;
    }

    public GeneratorComponent(String name, int weight, List<Comment> comments, int powerCapacity, ComponentSize size) {
        super(name, weight, comments);
        this.powerCapacity = powerCapacity;
        this.size = size;
    }
}
