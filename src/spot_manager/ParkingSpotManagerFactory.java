package spot_manager;

import entity.ParkingSpot;
import entity.VehicleType;

import java.util.List;

public class ParkingSpotManagerFactory {

    public static ParkingSpotManager getParkingSpotManager(VehicleType vehicleType, List<ParkingSpot> parkingSpotList){
        switch (vehicleType){
            case Motorcycle -> {
                return new MotorCycleParkingSpotManager(parkingSpotList);
            }
            case SUV -> {
                return new SUVParkingSpotManager(parkingSpotList);
            }
            case Bus -> {
                return new BusParkingSpotManager(parkingSpotList);
            }
            default -> {
                return null;
            }
        }
    }
}
