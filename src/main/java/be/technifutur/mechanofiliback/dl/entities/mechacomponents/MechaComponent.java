package be.technifutur.mechanofiliback.dl.entities.mechacomponents;

import be.technifutur.mechanofiliback.dl.entities.Comment;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class MechaComponent {

    @Id
    @GeneratedValue
    private Long id;

    @Setter
    @Column(nullable = false, length = 123)
    private String name;

    @Setter
    @Column(nullable = false)
    private int weight;

    @Column(nullable = false)
    @Setter
    private String imageUrl;

    @Setter
    @OneToMany
    private List<Comment> comments = new ArrayList<>();

    public MechaComponent(String name, int weight, String imageUrl) {
        this();
        this.name = name;
        this.weight = weight;
        this.imageUrl = imageUrl;
    }

    public MechaComponent(String name, int weight, List<Comment> comments, String imageUrl) {
        this();
        this.name = name;
        this.weight = weight;
        this.comments = comments;
        this.imageUrl = imageUrl;
    }


}
