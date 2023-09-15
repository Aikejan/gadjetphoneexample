package aikejan.entity;

import aikejan.dto.request.ProductRequest;
import aikejan.dto.response.ProductResponse;
import aikejan.enums.Category;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_gen")
    @SequenceGenerator(name = "product_gen",sequenceName ="product_seq", allocationSize = 1)
    private  Long id;
    private String name;
    private BigDecimal price;
    @ElementCollection              /// LIST-STRINGTERGE KOYULAT
    private List<String> image;
    private String characteristic;
    private Boolean isFavorite;
    private String madeIn;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Comment comment;
    @ManyToOne
    private Brand brand;
    @ManyToMany
    private List<Basket> basket;
    @ManyToOne
    private Favorite favorite;



}
