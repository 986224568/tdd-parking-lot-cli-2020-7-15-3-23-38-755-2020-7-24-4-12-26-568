package com.oocl.cultivation;

public class Ticket {
    private String ID;
    private String carID;
    private int state;
    private int ParkingLotID;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Ticket(String ID, String carID, int ParkingLotID) {
        this.ID = ID;
        this.carID = carID;
        this.state = TicketState.notUsedTicket.getIndex();
        this.ParkingLotID = ParkingLotID;
    }

    public String getID() {
        return ID;
    }

    public String getCarID() {
        return carID;
    }

    public boolean isValid() {
        return this.ID.length() <= 2;
    }

    public int getParkingLotID() {
        return ParkingLotID;
    }

    public void setParkingLotID(int parkingLotID) {
        ParkingLotID = parkingLotID;
    }
}
