package aikejan.repository;

import aikejan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{


    boolean existsByEmail(String message);

    Optional<User> getUserByEmail (String email);
}
