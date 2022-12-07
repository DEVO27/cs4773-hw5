package application.states.ImplStates;

import application.Elevator;
import application.states.IStates.ElevatorState;

public class FloorTwo implements ElevatorState {
    private final Elevator elevator;

    public FloorTwo(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void moveToFloor() {
        if (getElevator().getButtonPushed() > getElevator().getCurrentFloor()) {
            System.out.println("Going up...");
            getElevator().changeState(new FloorThree(getElevator()));
        } else {
            System.out.println("Going down...");
            getElevator().changeState(new FloorOne(getElevator()));
        }

        getElevator().setCurrentFloor(getElevator().getButtonPushed());
        getElevator().arrived();
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
