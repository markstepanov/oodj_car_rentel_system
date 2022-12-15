package oodj_car_rental_system.Serializers;

import oodj_car_rental_system.Entities.Bookings.Booking;
import oodj_car_rental_system.Entities.Bookings.BookingStatus;
import oodj_car_rental_system.Models.BookingDAO;

public class BookingSerializer {

    public static BookingDAO serializeBookingToBookingDAO(Booking booking){
        BookingDAO bookingDAO = new BookingDAO(booking.getRelatedToUser(), booking.getRelatedToCar(),
                booking.getInitiationDate(), booking.getBookingStartDate(), booking.getClosingTime(),
                serializeBookingStatus(booking.getStatus()));
        bookingDAO.setId(booking.getId());
        return bookingDAO;
    }

    public static  Booking serializeBookingDAOtoBookingEntity(BookingDAO bookingDAO){
        return new Booking(
                bookingDAO.getId(),
                bookingDAO.relatedToUser,
                bookingDAO.relatedToCar,
                bookingDAO.initiationDate,
                bookingDAO.bookingStartDate,
                bookingDAO.closingTime,
                deseralizeBookingStatus(bookingDAO.Status)
        );


    }
    public static String serializeBookingStatus(BookingStatus status){
        if (status.equals(BookingStatus.APPROVED)){
            return "approved";
        } else if (status.equals(BookingStatus.ACTIVE)){
            return "active";
        } else if (status.equals(BookingStatus.CLOSED)){
           return "closed";
        }else if (status.equals(BookingStatus.PENDING)){
            return "pending";
        }
            return "rejected";
    }

    public static BookingStatus deseralizeBookingStatus(String status){
        if (status.equals("approved")) {
            return BookingStatus.APPROVED;
        } else if (status.equals("active")){
           return BookingStatus.ACTIVE;
        } else if (status.equals("closed")) {
            return BookingStatus.CLOSED;
        } else if (status.equals("pending")){
            return BookingStatus.PENDING;
        }
        return BookingStatus.REJECTED;
    }
}
