package application;

import application.states.Button;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Elevator elevator = new Elevator();
        //Loops through listOf buttons pressed
        for (Integer button: new Button().getButtons(args[0])) {
            elevator.request(button);
        }
    }
}