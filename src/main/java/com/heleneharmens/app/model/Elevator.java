package com.heleneharmens.app.model;

import java.util.Arrays;


public class Elevator {

    private enum MOVINGDIRECTION {
        NONE, UP, DOWN
    }

    private MOVINGDIRECTION direction = MOVINGDIRECTION.NONE;

    private String name;
    private int standbyFloor;
    private int currentFloor;

    private int destinationFloor;
    private int timeBetweenFloors = 5;

    private int[] destinationFloors;


    // CONSTRUCTORS

    public Elevator() {
        this.name = "ELE-XXX"; //TODO: Suggestion - Create a random initialized name
        this.standbyFloor = 1;
        this.currentFloor = 1;
    }

    public Elevator(String name, int standbyFloor) {
        this.name = name;
        this.standbyFloor = standbyFloor;
        this.currentFloor = standbyFloor; // sets current floor to standby floor
    }

    public Elevator(String name, int standbyFloor, int currentFloor) {
        this.name = name;
        this.currentFloor = currentFloor;
        this.standbyFloor = standbyFloor;
    }


    // SETTERS & GETTERS

    public MOVINGDIRECTION getDirection() {
        return direction;
    }

    public void setDirection(MOVINGDIRECTION direction) {
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStandbyFloor() {
        return standbyFloor;
    }

    public void setStandbyFloor(int standbyFloor) {
        this.standbyFloor = standbyFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int[] getDestinationFloors() {
        return destinationFloors;
    }

    public void setDestinationFloors(int[] destinationFloors) {
        this.destinationFloors = destinationFloors;
    }

    public int getTimeBetweenFloors() {
        return timeBetweenFloors;
    }

    public void setTimeBetweenFloors(int timeBetweenFloors) {
        this.timeBetweenFloors = timeBetweenFloors;
    }

    // OTHER METHODS

    // Push Internal Button inside the elevator, and go to the destination floor(s)
    public void pushInternalButton(int... destinationFloors){
        setDestinationFloors(destinationFloors);

        System.out.printf("Elevator %s Internal Button(s) pushed: %s \n", name, Arrays.toString(destinationFloors));

        moveToFloor(destinationFloors);

    }

    // Going through the destination floors selected and stopping at each one
    public void moveToFloor(int... destinationFloors) {

        for (int floor: destinationFloors) {
            setDestinationFloor(floor);

            if (floor > getCurrentFloor())
                moveElevator(MOVINGDIRECTION.UP, getDestinationFloor());
            else if (floor < getCurrentFloor())
                moveElevator(MOVINGDIRECTION.DOWN, getDestinationFloor());
            else
                System.out.printf("Elevator %s stands still on floor %d \n", name, getCurrentFloor());
        }
    }

    // Move elevator to next selected floor
    public void moveElevator(MOVINGDIRECTION movDir, int destFloor) {
        if (destFloor != getCurrentFloor()) {

            setDirection(movDir);

            displayETA(destFloor);

            System.out.printf("Elevator %s moving %s to floor %d \n", name, movDir, destFloor);

            // TODO: method to wait for elevator moving in real time

            setCurrentFloor(destFloor);
            stopElevator();

        } else {
            System.out.printf("Elevator %s is already on floor %d \n", name, destFloor);
        }
    }

    // Stopping elevator
    public void stopElevator(){
        setDirection(MOVINGDIRECTION.NONE);
        System.out.printf("Elevator %s has stopped at floor %d \n", name, getCurrentFloor());
    }

    // Stop elevator if Emergency Button is pushed
    public void emergencyStop(){
        setDirection(MOVINGDIRECTION.NONE);
        System.out.printf("Elevator %s Emergency Button pressed! Current floor is %d \n", name, getCurrentFloor());
    }

    // Calculate Estimated Time of Arrival (seconds)
    public int calculateETA(int selectedFloor) {
        int numFloors = 0;

        if (selectedFloor > getCurrentFloor())
            numFloors = selectedFloor-getCurrentFloor();
        else
            numFloors = getCurrentFloor()-selectedFloor;

        return numFloors * timeBetweenFloors;
    }

   //  Display Estimated Time of Arrival (seconds)
    public void displayETA(int selectedFloor) {

        System.out.printf("Elevator %s estimated time from current floor (%d) to chosen floor (%d): %d seconds\n",
                getName(), getCurrentFloor(), getDestinationFloor(), calculateETA(selectedFloor));

    }

    // print current status of elevator (name, current floor)
    public void displayElevatorStatus() {
        System.out.printf("ELEVATOR STATUS (%s): \n", getName());
        System.out.printf(  " Elevator Name: \t %s \n" +
                            " Standby Floor: \t %d \n" +
                            " Current Floor: \t %d \n",
                                getName(), getStandbyFloor(), getCurrentFloor());
    }


}
