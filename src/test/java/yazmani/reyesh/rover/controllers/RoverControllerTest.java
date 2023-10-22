package yazmani.reyesh.rover.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import yazmani.reyesh.rover.dto.CommandDto;
import yazmani.reyesh.rover.services.RoverService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RoverControllerTest {

    @Mock
    private RoverService roverService;

    @InjectMocks
    private RoverController controller;

    @Test
    public void callServicewhenSendACommand(){
        controller = new RoverController();
        CommandDto commandDto = new CommandDto();
        List<String> commandsList = new ArrayList<>();
        commandsList.add("F");
        commandDto.setCommands(commandsList);

        controller.sendCommand(commandDto);

        verify(roverService, times(1)).sendCommand("F");

    }

    @Test
    public void callServicewhenSendACommand_FRF(){
        controller = new RoverController();
        CommandDto commandDto = new CommandDto();
        List<String> commandsList = new ArrayList<>();
        commandsList.add("F");
        commandsList.add("R");
        commandsList.add("F");
        commandDto.setCommands(commandsList);

        controller.sendCommand(commandDto);

        verify(roverService, times(3)).sendCommand(any());

    }
}
