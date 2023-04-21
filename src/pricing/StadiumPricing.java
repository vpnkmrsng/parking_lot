package pricing;

import entity.ParkingTicket;
import entity.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class StadiumPricing implements PricingStrategy {
    @Override
    public int getPrice(ParkingTicket parkingTicket) {
        VehicleType vehicleType = parkingTicket.getVehicle().getVehicleType();
        long totalMinutes = ChronoUnit.MINUTES.between(parkingTicket.getEntryTime(), LocalDateTime.now());
        double totalHours = (double) (totalMinutes)/60;
        switch (vehicleType){
            case Motorcycle -> {
                if (totalHours >= 12){
                    return (int) ((Math.ceil(totalHours) - 12) * 100 + 60 + 30);
                }
                else if (totalHours >= 4){
                    return 60;
                }
                else {
                    return 30;
                }
            }
            case SUV -> {
                if (totalHours >= 12){
                    return (int) ((Math.ceil(totalHours) - 12) * 200 + 120 + 60);
                }
                else if (totalHours >= 4){
                    return 120 ;
                }
                else {
                    return 60;
                }
            }
            default -> {
                return 0;
            }
        }

    }
}
