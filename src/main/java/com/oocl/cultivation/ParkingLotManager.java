package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingLotManager extends ParkingWorkers implements Observer{
    private ArrayList<ParkingWorkers> parkingBoys;


    @Override
    public int getId() {
        return id;
    }

    public ParkingLotManager(int ID) {
        super(ID);
        this.parkingBoys = new ArrayList<>();
    }

    public void addParkingBoys(ParkingWorkers parkingBoy) {
        this.parkingBoys.add(parkingBoy);
        parkingBoy.addObserver(this);
    }

    public ArrayList<ParkingWorkers> getParkingBoys() {
        return parkingBoys;
    }


    public Ticket parking(Car car) {
        return super.parking(car);
    }

    @Override
    public Car fetching(Ticket ticket) {
        return super.fetching(ticket);
    }

    @Override
    public String getFailMsg() {
        return super.getFailMsg();
    }


    public void addParkingLot(int maxNum) {
        super.addParkingLot(maxNum);
    }

    @Override
    public void update(String msg, ParkingWorkers parkingWorkers) {
        FailMsg.MANAGER_MSG.setMsg(parkingWorkers.getId() + msg);
    }
}
