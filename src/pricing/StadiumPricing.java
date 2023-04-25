package pricing;

import entity.ParkingTicket;
import entity.VehicleType;
import util.Constant;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class StadiumPricing implements PricingStrategy {

    @Override
    public int getPrice(ParkingTicket parkingTicket) {
        VehicleType vehicleType = parkingTicket.getVehicle().getVehicleType();
        long totalMinutes = ChronoUnit.MINUTES.between(parkingTicket.getEntryTime(), LocalDateTime.now());
        double totalHours = (double) (totalMinutes)/ Constant.MINUTES_IN_AN_HOUR;
        switch (vehicleType){
            case Motorcycle -> {
                return getMotorcyclePrice(totalHours);
            }
            case SUV -> {
                return getSuvPrice(totalHours);
            }
            default -> {
                return Constant.ZERO_RUPEES;
            }
        }

    }

    private int getMotorcyclePrice(double totalHours){
        if (totalHours >= Constant.TWELVE_HOURS){
            return (int) ((Math.ceil(totalHours) - Constant.TWELVE_HOURS) * Constant.HUNDRED_RUPEES + Constant.SIXTY_RUPEES + Constant.THIRTY_RUPEES);
        }
        else if (totalHours >= Constant.FOUR_HOURS){
            return Constant.SIXTY_RUPEES;
        }
        else {
            return Constant.THIRTY_RUPEES;
        }
    }

    private int getSuvPrice(double totalHours){
        if (totalHours >= Constant.TWELVE_HOURS){
            return (int) ((Math.ceil(totalHours) - Constant.TWELVE_HOURS) * Constant.TWO_HUNDRED_RUPEES + Constant.ONE_HUNDRED_TWENTY_RUPEES + Constant.SIXTY_RUPEES);
        }
        else if (totalHours >= Constant.FOUR_HOURS){
            return Constant.ONE_HUNDRED_TWENTY_RUPEES ;
        }
        else {
            return Constant.SIXTY_RUPEES;
        }
    }
}
