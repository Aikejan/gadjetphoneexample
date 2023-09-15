package aikejan.dto.response;

import aikejan.entity.Product;
import aikejan.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BasketResponse {
    Long id;
    List<Product> products;
    User user;
}
