package oodj_car_rental_system.Repository;

import oodj_car_rental_system.Entities.Bookings.Booking;
import oodj_car_rental_system.Entities.Bookings.BookingStatus;
import oodj_car_rental_system.Entities.cars.Car;
import oodj_car_rental_system.Entities.users.Customer;
import oodj_car_rental_system.Models.BookingDAO;
import oodj_car_rental_system.ORMdeep.BaseClass;
import oodj_car_rental_system.ORMdeep.TableReader;
import oodj_car_rental_system.ORMdeep.TableRecordDeleter;
import oodj_car_rental_system.ORMdeep.TableWriter;
import oodj_car_rental_system.Serializers.BookingSerializer;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class BookingRepository {
    private TableWriter tableWriter;

    private TableReader tableReader;

    private TableRecordDeleter tableRecordDeleter;

    public BookingRepository(TableWriter tableWriter, TableReader tableReader, TableRecordDeleter tableRecordDeleter) {
        this.tableWriter = tableWriter;
        this.tableReader = tableReader;
        this.tableRecordDeleter = tableRecordDeleter;
    }


    public Optional<Booking> getCustomerValidBooking(Customer customer) {
        BaseClass[] records;

        try {
            records = tableReader.readAll(new BookingDAO());
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }


        for (BaseClass record : records) {
            Booking booking = BookingSerializer.serializeBookingDAOtoBookingEntity((BookingDAO) record);
            if (booking.getRelatedToUser() == customer.getId()
                    && (booking.getStatus().equals(BookingStatus.APPROVED) ||
                    booking.getStatus().equals(BookingStatus.ACTIVE) ||
                    booking.getStatus().equals(BookingStatus.PENDING))) {
                return Optional.of(booking);
            }
        }
        return Optional.empty();
    }

    public Optional<ArrayList<Booking>> getAllPendingBookings(){
        BaseClass[] records;
        try{
            records = tableReader.readAll(new BookingDAO());
        } catch (Exception e){
            return Optional.empty();
        }

        ArrayList<Booking> pendingBookings = new ArrayList<>();
        for (BaseClass record: records){
            Booking booking = BookingSerializer.serializeBookingDAOtoBookingEntity((BookingDAO) record);
            if  (booking.getStatus().equals(BookingStatus.PENDING)){
                pendingBookings.add(booking);
            }
        }

        if(pendingBookings.isEmpty()) return Optional.empty();
        return Optional.of(pendingBookings);

    }

    public boolean makeABooking(Customer customer, Car car){
        BookingDAO bookingDAO = new BookingDAO(
                customer.getId(),
                car.getId(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                BookingSerializer.serializeBookingStatus(BookingStatus.PENDING));


        try {
            int result = tableWriter.writeNew(bookingDAO);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
