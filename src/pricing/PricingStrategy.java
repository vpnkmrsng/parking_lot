package pricing;

import entity.ParkingTicket;

public interface PricingStrategy {
    int getPrice(ParkingTicket parkingTicket);
}
