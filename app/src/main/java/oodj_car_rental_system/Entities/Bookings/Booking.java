package oodj_car_rental_system.Entities.Bookings;

import oodj_car_rental_system.utils.PricingFactor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Booking {

    private int id;
    private int relatedToUser;

    private int relatedToCar;

    private LocalDateTime initiationDate;

    private LocalDateTime bookingStartDate;

    private LocalDateTime closingTime;

    private BookingStatus status;

    public void setBookingStartDate(LocalDateTime bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }

    public void setClosingTime(LocalDateTime closingTime) {
        this.closingTime = closingTime;
    }

    public Booking(int id, int relatedToUser, int relatedToCar, LocalDateTime initiationDate, LocalDateTime bookingStartDate, LocalDateTime closingTime, BookingStatus status) {
        this.id = id;
        this.relatedToUser = relatedToUser;
        this.relatedToCar = relatedToCar;
        this.initiationDate = initiationDate;
        this.bookingStartDate = bookingStartDate;
        this.closingTime = closingTime;
        this.status = status;
    }

    public int getRelatedToUser() {
        return relatedToUser;
    }

    public int getRelatedToCar() {
        return relatedToCar;
    }

    public LocalDateTime getInitiationDate() {
        return initiationDate;
    }

    public LocalDateTime getBookingStartDate() {
        return bookingStartDate;
    }

    public LocalDateTime getClosingTime() {
        return closingTime;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", relatedToUser=" + relatedToUser +
                ", relatedToCar=" + relatedToCar +
                ", initiationDate=" + initiationDate +
                ", bookingStartDate=" + bookingStartDate +
                ", closingTime=" + closingTime +
                ", status=" + status +
                '}';
    }

    public float calculateBookingPrice(float pricePerHour, PricingFactor factor) {
        if (factor.equals(PricingFactor.SECONDS)) {
            return getSeconds() * pricePerHour;
        }
        float result = getHours() * pricePerHour;
        if (result == 0f){
            return pricePerHour;
        }
        return  result;
    }

    private long getSeconds() {
        return ChronoUnit.SECONDS.between(this.bookingStartDate, this.closingTime);
    }

    private long getHours() {
        long hours = ChronoUnit.HOURS.between(this.bookingStartDate, this.closingTime);
        System.out.println(hours);
        return hours;
    }
}

