package aikejan.entity;

import jakarta.persistence.*;
import aikejan.enums.Role;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User  implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
    private Long id;
    private  String firstname;
    private  String lastName;
    private String email;
    private  String password;
    @Column(name = "created_Date")
    private ZonedDateTime createdDate;
    private  ZonedDateTime updatedDate;
    @Enumerated(EnumType.STRING)             // enum ekenin belgileyt
    private Role role;
    @OneToOne( mappedBy = "user",cascade = CascadeType.ALL)
    private Basket basket;
    @ManyToOne
    private Favorite favorite;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
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