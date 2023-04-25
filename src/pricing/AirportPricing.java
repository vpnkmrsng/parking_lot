package pricing;

import entity.ParkingTicket;
import entity.VehicleType;
import util.Constant;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AirportPricing implements PricingStrategy{
    @Override
    public int getPrice(ParkingTicket parkingTicket) {
        VehicleType vehicleType = parkingTicket.getVehicle().getVehicleType();
        long totalMinutes = ChronoUnit.MINUTES.between(parkingTicket.getEntryTime(), LocalDateTime.now());
        double totalHours = (double)(totalMinutes)/ Constant.MINUTES_IN_AN_HOUR;
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
        int price = Constant.ZERO_RUPEES;
        double remainingHours =  totalHours % Constant.HOURS_IN_A_DAY;
        if( totalHours > Constant.HOURS_IN_A_DAY){
            price += (Math.ceil (totalHours/Constant.HOURS_IN_A_DAY)) * Constant.EIGHTY_RUPEES;
        }
        else {
            if(remainingHours >= Constant.EIGHT_HOURS){
                price += Constant.SIXTY_RUPEES;
            }
            else if(remainingHours >= Constant.ONE_HOUR){
                price += Constant.FORTY_RUPEES;
            }
        }
        return price;
    }

    private int getSuvPrice( double totalHours){
        int price = Constant.ZERO_RUPEES;
        double remainingHours = totalHours % Constant.HOURS_IN_A_DAY;
        if( totalHours > Constant.HOURS_IN_A_DAY){
            price += (Math.ceil (totalHours/Constant.HOURS_IN_A_DAY)) * Constant.HUNDRED_RUPEES;
        }
        else {
            if(remainingHours >= Constant.TWELVE_HOURS){
                price += Constant.EIGHTY_RUPEES;
            }
            else{
                price += Constant.SIXTY_RUPEES;
            }
        }
        return price;
    }
}
