package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingLotManager implements ParkingWorkers{
    private int ID;
    private ArrayList<ParkingWorkers> parkingBoys;
    private ArrayList<ParkingLot> parkingLotList;


    public ParkingLotManager(int ID) {
        this.ID = ID;
        this.parkingBoys = new ArrayList<>();
        this.parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1, 10));
    }

    public void addParkingBoys(ParkingWorkers parkingBoy) {
        this.parkingBoys.add(parkingBoy);
    }

    public ArrayList<ParkingWorkers> getParkingBoys() {
        return parkingBoys;
    }

    @Override
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

    @Override
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

    @Override
    public String getFailMsg() {
        return FailMsg.FAIL_MSG.getMsg();
    }

    @Override
    public void addParkingLot() {
        parkingLotList.add(new ParkingLot(parkingLotList.size()+1, 10));
    }
}
