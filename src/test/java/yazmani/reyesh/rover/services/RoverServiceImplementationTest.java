package yazmani.reyesh.rover.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import yazmani.reyesh.rover.models.Direction;
import yazmani.reyesh.rover.models.Rover;
import yazmani.reyesh.rover.repository.RoverRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RoverServiceImplementationTest {
    @Mock
    private RoverRepository roverRepository;

    @InjectMocks
    private RoverServiceImplementation serviceImplementation;

    @Test
    public void callServicewhenSendACommand(){
        Rover initialRover = new Rover();
        initialRover.setX(5);
        initialRover.setY(5);
        initialRover.setDirection(Direction.NORTH);
        List<Rover> roverList = new ArrayList<>();
        roverList.add(initialRover);

        when(roverRepository.findAll()).thenReturn(roverList);

        serviceImplementation.sendCommand("F");

        Rover finalRover = new Rover();
        finalRover.setX(5);
        finalRover.setY(4);
        finalRover.setDirection(Direction.NORTH);

        verify(roverRepository, times(1)).save(finalRover);
    }
}
