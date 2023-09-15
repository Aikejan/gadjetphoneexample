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
public class SignUpRequest {
   private String firstName;
   private String lastName;
   private String email;
   private String password;
   private Role role;




}
