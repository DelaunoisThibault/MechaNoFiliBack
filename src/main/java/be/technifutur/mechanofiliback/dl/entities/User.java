package be.technifutur.mechanofiliback.dl.entities;

import be.technifutur.mechanofiliback.dl.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "_user")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"email"})
@ToString(of = {"email"})
@Getter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String email;

    @Setter
    @Column(name = "username", nullable = false, unique = true, length = 120)
    private String username;

    @Setter
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Setter
    @Column(nullable = false)
    private String password;

    @Setter
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @Setter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Mecha> mechas = new ArrayList<>();

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String email, String username, UserRole role, String password) {
        this.email = email;
        this.username = username;
        this.role = role;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.toString()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
