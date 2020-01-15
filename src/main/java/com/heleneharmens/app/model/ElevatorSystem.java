package com.heleneharmens.app.model;


public class ElevatorSystem {

    public enum DIRECTION {
        UP, DOWN
    }

    private DIRECTION direction;
    private int floorPushed;
    private Elevator[] elevators;


    // CONSTRUCTORS

    public ElevatorSystem(Elevator... elevators){
        setElevators(elevators);
    }


    // GETTERS & SETTERS

    public DIRECTION getDirection() {
        return direction;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }

    public int getFloorPushed() {
        return floorPushed;
    }

    public void setFloorPushed(int floorPushed) {
        this.floorPushed = floorPushed;
    }

    public Elevator[] getElevators() {
        return elevators;
    }

    public void setElevators(Elevator[] elevators) {
        this.elevators = elevators;
    }


    // OTHER METHODS

    // Push External Button outside the elevators, and get the closest elevator
    public void pushExternalButton(int originFloor, DIRECTION direction){
        System.out.println("External Button pushed ("+direction+") from floor "+originFloor);

        for (Elevator elevator: elevators) {
            int currentFloor = elevator.getCurrentFloor();

            // TODO: Change to get closest elevator, and not just exact
            if (currentFloor == originFloor) {
                System.out.printf("Elevator %s (%d) is closest! \n", elevator.getName(), elevator.getCurrentFloor());

                elevator.moveToFloor(originFloor);
            }
        }
    }


    // Display Elevators in the Elevator System
    public void displayElevators() {
        System.out.print("Elevators in ElevatorSystem: ");
        for (Elevator elevator: getElevators()) {
            System.out.printf("%s (at floor %d) ", elevator.getName(), elevator.getCurrentFloor());
        }
        System.out.println("\n");
    }


}
