package com.oocl.cultivation;

public class Car {
    private String ID;
    private int state;

    public String getID() {
        return ID;
    }

    public Car(String ID) {
        this.ID = ID;
        this.state = 0;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
