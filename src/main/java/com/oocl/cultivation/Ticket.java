package com.oocl.cultivation;

public class Ticket {
    private String ID;
    private String carID;
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Ticket(String ID, String carID) {
        this.ID = ID;
        this.carID = carID;
        this.state = State.notUsedTicket.getIndex();
    }

    public String getID() {
        return ID;
    }

    public String getCarID() {
        return carID;
    }

    public boolean isValid() {
        return this.ID.length() < 2;
    }
}
