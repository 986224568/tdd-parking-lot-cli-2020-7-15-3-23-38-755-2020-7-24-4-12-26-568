package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<Car> carList;
    private static int maxNum;

    public ParkingLot() {
        carList = new ArrayList<>();
        maxNum = 10;
    }

    public void parking(Car car) {
        if (car != null && car.getState() == State.notParkedCar.getIndex() && maxNum < 10) {
            carList.add(car);
            maxNum--;
        }
    }

    public Car fetching(Ticket ticket) {
        Car car = null;
        return car;
    }

    public static int getMaxNum() {
        return maxNum;
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
