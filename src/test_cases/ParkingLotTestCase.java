package test_cases;

import entity.ParkingReceipt;
import entity.ParkingTicket;
import entity.Vehicle;
import entity.VehicleType;
import parking_lot.ParkingLot;
import org.junit.Test;
import pricing.AirportPricing;
import pricing.MallPricing;
import pricing.StadiumPricing;

public class ParkingLotTestCase {

    @Test
    public void test1() throws InterruptedException {
        Vehicle vehicle = new Vehicle(VehicleType.Motorcycle);
        ParkingLot parkingLot = ParkingLot.getInstance(new MallPricing(), 2, 2, 1);
        ParkingTicket parkingTicket = parkingLot.parkVehicle(vehicle);
        Thread.sleep(2000);
        ParkingReceipt parkingReceipt = parkingLot.unParkVehicle(parkingTicket);
        System.out.println(parkingReceipt);
    }

    @Test
    public void test2(){
        Vehicle vehicle1 = new Vehicle(VehicleType.Motorcycle);
        Vehicle vehicle2 = new Vehicle(VehicleType.Motorcycle);
        Vehicle vehicle3 = new Vehicle(VehicleType.Motorcycle);
        ParkingLot parkingLot = ParkingLot.getInstance(new StadiumPricing(), 2, 2, 1);
        ParkingTicket parkingTicket1 = parkingLot.parkVehicle(vehicle1);
        ParkingTicket parkingTicket2 = parkingLot.parkVehicle(vehicle2);
        ParkingTicket parkingTicket3 = parkingLot.parkVehicle(vehicle3);
        ParkingReceipt parkingReceipt1 = parkingLot.unParkVehicle(parkingTicket1);
        ParkingReceipt parkingReceipt2 = parkingLot.unParkVehicle(parkingTicket2);
        System.out.println(parkingReceipt1);
        System.out.println(parkingReceipt2);
    }

    @Test
    public void test3(){
        Vehicle vehicle1 = new Vehicle(VehicleType.SUV);
        ParkingLot parkingLot = ParkingLot.getInstance(new AirportPricing(), 2, 2, 1);
        ParkingTicket parkingTicket1 = parkingLot.parkVehicle(vehicle1);
        ParkingReceipt parkingReceipt1 = parkingLot.unParkVehicle(parkingTicket1);
        System.out.println(parkingReceipt1);
    }

}
