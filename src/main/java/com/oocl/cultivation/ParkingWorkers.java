package com.oocl.cultivation;

import java.util.ArrayList;

public interface ParkingWorkers {
    Ticket parking(Car car);
    Car fetching(Ticket ticket);
    String getFailMsg();
    void addParkingLot();
}
