package be.technifutur.mechanofiliback.api.models.mechas.forms;

import be.technifutur.mechanofiliback.dl.entities.Mecha;
import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.*;
import be.technifutur.mechanofiliback.dl.enums.MechaType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MechaForm (
        @NotBlank @Size(max = 100)
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
        public Mecha toMecha(){
                return new Mecha(
                         name,
                         mechaType,
                         arms,
                         legs,
                         head,
                         torso,
                         generator,
                         extension,
                         leftHand,
                         rightHand,
                         leftShoulder,
                         rightShoulder
                );
        }
}
