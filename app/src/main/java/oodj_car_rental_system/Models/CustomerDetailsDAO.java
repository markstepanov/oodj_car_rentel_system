package oodj_car_rental_system.Models;

import oodj_car_rental_system.ORMdeep.Annotations.FloatField;
import oodj_car_rental_system.ORMdeep.Annotations.IntegerField;
import oodj_car_rental_system.ORMdeep.Annotations.StringField;
import oodj_car_rental_system.ORMdeep.BaseClass;

public class CustomerDetailsDAO extends BaseClass {

    @StringField
    public String firstName;

    @StringField
    public String secondName;

    @StringField
    public String email;

    @FloatField
    public float balanceRM;

    @IntegerField
    public int relatedToUser;


    public CustomerDetailsDAO(){}

    public CustomerDetailsDAO(String firstName, String secondName, String email, float balanceRM, int relatedToUser) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.balanceRM = balanceRM;
        this.relatedToUser = relatedToUser;
    }
}
