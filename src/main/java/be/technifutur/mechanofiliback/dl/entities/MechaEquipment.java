package be.technifutur.mechanofiliback.dl.entities;

import be.technifutur.mechanofiliback.dl.enums.EquipmentType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Getter
public class MechaEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 123)
    private String name;

    @Column(nullable = false)
    private int weight;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Setter
    private EquipmentType equipmentType;

    @Column(nullable = false)
    private int power_consumption;

    @Column(nullable = false)
    private int durability;
}
