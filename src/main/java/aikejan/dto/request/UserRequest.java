package aikejan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRequest {
    String firstName;
    String lastName;
    String email;
    String password;
    String createdDate;
    String updateDate;

}
