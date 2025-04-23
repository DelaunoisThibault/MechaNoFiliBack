package be.technifutur.mechanofiliback.dl.entities.mechacomponents;

import be.technifutur.mechanofiliback.dl.entities.Comment;
import jakarta.persistence.Column;
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
public class ExtensionComponent extends MechaComponent {

    @Column(nullable = false)
    private int powerConsumption;

    public ExtensionComponent(String name, int weight, int powerConsumption) {
        super(name, weight);
        this.powerConsumption = powerConsumption;
    }

    public ExtensionComponent(String name, int weight, List<Comment> comments, int powerConsumption) {
        super(name, weight, comments);
        this.powerConsumption = powerConsumption;
    }
}
