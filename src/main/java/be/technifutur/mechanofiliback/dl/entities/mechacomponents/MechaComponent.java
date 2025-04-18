package be.technifutur.mechanofiliback.dl.entities.mechacomponents;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MechaComponent {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 123)
    private String name;

    @Column(nullable = false)
    private int weight;


}
