package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Random;

public abstract class ParkingWorkers {
    public int id;
    public ArrayList<ParkingLot> parkingLotList;
    public ArrayList<Observer> observerList;

    public void addObserver (Observer observer) {
        this.observerList.add(observer);
    }
    public ParkingWorkers(int id) {
        this.id = id;
        parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1, 10));
        observerList = new ArrayList<>();
    }

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
        notifyObserver("Not enough position.", this);
        return ticket;
    }
    public Car fetching(Ticket ticket) {
        Car car = null;
        if (ticket == null) {
            FailMsg.FAIL_MSG.setMsg("Please provide your parking ticket.");
            notifyObserver("Please provide your parking ticket.", this);
            return car;
        }
        if (!ticket.isValid() || ticket.getState() == TicketState.usedTicket.getIndex()) {
            FailMsg.FAIL_MSG.setMsg("Unrecognized parking ticket.");
            notifyObserver("Unrecognized parking ticket.", this);
            return car;
        }
        //ParkingLot parkingLot = parkingLotList.stream()
        for (ParkingLot parkingLot : parkingLotList) {
            if (ticket.getParkingLotID() == parkingLot.getID()) {
                if (parkingLot.getCarByID(ticket.getCarID()).getState() == CarState.parkedCar.getIndex()) {
                    car = parkingLot.fetching(ticket);
                    ticket.setState(TicketState.usedTicket.getIndex());
                    return car;
                }
            }
        }

        return car;
    }

    public String getFailMsg() {
        return FailMsg.FAIL_MSG.getMsg();
    }

    public void addParkingLot(int maxNum) {
        parkingLotList.add(new ParkingLot(parkingLotList.size() + 1, maxNum));
    }

    public int getId() {
        return this.id;
    }

    public void notifyObserver(String msg, ParkingWorkers parkingWorkers) {
        for(Observer observer : this.observerList) {
            observer.update(msg, parkingWorkers);
        }
    }
}
