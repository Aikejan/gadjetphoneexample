package aikejan.dto;

import aikejan.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AuthenticationResponse {
    private String token;
    private String name;
    private String email;
    private Role role;

}
