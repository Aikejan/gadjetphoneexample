package aikejan.dto.response;

import aikejan.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class ProductResponse {
    Long id;
    String name;
    BigDecimal price;
    List<String> image;
    String characteristic;
   Boolean isFavorite;
    String madeIn;
    Category category;


    public ProductResponse(Long id, String name, BigDecimal price, List<String> image, String characteristic, Boolean isFavorite, String madeIn) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.characteristic = characteristic;
        this.isFavorite = isFavorite;
        this.madeIn = madeIn;
    }

    public ProductResponse() {
    }
}
