package aikejan.services.serviceImpl;

import aikejan.dto.AuthenticationResponse;
import aikejan.dto.SignInRequest;
import aikejan.dto.SignUpRequest;
import aikejan.entity.User;
import aikejan.enums.Role;
import aikejan.exceptions.BadCredentialException;
import aikejan.exceptions.NotFoundException;
import aikejan.repository.UserRepository;
import aikejan.securityConfig.JwtService;
import aikejan.services.AuthenticationService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponse signUp(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new EntityExistsException("BUl EMAIDAGY USER: " + signUpRequest.getEmail() + "bar");
        }
        User user = User.builder()
                .firstname(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .email(user.getEmail())
                .role(user.getRole())
                .build();


    }

    @Override
    public AuthenticationResponse signIn(SignInRequest signInRequest) {
        User user = userRepository.getUserByEmail(signInRequest.getEmail()).orElseThrow(() ->
                new NotFoundException("User with email:" + signInRequest.getEmail()));
        if (signInRequest.getEmail().isBlank()) {
            throw new BadCredentialException("Email isBlank");
        }
        if (!passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())) {
            throw new BadCredentialException("Wrong PASSWORD");
        }
        String token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    @PostConstruct
    @Override
    public void init() {
        User admin = new User();
        admin.setFirstname("Admin");
        admin.setLastName("Adminova");
        admin.setEmail("admin@gmail.com");
        admin.setRole(Role.ADMIN);
        admin.setPassword(passwordEncoder.encode("admin00"));
        admin.setCreatedDate(ZonedDateTime.now());
        if (!userRepository.existsByEmail("admin@gmail.com")){
            userRepository.save(admin);
        }

    }

}
