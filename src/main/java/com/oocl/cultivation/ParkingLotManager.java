package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingLotManager extends ParkingWorkers implements Observer{
    private ArrayList<ParkingWorkers> parkingBoys;

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

    @Override
    public void update(String msg, ParkingWorkers parkingWorkers) {
        FailMsg.MANAGER_MSG.setMsg(parkingWorkers.getId() + msg);
    }
}
