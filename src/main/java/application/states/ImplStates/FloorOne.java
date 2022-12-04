package application.states.ImplStates;

import application.Elevator;
import application.states.IStates.ElevatorState;

import java.util.Objects;

public class FloorOne implements ElevatorState {
    private final Elevator elevator;

    public FloorOne(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void moveToFloor() {
        if (Objects.equals(getElevator().getCurrentFloor(), getElevator().getButtonPushed())) {
            arriveAction();
        } else {
            System.out.println("Going up...");
            getElevator().incrementFloor(getElevator().getCurrentFloor());
            getElevator().changeState(new FloorTwo(getElevator()));
            getElevator().moveToFloor();
        }
    }

    @Override
    public void currentFloor() {
        closedDoorAction();
        System.out.println("Nothing happens");
    }

    @Override
    public void closedDoorAction() {
        System.out.println("Doors are closed");
    }

    @Override
    public void openDoorAction() {
        System.out.println("Doors are open");
    }

    @Override
    public void arriveAction() {
        System.out.println("*ding* The elevator arrives at Floor " + getElevator().getCurrentFloor());
        openDoorAction();
    }

    public Elevator getElevator() {
        return elevator;
    }
}
