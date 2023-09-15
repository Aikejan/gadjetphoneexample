package aikejan.dto.request;

import aikejan.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ProductRequest {
    String name;
    int price;
     List<String> image;
    String characteristic;
     boolean isFavorite;
     String madeIn;
     Category category;

}
