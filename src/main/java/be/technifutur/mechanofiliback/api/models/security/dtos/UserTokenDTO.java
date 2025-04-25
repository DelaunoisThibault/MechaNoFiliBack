package be.technifutur.mechanofiliback.api.models.security.dtos;

public record UserTokenDTO(
        UserSessionDTO user,
        String token
) {
}
