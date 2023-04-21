package spot_manager;

import entity.ParkingSpot;
import java.util.List;

public class ParkingSpotManager {
    protected List<ParkingSpot> parkingSpotList;

    public ParkingSpotManager(List<ParkingSpot> parkingSpotList){
        this.parkingSpotList = parkingSpotList;
    }

    public ParkingSpot findParkingSpace(){
        for (ParkingSpot parkingSpot: parkingSpotList){
            if(parkingSpot.isAvailable())
                return parkingSpot;
        }
        return null;
    }

    public void addParkingSpace(){

    }

    public void removeParkingSpot(){

    }

    public void parkVehicle(){

    }

    public void unParkVehicle(){

    }
}
