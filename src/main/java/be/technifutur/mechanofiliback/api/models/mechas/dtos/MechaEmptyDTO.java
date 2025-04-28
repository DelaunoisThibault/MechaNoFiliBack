package be.technifutur.mechanofiliback.api.models.mechas.dtos;

import be.technifutur.mechanofiliback.dl.entities.Mecha;
import be.technifutur.mechanofiliback.dl.enums.MechaType;

public record MechaEmptyDTO(
        Long id,
        String name,
        MechaType mechaType,
        Long userId
) {
    public static MechaEmptyDTO fromEmptyMecha(Mecha mecha) {
        return new MechaEmptyDTO(
                mecha.getId(),
                mecha.getName(),
                mecha.getMechaType(),
                mecha.getUser().getId()
        );
    }

}
