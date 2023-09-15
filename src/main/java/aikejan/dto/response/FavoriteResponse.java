package aikejan.dto.response;

import aikejan.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FavoriteResponse {
    Long id;
    User user;
    Product product;
}
