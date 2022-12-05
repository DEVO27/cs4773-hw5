package application;

import application.states.IStates.ElevatorState;
import application.states.ImplStates.FloorOne;

import java.util.Objects;

public class Elevator {
    private ElevatorState state;
    private int currentFloor = 1;
    private int buttonPushed;
    private boolean isMoving = false;

    /*** Initial State of the Elevator ***/
    public Elevator() {
        this.state = new FloorOne(this);
    }

    public void onCurrentFloor() {
        state.currentFloor();
    }

    public void closedDoors() {
        state.closedDoorAction();
    }

    public void openDoors() {
        state.openDoorAction();
    }

    public void arrived() {
        state.arriveAction();
    }

    public void moveToFloor() {
        state.moveToFloor();
    }

    public void decrementFloor(int floor) {
        setCurrentFloor((floor - 1) > 0 ? --floor : floor);
    }

    public void incrementFloor(int floor) {
        setCurrentFloor((floor + 1) < 4 ? ++floor : floor);
    }

    public void changeState(ElevatorState elevatorState) {
        state = elevatorState;
    }

    public void request(int buttonPushed) {
        setButtonPushed(buttonPushed);
        System.out.println(buttonPushed + " pressed");

        //Determine if elevator is on current floor
        if (Objects.equals(getCurrentFloor(), getButtonPushed())) {
            onCurrentFloor();
        } else {
            closedDoors();
            moveToFloor();
        }
    }

    public ElevatorState getState() {
        return state;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getButtonPushed() {
        return buttonPushed;
    }

    public void setButtonPushed(int buttonPushed) {
        this.buttonPushed = buttonPushed;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }
}
