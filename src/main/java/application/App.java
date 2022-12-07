package application;

import application.states.Button;

//Starting point of application
public class App {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();  //Current state is stateOne (FloorOne)
        //Loops through listOf buttons pressed
        for (Integer button : new Button().getButtons(args[0])) {
            elevator.request(button);
        }
    }
}
