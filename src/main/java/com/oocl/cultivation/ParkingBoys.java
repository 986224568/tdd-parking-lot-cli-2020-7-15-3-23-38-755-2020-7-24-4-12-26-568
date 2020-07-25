package com.oocl.cultivation;

import java.util.ArrayList;

public interface ParkingBoys {
    Ticket parking(Car car);
    Car fetching(Ticket ticket);
    String getFailMsg();
    public void addParkingLot();
}
