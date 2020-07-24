package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingBoyFacts {
    @Test
    void should_return_false_message_when_parking_null_car() {
        //given
        Car car = null;
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Ticket result = parkingBoy.parking(car);
        //then
        assertEquals(null, result);
    }

    @Test
    void should_return_ticket_when_parking_succeed() {
        //given
        Car car = new Car("1");
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Ticket result = parkingBoy.parking(car);
        //then
        assertEquals(new Ticket("1", "1").getID(), result.getID());
    }

}
