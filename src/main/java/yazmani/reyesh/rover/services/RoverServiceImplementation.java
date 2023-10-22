package yazmani.reyesh.rover.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yazmani.reyesh.rover.models.Direction;
import yazmani.reyesh.rover.models.Obstacle;
import yazmani.reyesh.rover.models.Rover;
import yazmani.reyesh.rover.repository.ObstacleRepository;
import yazmani.reyesh.rover.repository.RoverRepository;

import java.util.List;

@Service
public class RoverServiceImplementation implements RoverService{

    @Autowired
    RoverRepository repository;

    @Autowired
    ObstacleRepository obstacleRepository;

    @Override
    public Rover get() {
        List<Rover> roverList = repository.findAll();
        return roverList.get(0);
    }

    @Override
    public void sendCommand(String command) {
        Rover rover = get();

        switch(command) {
            case "F": moveRover(rover, true); break;
            case "B": moveRover(rover, false); break;
            case "R": turnRover(rover, true); break;
            case "L": turnRover(rover, false); break;
        }
        repository.save(rover);
    }

    private void turnRover(Rover rover, boolean isRight) {
        Direction direction = rover.getDirection();
        Direction finalDirection = null;

        if (isRight) {
            switch(direction) {
                case NORTH: finalDirection = Direction.EAST; break;
                case EAST: finalDirection = Direction.SOUTH; break;
                case SOUTH: finalDirection = Direction.WEST; break;
                case WEST: finalDirection = Direction.NORTH; break;
            }
        } else {
            switch(direction) {
                case NORTH: finalDirection = Direction.WEST; break;
                case WEST: finalDirection = Direction.SOUTH; break;
                case SOUTH: finalDirection = Direction.EAST; break;
                case EAST: finalDirection = Direction.NORTH; break;
            }
        }
        rover.setDirection(finalDirection);
    }

    private void moveRover(Rover rover, boolean isForward) {
        int posXFinal = rover.getX();
        int posYFinal = rover.getY();

        Direction direction = rover.getDirection();
        if (Direction.EAST.equals(direction)
                || Direction.WEST.equals(direction)) {
            posXFinal += isForward ? direction.getValue() : -direction.getValue();
        }

        if (Direction.NORTH.equals(direction)
                || Direction.SOUTH.equals(direction)) {
            posYFinal -= isForward ? direction.getValue() : -direction.getValue();
        }

        if (canBeMoved(posXFinal, posYFinal)) {
            rover.setX(posXFinal);
            rover.setY(posYFinal);
        }
    }

    private boolean canBeMoved(int posXFinal, int posYFinal) {
        List<Obstacle> obstacles = obstacleRepository.findAll();
        for (Obstacle obstacle:obstacles) {
            if (obstacle.getX() == posXFinal
                    && obstacle.getY() == posYFinal) {
                return false;
            }
        }
        return true;
    }
}
