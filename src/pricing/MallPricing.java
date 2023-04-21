package pricing;

import entity.ParkingTicket;
import entity.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MallPricing implements PricingStrategy {
    @Override
    public int getPrice(ParkingTicket parkingTicket) {
        VehicleType vehicleType = parkingTicket.getVehicle().getVehicleType();
        long totalMinutes = ChronoUnit.MINUTES.between(parkingTicket.getEntryTime(), LocalDateTime.now());
        double totalHours = Math.ceil((double) (totalMinutes)/60);

        switch (vehicleType){
            case Motorcycle -> {
                return (int) (totalHours * 10);
            }
            case SUV -> {
                return (int) totalHours * 20;
            }
            case Bus -> {
                return (int) totalHours * 50;
            }
            default -> {
                return 0;
            }
        }
    }
}
