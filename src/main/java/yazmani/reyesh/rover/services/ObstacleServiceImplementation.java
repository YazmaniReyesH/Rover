package yazmani.reyesh.rover.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yazmani.reyesh.rover.dto.ObstacleDto;
import yazmani.reyesh.rover.models.Obstacle;
import yazmani.reyesh.rover.repository.ObstacleRepository;

import java.util.List;

@Service
public class ObstacleServiceImplementation implements ObstacleService{

    @Autowired
    private ObstacleRepository repository;
    @Override
    public List<Obstacle> findAll() {
        return repository.findAll();
    }
}
