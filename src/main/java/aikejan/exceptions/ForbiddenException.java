package aikejan.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForbiddenException {
    public ForbiddenException() {
    }

    public ForbiddenException(String message) {
        super();
    }  // ZAPRESHENOEXCEPTION
}
