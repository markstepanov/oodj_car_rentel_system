package oodj_car_rental_system.ApplicationContext;

import oodj_car_rental_system.Repository.BookingRepository;
import oodj_car_rental_system.Repository.CarRepository;
import oodj_car_rental_system.Repository.UserRepository;
import oodj_car_rental_system.utils.PdfGenerator;

public class ApplicationContext {

    private UserRepository userRepository;
    private CarRepository carRepository;

    private BookingRepository bookingRepository;




    public ApplicationContext(UserRepository userRepository, CarRepository carRepository, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.bookingRepository = bookingRepository;

    }

    public BookingRepository getBookingRepository() {
        return bookingRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }
}
