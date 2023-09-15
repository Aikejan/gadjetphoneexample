package aikejan.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "brands")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "brand_gen")
    @SequenceGenerator(name = "brand_gen",sequenceName ="brand_seq", allocationSize = 1)
    private  Long id;
    private  String brandName;
     private  String image;
     @OneToMany(mappedBy = "brand", cascade ={PERSIST,DETACH,MERGE,REFRESH})
     private List<Product> products;

}
