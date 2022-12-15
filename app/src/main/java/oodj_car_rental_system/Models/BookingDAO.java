package oodj_car_rental_system.Models;

import oodj_car_rental_system.ORMdeep.Annotations.IntegerField;
import oodj_car_rental_system.ORMdeep.Annotations.LocalDateTImeField;
import oodj_car_rental_system.ORMdeep.Annotations.StringField;
import oodj_car_rental_system.ORMdeep.BaseClass;

import java.time.LocalDateTime;

public class BookingDAO extends BaseClass {

    @IntegerField
    public int relatedToUser;

    @IntegerField
    public int relatedToCar;

    @LocalDateTImeField
    public LocalDateTime initiationDate;

    @LocalDateTImeField
    public LocalDateTime bookingStartDate;

    @LocalDateTImeField
    public LocalDateTime closingTime;

    @StringField
    public String Status;

    public BookingDAO(){}

    @Override
    public String toString() {
        return "BookingDAO{" +
                "relatedToUser=" + relatedToUser +
                ", relatedToCar=" + relatedToCar +
                ", initiationDate=" + initiationDate +
                ", bookingStartDate=" + bookingStartDate +
                ", closingTime=" + closingTime +
                ", Status='" + Status + '\'' +
                '}';
    }

    public BookingDAO(int relatedToUser, int relatedToCar, LocalDateTime initiationDate, LocalDateTime bookingStartDate, LocalDateTime closingTime, String status) {
        this.relatedToUser = relatedToUser;
        this.relatedToCar = relatedToCar;
        this.initiationDate = initiationDate;
        this.bookingStartDate = bookingStartDate;
        this.closingTime = closingTime;
        Status = status;
    }
}
