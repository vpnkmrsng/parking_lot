package parking_lot;

import entity.*;
import pricing.PricingStrategy;
import spot_manager.ParkingSpotManager;
import spot_manager.ParkingSpotManagerFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private static ParkingLot parkingLot;
    private final PricingStrategy pricingStrategy;
    private List<ParkingSpot> motorCycleParkingSpotList;
    private List<ParkingSpot> suvParkingSpotList;
    private List<ParkingSpot> busParkingSpotList;
    private final Map<VehicleType, Integer> availableSpotCount;

    public static ParkingLot getInstance(PricingStrategy pricingStrategy, int motorcycleSpots, int suvSpots, int busSpots){
        if(parkingLot == null){
            parkingLot = new ParkingLot(pricingStrategy,motorcycleSpots,suvSpots,busSpots);
        }
        return parkingLot;
    }


    private ParkingLot(PricingStrategy pricingStrategy, int motorcycleSpots, int suvSpots, int busSpots){
        this.pricingStrategy = pricingStrategy;
        availableSpotCount = new HashMap<>();
        availableSpotCount.put(VehicleType.Motorcycle, motorcycleSpots);
        availableSpotCount.put(VehicleType.SUV, suvSpots);
        availableSpotCount.put(VehicleType.Bus, busSpots);
        if(motorcycleSpots > 0){
            motorCycleParkingSpotList = new ArrayList<>();
            for(int i=0; i< motorcycleSpots; i++){
                motorCycleParkingSpotList.add(new ParkingSpot(VehicleType.Motorcycle));
            }
        }
        if(suvSpots > 0){
            suvParkingSpotList = new ArrayList<>();
            for(int i=0; i< suvSpots; i++){
                suvParkingSpotList.add(new ParkingSpot(VehicleType.SUV));
            }
        }
        if(busSpots > 0){
            busParkingSpotList = new ArrayList<>();
            for(int i=0; i< busSpots; i++){
                busParkingSpotList.add(new ParkingSpot(VehicleType.Bus));
            }
        }

    }
    public ParkingReceipt unParkVehicle(ParkingTicket parkingTicket) {
        parkingTicket.getParkingSpot().unParkVehicle();
        availableSpotCount.put(parkingTicket.getVehicle().getVehicleType(), availableSpotCount.get(parkingTicket.getVehicle().getVehicleType()) +1);
        return new ParkingReceipt(parkingTicket.getEntryTime(), pricingStrategy.getPrice(parkingTicket));
    }

    public ParkingTicket parkVehicle(Vehicle vehicle){
        if (availableSpotCount.get(vehicle.getVehicleType()) <= 0){
            System.out.println("No space available");
            return null;
        }
        ParkingSpotManager parkingSpotManager = ParkingSpotManagerFactory
                .getParkingSpotManager(vehicle.getVehicleType(), getParkingSpotList(vehicle.getVehicleType()));
        ParkingSpot parkingSpot= parkingSpotManager.findParkingSpace();
        parkingSpot.parkVehicle(vehicle);
        availableSpotCount.put(vehicle.getVehicleType(), availableSpotCount.get(vehicle.getVehicleType())-1);
        return new ParkingTicket(parkingSpot, LocalDateTime.now(), vehicle);
    }

    private List<ParkingSpot> getParkingSpotList(VehicleType vehicleType){
        switch (vehicleType){
            case Motorcycle -> {
                return motorCycleParkingSpotList;
            }
            case SUV -> {
                return suvParkingSpotList;
            }
            case Bus -> {
                return busParkingSpotList;
            }
            default -> {
                return null;
            }
        }
    }

}
