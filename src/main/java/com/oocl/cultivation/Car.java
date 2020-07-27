package com.oocl.cultivation;

public class Car {
    private String ID;
    private int state;

    public String getID() {
        return ID;
    }

    public Car(String ID) {
        this.ID = ID;
        this.state = CarState.notParkedCar.getIndex();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
