package pricing;

import entity.ParkingTicket;
import entity.VehicleType;
import util.Constant;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MallPricing implements PricingStrategy {
    @Override
    public int getPrice(ParkingTicket parkingTicket) {
        VehicleType vehicleType = parkingTicket.getVehicle().getVehicleType();
        long totalMinutes = ChronoUnit.MINUTES.between(parkingTicket.getEntryTime(), LocalDateTime.now());
        double totalHours = Math.ceil((double) (totalMinutes)/Constant.MINUTES_IN_AN_HOUR);

        switch (vehicleType){
            case Motorcycle -> {
                return (int) (totalHours * Constant.TEN_RUPEES);
            }
            case SUV -> {
                return (int) totalHours * Constant.TWENTY_RUPEES;
            }
            case Bus -> {
                return (int) totalHours * Constant.FIFTY_RUPEES;
            }
            default -> {
                return Constant.ZERO_RUPEES;
            }
        }
    }
}
