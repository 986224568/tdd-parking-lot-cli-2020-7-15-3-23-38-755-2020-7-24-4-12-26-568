package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Random;

public class SmartParkingBoy extends ParkingWorkers {
    public Ticket parking(Car car) {
        Ticket ticket = null;
        if (car == null) {
            FailMsg.FAIL_MSG.setMsg("no car");
            return ticket;
        }
        ParkingLot parkingLot = null;
        int max = 0;
        for (ParkingLot parkingLot1 : parkingLotList) {
            if (parkingLot1.getLeft() > max) {
                max = parkingLot1.getLeft();
                parkingLot = parkingLot1;
            }
        }
        if (parkingLot.getLeft() > 0) {
            ticket = new Ticket(car.getID(), car.getID(), parkingLot.getID());
            parkingLot.parking(car);
            return ticket;
        }

        FailMsg.FAIL_MSG.setMsg("Not enough position.");
        return ticket;
    }
    public SmartParkingBoy(int id) {
        super(id);
    }
}
