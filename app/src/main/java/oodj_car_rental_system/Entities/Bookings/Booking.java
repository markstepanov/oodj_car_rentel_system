package oodj_car_rental_system.Entities.Bookings;

import java.time.LocalDateTime;

public class Booking {

    private int id;
    private int relatedToUser;

    private int relatedToCar;

    private LocalDateTime initiationDate;

    private LocalDateTime bookingStartDate;

    private LocalDateTime closingTime;

    private BookingStatus status;

    public Booking(int id,int relatedToUser, int relatedToCar, LocalDateTime initiationDate, LocalDateTime bookingStartDate, LocalDateTime closingTime, BookingStatus status) {
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

    public BookingStatus getStatus() {
        return status;
    }

    public int getId(){
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
}
