package application.states.ImplStates;

import application.Elevator;
import application.states.IStates.ElevatorState;

import java.util.Objects;

public class FloorThree implements ElevatorState {
    private final Elevator elevator;

    public FloorThree(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void moveToFloor() {
        if (Objects.equals(getElevator().getCurrentFloor(), getElevator().getButtonPushed())) {
            arriveAction();
        } else {
            System.out.println("Going down...");
            getElevator().decrementFloor(getElevator().getCurrentFloor());
            getElevator().changeState(new FloorTwo(getElevator()));
            getElevator().setMoving(true);
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
        getElevator().setMoving(false);
        openDoorAction();
    }

    public Elevator getElevator() {
        return elevator;
    }
}
