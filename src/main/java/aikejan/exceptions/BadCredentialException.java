package aikejan.exceptions;

public class BadCredentialException extends  RuntimeException{
    public BadCredentialException(String message) {
        super(message);
    }
}
