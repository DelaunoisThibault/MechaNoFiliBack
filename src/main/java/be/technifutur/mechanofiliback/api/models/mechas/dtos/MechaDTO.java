package be.technifutur.mechanofiliback.api.models.mechas.dtos;

import be.technifutur.mechanofiliback.dl.entities.Mecha;
import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.*;
import be.technifutur.mechanofiliback.dl.enums.MechaType;

public record MechaDTO (
        Long id,
        String name,
        MechaType mechaType,
        ArmsComponent arms,
        LegsComponent legs,
        HeadComponent head,
        TorsoComponent torso,
        GeneratorComponent generator,
        ExtensionComponent extension,
        MechaEquipment leftHand,
        MechaEquipment rightHand,
        MechaEquipment leftShoulder,
        MechaEquipment rightShoulder

) {
    public static MechaDTO fromMecha(Mecha mecha) {
        return new MechaDTO(
                mecha.getId(),
                mecha.getName(),
                mecha.getMechaType(),
                mecha.getArms(),
                mecha.getLegs(),
                mecha.getHead(),
                mecha.getTorso(),
                mecha.getGenerator(),
                mecha.getExtension(),
                mecha.getLeftHand(),
                mecha.getRightHand(),
                mecha.getLeftShoulder(),
                mecha.getRightShoulder()
        );
    }
}
