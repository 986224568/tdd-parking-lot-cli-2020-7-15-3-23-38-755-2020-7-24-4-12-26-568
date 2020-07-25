package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingLotManager {
    private int ID;
    private ArrayList<ParkingBoys> parkingBoys;

    public ParkingLotManager(int ID) {
        this.ID = ID;
        this.parkingBoys = new ArrayList<>();
    }

    public void addParkingBoys(ParkingBoys parkingBoy) {
        this.parkingBoys.add(parkingBoy);
    }

    public ArrayList<ParkingBoys> getParkingBoys() {
        return parkingBoys;
    }
}
