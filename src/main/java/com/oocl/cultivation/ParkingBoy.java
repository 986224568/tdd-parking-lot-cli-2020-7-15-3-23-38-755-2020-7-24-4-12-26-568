package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Random;

public class ParkingBoy extends ParkingWorkers {

    public int getId() {
        return id;
    }
    @Override
    public Ticket parking(Car car) {
        return super.parking(car);
    }
    @Override
    public Car fetching(Ticket ticket) {
        return super.fetching(ticket);
    }



    public ParkingBoy(int id) {
        super(id);
    }

    public String getFailMsg() {
        return super.getFailMsg();
    }

    public void addParkingLot(int maxNum) {
        super.addParkingLot(maxNum);
    }

}
