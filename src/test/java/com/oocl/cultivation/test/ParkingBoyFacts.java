package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.FailMsg;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingBoyFacts {
    @Test
    void should_return_false_message_when_parking_null_car() {
        //given
        Car car = null;
        ParkingBoy parkingBoy = new ParkingBoy(1);
        //when
        Ticket result = parkingBoy.parking(car);
        //then
        assertEquals(null, result);
    }

    @Test
    void should_return_ticket_when_parking_succeed_given_car_parkingBoy() {
        //given
        Car car = new Car("1");
        ParkingBoy parkingBoy = new ParkingBoy(1);
        //when
        Ticket result = parkingBoy.parking(car);
        //then
        assertEquals(new Ticket("1", car.getID()).getID(), result.getID());
    }

    @Test
    void should_return_car_when_fetching_succeed_given_car_ParkingBoy() {
        //given
        Car car = new Car("1");
        ParkingBoy parkingBoy = new ParkingBoy(1);
        Ticket ticket = parkingBoy.parking(car);
        //when
        Car result = parkingBoy.fetching(ticket);
        //then
        assertEquals(new Car("1").getID(), result.getID());
    }

    @Test
    void should_return_no_car_when_fetching_given_wrong_ticket_parkingBoy() {
        //given
        Ticket ticket = new Ticket("999", "999");
        ParkingBoy parkingBoy = new ParkingBoy(999);
        //when
        Car result = parkingBoy.fetching(ticket);
        //then
        assertEquals(null, result);
    }

    @Test
    void should_return_no_car_when_fetching_given_used_ticket_parkingBoy() {
        //given
        Ticket ticket = new Ticket("999", "999");
        ParkingBoy parkingBoy = new ParkingBoy(999);
        //when
        Car result = parkingBoy.fetching(ticket);
        result = parkingBoy.fetching(ticket);
        //then
        assertEquals(null, result);
    }

    @Test
    void should_return_no_ticket_when_parking_given_car_parkingBoy_leftEquals_0() {
        //given
        Car car = new Car("1");
        Car car1 = new Car("2");
        Car car2 = new Car("3");
        Car car3 = new Car("4");
        Car car4 = new Car("5");
        Car car5 = new Car("6");
        Car car6 = new Car("7");
        Car car7 = new Car("8");
        Car car8 = new Car("9");
        Car car9 = new Car("10");
        Car car10 = new Car("11");
        ParkingBoy parkingBoy = new ParkingBoy(1);
        //when
        Ticket result = parkingBoy.parking(car);
        result = parkingBoy.parking(car1);
        result = parkingBoy.parking(car2);
        result = parkingBoy.parking(car3);
        result = parkingBoy.parking(car4);
        result = parkingBoy.parking(car5);
        result = parkingBoy.parking(car6);
        result = parkingBoy.parking(car7);
        result = parkingBoy.parking(car8);
        result = parkingBoy.parking(car9);
        result = parkingBoy.parking(car10);
        //then
        assertEquals(null, result);
    }

    @Test
    void should_return_msg_when_fetshing_given_wrong_ticket_parkingBoy() {
        //given
        Ticket ticket = null;
        ParkingBoy parkingBoy = new ParkingBoy(999);
        //when
        Car result = parkingBoy.fetching(ticket);
        //then
        String msg = "";
        if (result == null) {
            msg = parkingBoy.getFailMsg();
        }
        assertEquals("Unrecognized parking ticket.", msg);
    }
}
