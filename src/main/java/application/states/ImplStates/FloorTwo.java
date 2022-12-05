package application.states.ImplStates;

import application.Elevator;
import application.states.IStates.ElevatorState;

import java.util.Objects;

public class FloorTwo implements ElevatorState {
    private final Elevator elevator;

    public FloorTwo(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void moveToFloor() {
        if (Objects.equals(getElevator().getCurrentFloor(), getElevator().getButtonPushed())) {
            arriveAction();
        } else {
            if (getElevator().getCurrentFloor() > getElevator().getButtonPushed()) {
                getElevator().decrementFloor(getElevator().getCurrentFloor());
                getElevator().changeState(new FloorOne(getElevator()));
                if (!getElevator().isMoving()) {
                    System.out.println("Going down...");
                    getElevator().setMoving(true);
                }
            } else {
                getElevator().incrementFloor(elevator.getCurrentFloor());
                getElevator().changeState(new FloorThree(getElevator()));
                if (!getElevator().isMoving()) {
                    System.out.println("Going up...");
                    getElevator().setMoving(true);
                }
            }

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
        if (!getElevator().isClosed()) {
            getElevator().setClosed(true);
            System.out.println("Doors are closed");
        }
    }

    @Override
    public void openDoorAction() {
        if (getElevator().isClosed()) {
            getElevator().setClosed(false);
            System.out.println("Doors are open");
        }
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
