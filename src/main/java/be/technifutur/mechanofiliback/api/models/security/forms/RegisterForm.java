package be.technifutur.mechanofiliback.api.models.security.forms;

import be.technifutur.mechanofiliback.dl.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterForm(
        @NotBlank @Size(max = 150)
        String email,
        @NotBlank @Size(max = 123)
        String username,
        @NotBlank
        String password
) {
    public User toUser() {
        return new User(
                this.email,
                this.username,
                this.password
        );

    }
}
