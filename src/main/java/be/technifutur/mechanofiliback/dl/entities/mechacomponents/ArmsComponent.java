package be.technifutur.mechanofiliback.dl.entities.mechacomponents;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class ArmsComponent extends MechaComponent {

    @Column(nullable = false)
    private int power_consumption;

    @Column(nullable = false)
    private int durability;
}
