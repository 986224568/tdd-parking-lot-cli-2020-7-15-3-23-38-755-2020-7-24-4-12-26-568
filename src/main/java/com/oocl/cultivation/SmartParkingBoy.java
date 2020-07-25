package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

public class SmartParkingBoy {
    private int id;
    private ArrayList<ParkingLot> parkingLotList;


    public Ticket parking(Car car) {
        Ticket ticket = null;
        if (car == null) {
            FailMsg.FAIL_MSG.setMsg("no car");
            return ticket;
        }
        ParkingLot parkingLot = null;
        int max = 0;
        for (ParkingLot parkingLot1 : parkingLotList) {
            if (parkingLot1.getMaxNum() > max) {
                max = parkingLot1.getMaxNum();
                parkingLot = parkingLot1;
            }
        }
        if (parkingLot.getMaxNum() > 0) {
            ticket = new Ticket(car.getID(), car.getID(), parkingLot.getID());
            parkingLot.parking(car);
            return ticket;
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
                    car = parkingLot.fetching(ticket, this);
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

    public SmartParkingBoy(int id) {
        this.id = id;
        parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
    }

    public String getFailMsg() {
        return FailMsg.FAIL_MSG.getMsg();
    }

    public void addParkingLot() {
        parkingLotList.add(new ParkingLot(parkingLotList.size()+1));
    }
}