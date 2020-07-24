package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingBoyFacts {
    @Test
    void should_return_false_message_when_parking_null_car() {
        //given
        Car car = null;
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        String result = parkingBoy.parking(car);
        //then
        assertEquals("car is null",result);
    }
}
