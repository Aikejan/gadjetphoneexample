package aikejan.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "comments")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "comment_gen")
    @SequenceGenerator(name = "comment_gen",sequenceName ="comment_seq", allocationSize = 1)
    private  Long id;
    private   String comment;
    private ZonedDateTime createdDate;
    @OneToMany(mappedBy = "comment", cascade =  {MERGE,DETACH,PERSIST,REFRESH})
    private List<Product> products;

}
