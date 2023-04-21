package pricing;

import entity.ParkingTicket;
import entity.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AirportPricing implements PricingStrategy{
    @Override
    public int getPrice(ParkingTicket parkingTicket) {
        VehicleType vehicleType = parkingTicket.getVehicle().getVehicleType();
        long totalMinutes = ChronoUnit.MINUTES.between(parkingTicket.getEntryTime(), LocalDateTime.now());
        double totalHours = (double)(totalMinutes)/60;
        switch (vehicleType){
            case Motorcycle -> {
                int price = 0;
                double remainingHours =  totalHours % 24;
                if( totalHours > 24){
                    price += (Math.ceil (totalHours/24)) * 80;
                }
                else {
                    if(remainingHours >= 8){
                        price += 60;
                    }
                    else if(remainingHours >= 1){
                        price += 40;
                    }
                }
                return price;
            }
            case SUV -> {
                int price = 0;
                double remainingHours = totalHours % 24;
                if( totalHours > 24){
                    price += (Math.ceil (totalHours/24)) * 100;
                }
                else {
                    if(remainingHours >= 12){
                        price += 80;
                    }
                    else{
                        price += 60;
                    }
                }
                return price;
            }
            default -> {
                return 0;
            }
        }
    }
}
