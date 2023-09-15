package aikejan.services;

import aikejan.dto.AuthenticationResponse;
import aikejan.dto.SignInRequest;
import aikejan.dto.SignUpRequest;

public interface AuthenticationService {
    AuthenticationResponse signUp(SignUpRequest signUpRequest);
    AuthenticationResponse signIn(SignInRequest signInRequest);
    void init();
}
