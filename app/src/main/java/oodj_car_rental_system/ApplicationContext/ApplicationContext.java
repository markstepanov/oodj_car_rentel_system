package oodj_car_rental_system.ApplicationContext;

import oodj_car_rental_system.Repository.CarRepository;
import oodj_car_rental_system.Repository.UserRepository;

public class ApplicationContext {

    private UserRepository userRepository;
    private CarRepository carRepository;

    public ApplicationContext(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;

    }


    public UserRepository getUserRepository() {
        return userRepository;
    }


}
