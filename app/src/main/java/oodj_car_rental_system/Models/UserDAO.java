package oodj_car_rental_system.Models;

import oodj_car_rental_system.ORMdeep.Annotations.BooleanField;
import oodj_car_rental_system.ORMdeep.Annotations.StringField;
import oodj_car_rental_system.ORMdeep.BaseClass;

public class UserDAO extends BaseClass {

    @StringField
    public String username;

    @StringField
    public String password;

    @BooleanField
    public boolean isAdmin;

    public UserDAO() {
    }

    @Override
    public String toString() {
        return "UserDAO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public UserDAO(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}
