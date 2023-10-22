package yazmani.reyesh.rover.dto;

import lombok.Data;
import yazmani.reyesh.rover.models.Direction;
@Data
public class RoverDto {
    private Integer x;
    private Integer y;
    private Direction direction;
}
