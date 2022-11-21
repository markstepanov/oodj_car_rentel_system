package oodj_car_rental_system.ApplicationContext;

import oodj_car_rental_system.Entities.Customer;
import oodj_car_rental_system.Entities.User;
import oodj_car_rental_system.ORMdeep.TextFileORM;
import oodj_car_rental_system.Repository.UserRepository;

public class ApplicationContext {

    private UserRepository userRepository;

    public ApplicationContext(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }


}
