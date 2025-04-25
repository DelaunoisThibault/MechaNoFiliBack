package be.technifutur.mechanofiliback.api.models.security.dtos;

import be.technifutur.mechanofiliback.dl.entities.User;
import be.technifutur.mechanofiliback.dl.enums.UserRole;

public record UserSessionDTO(
        Long id,
        UserRole role,
        String userName
) {
    public static UserSessionDTO fromUser(User user) {
        return new UserSessionDTO(user.getId(), user.getRole(), user.getUsername());
    }
}
