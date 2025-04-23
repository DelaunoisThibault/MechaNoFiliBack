package be.technifutur.mechanofiliback.dl.entities;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.*;
import be.technifutur.mechanofiliback.dl.enums.MechaType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Getter
public class Mecha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 123)
    @Setter
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Setter
    private MechaType mechaType;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Setter
    private ArmsComponent arms;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Setter
    private LegsComponent legs;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Setter
    private HeadComponent head;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Setter
    private TorsoComponent torso;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Setter
    private GeneratorComponent generator;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Setter
    private ExtensionComponent extension;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Setter
    private MechaEquipment leftHand;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Setter
    private MechaEquipment rightHand;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Setter
    private MechaEquipment leftShoulder;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Setter
    private MechaEquipment rightShoulder;

    public Mecha (String name, MechaType mechaType) {
        this();
        this.name = name;
        this.mechaType = mechaType;
    }

    public Mecha (String name, MechaType mechaType, ArmsComponent arms, LegsComponent legs, HeadComponent head, TorsoComponent torso, GeneratorComponent generator, ExtensionComponent extension, MechaEquipment leftHand, MechaEquipment rightHand, MechaEquipment leftShoulder, MechaEquipment rightShoulder) {
        this(name, mechaType);
        this.arms = arms;
        this.legs = legs;
        this.head = head;
        this.torso = torso;
        this.generator = generator;
        this.extension = extension;
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.leftShoulder = leftShoulder;
        this.rightShoulder = rightShoulder;
    }
}
