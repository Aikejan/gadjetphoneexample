package aikejan.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "favorites")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "favorite_gen")
    @SequenceGenerator(name = "favorite_gen",sequenceName ="favorite_seq", allocationSize = 1)
    private  Long id;
    @OneToMany(mappedBy = "favorite", cascade = {MERGE,DETACH,PERSIST,REFRESH})
    private List<User> user;
    @OneToMany(mappedBy = "favorite",cascade = CascadeType.ALL)
    private List<Product> products;
}
