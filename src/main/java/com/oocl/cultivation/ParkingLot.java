package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<Car> carList;
    private static int left;

    public ParkingLot() {
        carList = new ArrayList<>();
        left = 10;
    }

    public void parking(Car car) {
        if (car != null && car.getState() == State.notParkedCar.getIndex() && left > 0) {
            carList.add(car);
            car.setState(State.parkedCar.getIndex());
            left--;
        }
    }

    public Car fetching(Ticket ticket, ParkingBoy parkingBoy) {
        Car car = null;
        if (ticket != null && ticket.isValid()) {
            for (Car car1 : carList) {
                if (car1.getID() == ticket.getCarID()) {
                    car = car1;
                    break;
                }
            }
            left++;
        }
        return car;
    }

    public static int getMaxNum() {
        return left;
    }

    public Car getCarByID(String id) {
        for (Car car : carList) {
            if (car.getID() == id) {
                return car;
            }
        }
        return null;
    }
}
