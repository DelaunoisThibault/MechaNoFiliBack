package be.technifutur.mechanofiliback.dl.entities.mechacomponents;

import be.technifutur.mechanofiliback.dl.entities.Comment;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;
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

    @Column(nullable = false)
    private WeightCategory weightCategory;

    @Embedded
    private ComponentSize size;

    public GeneratorComponent(String name, int weight, String imageUrl, int powerCapacity, WeightCategory weightCategory, ComponentSize size) {
        super(name, weight, imageUrl);
        this.powerCapacity = powerCapacity;
        this.weightCategory = weightCategory;
        this.size = size;
    }

    public GeneratorComponent(String name, int weight, List<Comment> comments, String imageUrl, int powerCapacity, WeightCategory weightCategory, ComponentSize size) {
        super(name, weight, comments, imageUrl);
        this.powerCapacity = powerCapacity;
        this.weightCategory = weightCategory;
        this.size = size;
    }
}
