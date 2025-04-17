package be.technifutur.mechanofiliback.api.models.mechas.dtos;

import be.technifutur.mechanofiliback.dl.enums.MechaType;

public record MechaDTO(
        Long id,
        String name,
        MechaType mechaType
) {

}
