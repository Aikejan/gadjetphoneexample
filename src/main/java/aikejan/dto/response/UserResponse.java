package aikejan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserResponse {
    Long id;
    String firstName;
    String lastName;
    String email;
    String password;
    String createdDate;
    String updateDate;

}
