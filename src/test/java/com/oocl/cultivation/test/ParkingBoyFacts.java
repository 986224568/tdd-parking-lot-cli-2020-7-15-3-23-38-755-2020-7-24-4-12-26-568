package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingBoyFacts { ;
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
        assertEquals(new Ticket("1", car.getID(),1).getID(), result.getID());
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
        Ticket ticket = new Ticket("999", "999", 999);
        ParkingBoy parkingBoy = new ParkingBoy(999);
        //when
        Car result = parkingBoy.fetching(ticket);
        //then
        assertEquals(null, result);
    }

    @Test
    void should_return_no_car_when_fetching_given_used_ticket_parkingBoy() {
        //given
        Ticket ticket = new Ticket("999", "999", 999);
        ParkingBoy parkingBoy = new ParkingBoy(999);
        //when
        parkingBoy.fetching(ticket);
        Car result = parkingBoy.fetching(ticket);
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
    void should_return_msg_when_fetching_given_wrong_ticket_parkingBoy() {
        //given
        Ticket ticket = new Ticket("999", "999", 999);
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

    @Test
    void should_return_msg_when_fetching_given_used_ticket_parkingBoy() {
        //given
        Car car = new Car("1");
        ParkingBoy parkingBoy = new ParkingBoy(999);
        Ticket ticket = parkingBoy.parking(car);
        //when
        Car result = parkingBoy.fetching(ticket);
        result = parkingBoy.fetching(ticket);
        //then
        String msg = "";
        if (result == null) {
            msg = parkingBoy.getFailMsg();
        }
        assertEquals("Unrecognized parking ticket.", msg);
    }

    @Test
    void should_return_msg_when_fetching_with_no_ticket() {
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
        assertEquals("Please provide your parking ticket.", msg);
    }

    @Test
    void should_return_msg_when_parking_given_car_parkingBoy_with_no_position() {
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
        String msg = "";
        if (result == null) {
            msg = parkingBoy.getFailMsg();
        }
        assertEquals("Not enough position.", msg);
    }

    @Test
    void should_return_new_parking_lotID_when_parking_more_than_one_lot_given_car_parkingBoy() {
        //given          //TODO
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
        parkingBoy.addParkingLot(10);
        //when   //TODO
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
        assertEquals(2, result.getParkingLotID());
    }

    @Test
    void should_return_car_when_parking_more_than_one_lot_given_car_parkingBoy() {
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
        parkingBoy.addParkingLot(10);
        //when
        Ticket ticket = parkingBoy.parking(car);
        ticket = parkingBoy.parking(car1);
        ticket = parkingBoy.parking(car2);
        ticket = parkingBoy.parking(car3);
        ticket = parkingBoy.parking(car4);
        ticket = parkingBoy.parking(car5);
        ticket = parkingBoy.parking(car6);
        ticket = parkingBoy.parking(car7);
        ticket = parkingBoy.parking(car8);
        ticket = parkingBoy.parking(car9);
        ticket = parkingBoy.parking(car10);
        Car car11 = parkingBoy.fetching(ticket);
        //then
        assertEquals(car10, car11);
    }

    @Test
    void should_use_more_position_lot_when_parking_given_cars_smartParkingBoy() {
        //given
        Car car = new Car("1");
        Car car1 = new Car("2");
        SuperSmartParkingBoy smartParkingBoy = new SuperSmartParkingBoy(1);
        smartParkingBoy.addParkingLot(10);
        //when
        Ticket result = smartParkingBoy.parking(car);
        result = smartParkingBoy.parking(car1);
        //then
        assertEquals(2, result.getParkingLotID());
    }

    @Test
    void should_return_car_when_use_more_lot_parking_given_cars_smartParkingBoy() {
        //given
        Car car = new Car("1");
        Car car1 = new Car("2");
        SuperSmartParkingBoy smartParkingBoy = new SuperSmartParkingBoy(1);
        smartParkingBoy.addParkingLot(10);
        //when
        Ticket ticket = smartParkingBoy.parking(car);
        ticket = smartParkingBoy.parking(car1);
        Car car3 = smartParkingBoy.fetching(ticket);
        //then
        assertEquals(car1, car3);
    }

    @Test
    void should_use_more_position_lot_when_parking_given_cars_superSmartParkingBoy() {
        //given
        Car car = new Car("1");
        Car car1 = new Car("2");
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(1);
        superSmartParkingBoy.addParkingLot(10);
        //when
        Ticket result = superSmartParkingBoy.parking(car);
        result = superSmartParkingBoy.parking(car1);
        //then
        assertEquals(2, result.getParkingLotID());
    }

    @Test
    void should_return_car_when_use_more_lot_parking_given_cars_superSmartParkingBoy() {
        //given
        Car car = new Car("1");
        Car car1 = new Car("2");
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(1);
        superSmartParkingBoy.addParkingLot(10);
        //when
        Ticket ticket = superSmartParkingBoy.parking(car);
        ticket = superSmartParkingBoy.parking(car1);
        Car car3 = superSmartParkingBoy.fetching(ticket);
        //then
        assertEquals(car1, car3);
    }

    @Test
    void should_return_listSize_when_add_parkingBoy_to_managementlist_of_manager_given_manager_parkingBoy() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(1);
        ParkingLotManager parkingLotManager = new ParkingLotManager(1);
        //when
        parkingLotManager.addParkingBoys(superSmartParkingBoy);
        //then
        assertEquals(1, parkingLotManager.getParkingBoys().size());
    }

    @Test
    void should_return_ticket_when_parking_given_manager_car() {
        //given
        ParkingLotManager parkingLotManager = new ParkingLotManager(1);
        Car car = new Car("1");
        //when
        Ticket ticket = parkingLotManager.parking(car);
        //then
        assertEquals("1", ticket.getCarID());
    }

    @Test
    void should_return_msg_when_fetching_given_wrong_ticket_manager() {
        //given
        Ticket ticket = new Ticket("999", "999", 999);
        ParkingLotManager parkingLotManager = new ParkingLotManager(999);
        //when
        Car result = parkingLotManager.fetching(ticket);
        //then
        String msg = "";
        if (result == null) {
            msg = parkingLotManager.getFailMsg();
        }
        assertEquals("Unrecognized parking ticket.", msg);
    }

    @Test
    void should_return_msg_when_parking_given_car_manager_with_no_position() {
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
        String msg = "";
        if (result == null) {
            msg = parkingBoy.getFailMsg();
        }
        assertEquals("Not enough position.", msg);
    }

    @Test
    void should_return_msg_when_fetching_with_no_ticket_given_car_manager() {
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
        assertEquals("Please provide your parking ticket.", msg);
    }

    @Test
    void should_return_new_parking_lotID_when_parking_more_than_one_lot_given_car_manager() {
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
        ParkingLotManager parkingLotManager = new ParkingLotManager(1);
        parkingLotManager.addParkingLot(10);
        //when
        Ticket result = parkingLotManager.parking(car);
        result = parkingLotManager.parking(car1);
        result = parkingLotManager.parking(car2);
        result = parkingLotManager.parking(car3);
        result = parkingLotManager.parking(car4);
        result = parkingLotManager.parking(car5);
        result = parkingLotManager.parking(car6);
        result = parkingLotManager.parking(car7);
        result = parkingLotManager.parking(car8);
        result = parkingLotManager.parking(car9);
        result = parkingLotManager.parking(car10);
        //then
        assertEquals(2, result.getParkingLotID());
    }

    @Test
    void should_return_car_when_parking_more_than_one_lot_given_car_manager() {
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
        ParkingLotManager parkingLotManager = new ParkingLotManager(1);
        parkingLotManager.addParkingLot(10);
        //when
        Ticket ticket = parkingLotManager.parking(car);
        ticket = parkingLotManager.parking(car1);
        ticket = parkingLotManager.parking(car2);
        ticket = parkingLotManager.parking(car3);
        ticket = parkingLotManager.parking(car4);
        ticket = parkingLotManager.parking(car5);
        ticket = parkingLotManager.parking(car6);
        ticket = parkingLotManager.parking(car7);
        ticket = parkingLotManager.parking(car8);
        ticket = parkingLotManager.parking(car9);
        ticket = parkingLotManager.parking(car10);
        Car car11 = parkingLotManager.fetching(ticket);
        //then
        assertEquals(car10, car11);
    }

    @Test
    void should_return_msg_when_fetching_with_no_ticket_given_car_manager_parkingBoy() {
        //given
        Ticket ticket = null;
        ParkingBoy parkingBoy = new ParkingBoy(999);
        ParkingLotManager parkingLotManager = new ParkingLotManager(1);
        parkingLotManager.addParkingBoys(parkingBoy);
        //when
        Car result = parkingBoy.fetching(ticket);
        //then
        assertEquals(parkingBoy.getId() + "Please provide your parking ticket.", FailMsg.MANAGER_MSG.getMsg());

    }

    @Test
    void should_return_msg_when_parking_given_car_parkingBoy_manager_with_no_position() {
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
        ParkingLotManager parkingLotManager = new ParkingLotManager(1);
        parkingLotManager.addParkingBoys(parkingBoy);
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
        assertEquals(parkingBoy.getId() + "Not enough position.", FailMsg.MANAGER_MSG.getMsg());
    }

    @Test
    void should_return_msg_when_fetshing_given_wrong_ticket_parkingBoy_manager() {
        //given
        Ticket ticket = new Ticket("999", "999", 999);
        ParkingLotManager parkingLotManager = new ParkingLotManager(999);
        ParkingBoy parkingBoy = new ParkingBoy(999);
        parkingLotManager.addParkingBoys(parkingBoy);
        //when
        Car result = parkingBoy.fetching(ticket);
        //then
        assertEquals(parkingBoy.getId() + "Unrecognized parking ticket.", FailMsg.MANAGER_MSG.getMsg());
    }

}
