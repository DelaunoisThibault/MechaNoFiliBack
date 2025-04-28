package be.technifutur.mechanofiliback.api.models.mechaComponents.dtos;

public record MechaComponentListDTO(
        Long id,
        String name,
        int weight,
        String imageUrl
) {

}
