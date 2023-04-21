package entity;

import java.util.UUID;

public class ParkingSpot {
    private String parkingSpotId;
    private boolean isAvailable;
    private Vehicle vehicle;
    private VehicleType vehicleType;

    public ParkingSpot(VehicleType vehicleType) {
        this.parkingSpotId = UUID.randomUUID().toString();
        this.vehicleType = vehicleType;
        this.isAvailable = true;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void parkVehicle(Vehicle vehicle){
        this.isAvailable = false;
        this.vehicle = vehicle;
    }

    public void unParkVehicle(){
        this.isAvailable = true;
        this.vehicle = null;
    }
}
