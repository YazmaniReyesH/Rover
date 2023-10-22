package yazmani.reyesh.rover.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yazmani.reyesh.rover.dto.CommandDto;
import yazmani.reyesh.rover.dto.RoverDto;
import yazmani.reyesh.rover.models.Direction;
import yazmani.reyesh.rover.models.Rover;
import yazmani.reyesh.rover.services.RoverService;

@RestController
public class RoverController {

    @Autowired
    RoverService service;

    @GetMapping("api/rover/")
    public Rover get(){
        return service.get();
    }

    @PostMapping("api/rover/")
    public void create(@RequestBody RoverDto rover){
        System.out.println(rover);
    }

    @PostMapping("api/rover/command/")
    public void sendCommand(@RequestBody CommandDto commands){
        System.out.println(commands);

        for(String command:commands.getCommands()){
            //Codigo para cumplir el test
            service.sendCommand(command);
            System.out.println(command);
        }
    }
}
