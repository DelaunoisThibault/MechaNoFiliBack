package be.technifutur.mechanofiliback.dl.entities.mechacomponents;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class GeneratorComponent extends MechaComponent {

    @Column(nullable = false)
    private int power_capacity;
}
