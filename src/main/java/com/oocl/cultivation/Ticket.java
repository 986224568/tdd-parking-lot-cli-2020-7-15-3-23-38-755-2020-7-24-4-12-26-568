package com.oocl.cultivation;

public class Ticket {
    private String ID;
    private String CarID;

    public Ticket(String ID, String carID) {
        this.ID = ID;
        CarID = carID;
    }

    public String getID() {
        return ID;
    }
}
