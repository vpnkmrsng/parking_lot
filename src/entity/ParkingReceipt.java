package entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingReceipt {
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private int price;
    private String receiptId;

    public ParkingReceipt(LocalDateTime entryTime, int price) {
        this.exitTime = LocalDateTime.now();
        this.entryTime = entryTime;
        this.price = price;
        this.receiptId = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "ParkingReceipt{" +
                "entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", price=" + price +
                ", receiptId='" + receiptId + '\'' +
                '}';
    }
}
