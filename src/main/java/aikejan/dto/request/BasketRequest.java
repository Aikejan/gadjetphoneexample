package aikejan.dto.request;

import aikejan.entity.Product;
import aikejan.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BasketRequest {
    List<Product> products;
    User user;
}
