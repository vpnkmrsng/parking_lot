package entity;

import java.util.UUID;

public class Vehicle {
    private String vehicleNo;
    private VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType) {
        this.vehicleNo = UUID.randomUUID().toString();
        this.vehicleType = vehicleType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
