package com.heleneharmens.app;

import com.heleneharmens.app.model.Elevator;
import com.heleneharmens.app.model.ElevatorSystem;

/**
 * Heiskontroll 3b)
 * @author Helene Harmens
 * 14.01.2020
 */

public class App {
    public static void main( String[] args ) {

        // FOR TESTING FUNCTIONALITY

        System.out.println( "--- Elevator Control System ---" );

        Elevator elevator1 = new Elevator("ELE-001", 1, 2);
        Elevator elevator2 = new Elevator("ELE-002", 3);
        Elevator elevator3 = new Elevator();

        ElevatorSystem elevatorSystem = new ElevatorSystem(elevator1, elevator2, elevator3);

        // Display info
        elevatorSystem.displayElevators();
        elevator1.displayElevatorStatus();
        elevator2.displayElevatorStatus();
        elevator3.displayElevatorStatus();

        System.out.println();

        // Button pressing
        elevatorSystem.pushExternalButton(3, ElevatorSystem.DIRECTION.UP);

        elevator2.pushInternalButton(9);
        elevator1.pushInternalButton(3, 5, 10);
        elevator3.pushInternalButton(3, 5, 1, 4);

        elevatorSystem.pushExternalButton(4, ElevatorSystem.DIRECTION.DOWN);

        elevator2.emergencyStop();

    }


}

