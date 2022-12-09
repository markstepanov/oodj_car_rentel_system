package oodj_car_rental_system.Models;

import oodj_car_rental_system.ORMdeep.Annotations.StringField;
import oodj_car_rental_system.ORMdeep.BaseClass;

public class UserApplicationDAO extends BaseClass {

    @StringField
    public String username;

    @StringField
    public String password;

    @StringField
    public String firstName;

    @StringField
    public String secondName;

    @StringField
    public String email;

    public UserApplicationDAO(){}
    public UserApplicationDAO(String username, String password, String firstName, String secondName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
    }
}
