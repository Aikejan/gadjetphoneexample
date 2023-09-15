package aikejan.api;

import aikejan.dto.AuthenticationResponse;
import aikejan.dto.SignInRequest;
import aikejan.dto.SignUpRequest;
import aikejan.services.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "AuthenticationApi")
@RequestMapping("/api/auth")
@RestController
@RequiredArgsConstructor
public class AuthenticationApi {
    private  final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    @Operation(summary = "Sign Up",description = "Sign To Sign fill all the fields")  /// sms frontend
    AuthenticationResponse singUp(@RequestBody SignUpRequest signUpRequest){
        return  authenticationService.signUp(signUpRequest);
    }

    @PostMapping("/signIn")
    @Operation(summary = "Sign In",description = "Sign In")
    AuthenticationResponse singIn(@RequestBody SignInRequest signInRequest) {
        return authenticationService.signIn(signInRequest);
    }


}
