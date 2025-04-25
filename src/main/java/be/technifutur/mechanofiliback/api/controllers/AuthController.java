package be.technifutur.mechanofiliback.api.controllers;

import be.technifutur.mechanofiliback.api.models.security.dtos.UserSessionDTO;
import be.technifutur.mechanofiliback.api.models.security.dtos.UserTokenDTO;
import be.technifutur.mechanofiliback.api.models.security.forms.LoginForm;
import be.technifutur.mechanofiliback.api.models.security.forms.RegisterForm;
import be.technifutur.mechanofiliback.bll.AuthService;
import be.technifutur.mechanofiliback.dl.entities.User;
import be.technifutur.mechanofiliback.il.utils.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    @Operation(summary = "Registers a new user with user role")
    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Valid @RequestBody() RegisterForm form
    ) {
        authService.register(form.toUser());
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Logins any already registered wizard")
    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public ResponseEntity<UserTokenDTO> login(
            @Valid @RequestBody LoginForm form
    ) {
        User user = authService.login(form.email(), form.password());
        UserSessionDTO sessionDTO = UserSessionDTO.fromUser(user);
        String token = jwtUtil.generateToken(user);
        UserTokenDTO userTokenDTO = new UserTokenDTO(sessionDTO, token);
        return ResponseEntity.ok(userTokenDTO);
    }

}
