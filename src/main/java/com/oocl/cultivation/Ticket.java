package com.oocl.cultivation;

public class Ticket {
    private String ID;
    private String carID;

    public Ticket(String ID, String carID) {
        this.ID = ID;
        this.carID = carID;
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
