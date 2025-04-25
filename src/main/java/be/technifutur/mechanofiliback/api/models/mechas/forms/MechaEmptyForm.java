package be.technifutur.mechanofiliback.api.models.mechas.forms;

import be.technifutur.mechanofiliback.dl.entities.Mecha;
import be.technifutur.mechanofiliback.dl.enums.MechaType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MechaEmptyForm(
        @NotBlank @Size(max = 100)
        String name,
        MechaType mechaType
) {
    public Mecha toEmptyMecha(){
        return new Mecha(
                name,
                mechaType
        );
    }
}
