package oodj_car_rental_system.Repository;

import oodj_car_rental_system.Entities.Admin;
import oodj_car_rental_system.Entities.Customer;
import oodj_car_rental_system.Entities.User;
import oodj_car_rental_system.Models.UserDAO;
import oodj_car_rental_system.ORMdeep.BaseClass;
import oodj_car_rental_system.ORMdeep.TableReader;
import oodj_car_rental_system.ORMdeep.TableRecordDeleter;
import oodj_car_rental_system.ORMdeep.TableWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Optional;

public class UserRepository {

    private TableWriter fileWriter;
    private TableReader fileReader;
    private TableRecordDeleter tableRecordDeleter;

    public UserRepository(TableWriter fileWriter, TableReader fileReader, TableRecordDeleter tableRecordDeleter) {
        this.fileWriter = fileWriter;
        this.fileReader = fileReader;
        this.tableRecordDeleter = tableRecordDeleter;
    }


    public <Y extends User> Optional<? extends User> getCustomer(User user) {
        BaseClass[] records;
        try {
            records = this.fileReader.readAll(new UserDAO());
        } catch (Exception e) {
            return Optional.empty();
        }

        for (BaseClass record : records) {
            UserDAO currentUser = (UserDAO) record;
            System.out.println(currentUser.toString());
            if (currentUser.password.equals(user.getPassword()) || currentUser.username.equals(user.getUsername())) {
                if (currentUser.isAdmin){
                    return Optional.of(new Admin(currentUser.username, currentUser.password));
                } else {
                    return Optional.of(new Customer(currentUser.username, currentUser.password));
                }
            }
        }
        return Optional.empty();
    }


}
