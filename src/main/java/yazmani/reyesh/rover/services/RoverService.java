package yazmani.reyesh.rover.services;

import yazmani.reyesh.rover.models.Rover;

public interface RoverService {
    public Rover get();

    void sendCommand(String command);
}
