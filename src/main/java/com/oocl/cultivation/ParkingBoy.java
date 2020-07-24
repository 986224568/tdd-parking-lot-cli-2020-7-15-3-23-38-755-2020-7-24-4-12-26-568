package com.oocl.cultivation;

import java.util.Random;

public class ParkingBoy {
    private int id;


    public Ticket parking(Car car) {
        Ticket ticket = null;
        if (car == null) {
            return ticket;
        }
        ticket = new Ticket(car.getID(), car.getID());
        return ticket;
    }

    public String randomPassword() {
        char[] chars = new char[6];
        Random rnd = new Random();
        for (int i = 0; i < 6; i++) {
            chars[i] = (char) ('0' + rnd.nextInt(10));
        }
        return new String(chars);
    }
}
