package application.states.IStates;

public interface ElevatorState {
    void moveToFloor();
    void currentFloor();
    void closedDoorAction();
    void openDoorAction();
    void arriveAction();
}
