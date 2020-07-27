package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<Car> carList;
    private int left;
    private int maxNum;
    private int ID;

    public ParkingLot(int ID, int maxNum) {
        this.ID = ID;
        this.carList = new ArrayList<>();
        this.left = maxNum;
        this.maxNum = maxNum;
    }



    public void parking(Car car) {
        if (car != null && car.getState() == CarState.notParkedCar.getIndex() && left > 0) {
            carList.add(car);
            car.setState(CarState.parkedCar.getIndex());
            left--;
        }
    }


    public Car fetching(Ticket ticket) {
        Car car = null;
        if (ticket != null) {
            car = carList.stream()
                    .filter(e -> e.getID().equals(ticket.getCarID()))
                    .findFirst()
                    .get();
            left++;
        }
        return car;
    }


    public int getMaxNum() {
        return maxNum;
    }

    public int getLeft() {
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
