package yazmani.reyesh.rover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yazmani.reyesh.rover.models.Obstacle;

public interface ObstacleRepository extends JpaRepository<Obstacle, Long> {
}
