package com.oocl.cultivation;

import java.util.Random;

public class ParkingBoy {
    private int id;
    private ParkingLot parkingLot;


    public Ticket parking(Car car) {
        Ticket ticket = null;
        if (car == null || parkingLot.getMaxNum() > 10) {
            return ticket;
        }
        ticket = new Ticket(car.getID(), car.getID());
        parkingLot.parking(car);
        return ticket;
    }

    public Car fetching(Ticket ticket) {
        Car car = null;
        if (parkingLot.getCarByID(ticket.getCarID()).getState() == State.parkedCar.getIndex()) {
            car = parkingLot.fetching(ticket, this);
            return car;
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
        parkingLot = new ParkingLot();
    }
}
