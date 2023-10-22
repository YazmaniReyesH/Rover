package yazmani.reyesh.rover.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "obstacle")
public class Obstacle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "posx")
    private int x;

    @Column(name = "posy")
    private int y;
}
