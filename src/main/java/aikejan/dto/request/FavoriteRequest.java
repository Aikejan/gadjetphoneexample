package aikejan.dto.request;

import aikejan.entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;
@Getter
@Setter
public class FavoriteRequest {
    User user;
    Product product;
}
