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

    @Setter
    @Column(nullable = false, length = 123)
    private String name;

    @Setter
    @Column(nullable = false)
    private int weight;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Setter
    private EquipmentType equipmentType;

    @Setter
    @Column(nullable = false)
    private int powerConsumption;

    @Setter
    @Column(nullable = false)
    private int durability;

    public MechaEquipment(String name, int weight, EquipmentType equipmentType, int powerConsumption, int durability) {
        this.name = name;
        this.weight = weight;
        this.equipmentType = equipmentType;
        this.powerConsumption = powerConsumption;
        this.durability = durability;
    }
}
