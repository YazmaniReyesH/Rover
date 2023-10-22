package yazmani.reyesh.rover.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yazmani.reyesh.rover.dto.ObstacleDto;
import yazmani.reyesh.rover.models.Obstacle;
import yazmani.reyesh.rover.services.ObstacleService;

import java.util.List;

@RestController
public class ObstacleController {

    @Autowired
    private ObstacleService service;

    @PostMapping("api/obstacle/")
    public void create(@RequestBody ObstacleDto obstacle){
        System.out.println(obstacle);
    }
    @GetMapping("api/obstacle/")
    public List<Obstacle> getAll(){
        return service.findAll();
    }

}
