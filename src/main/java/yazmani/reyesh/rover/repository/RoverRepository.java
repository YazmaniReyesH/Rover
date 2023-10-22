package yazmani.reyesh.rover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yazmani.reyesh.rover.models.Rover;

public interface RoverRepository extends JpaRepository<Rover, Long> {
}
