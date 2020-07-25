package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Random;

public class ParkingBoy implements ParkingBoys {
    private int id;
    private ArrayList<ParkingLot> parkingLotList;


    public Ticket parking(Car car) {
        Ticket ticket = null;
        if (car == null) {
            FailMsg.FAIL_MSG.setMsg("no car");
            return ticket;
        }
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getLeft() > 0) {
                ticket = new Ticket(car.getID(), car.getID(), parkingLot.getID());
                parkingLot.parking(car);
                return ticket;
            }
        }
        FailMsg.FAIL_MSG.setMsg("Not enough position.");
        return ticket;
    }

    public Car fetching(Ticket ticket) {
        Car car = null;
        if (ticket == null) {
            FailMsg.FAIL_MSG.setMsg("Please provide your parking ticket.");
            return car;
        }
        if (!ticket.isValid()) {
            FailMsg.FAIL_MSG.setMsg("Unrecognized parking ticket.");
        }
        if (ticket.getState() == State.usedTicket.getIndex()) {
            FailMsg.FAIL_MSG.setMsg("Unrecognized parking ticket.");
            return car;
        }
        for (ParkingLot parkingLot : parkingLotList) {
            if (ticket.getParkingLotID() == parkingLot.getID()) {
                if (parkingLot.getCarByID(ticket.getCarID()).getState() == State.parkedCar.getIndex()) {
                    car = parkingLot.fetching(ticket);
                    ticket.setState(State.usedTicket.getIndex());
                    return car;
                }
            }
        }

        return car;
    }

    public String randomPassword() {
        char[] chars = new char[6];
        Random rnd = new Random();
        for (int i = 0; i < 6; i++) {
            chars[i] = (char) ('0' + rnd.nextInt(10));
        }
        return new String(chars);
    }

    public ParkingBoy(int id) {
        this.id = id;
        parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1, 10));
    }

    public String getFailMsg() {
        return FailMsg.FAIL_MSG.getMsg();
    }

    public void addParkingLot() {
        parkingLotList.add(new ParkingLot(parkingLotList.size()+1, 10));
    }
}
