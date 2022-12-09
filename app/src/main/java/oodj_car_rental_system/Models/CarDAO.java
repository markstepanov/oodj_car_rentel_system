package oodj_car_rental_system.Models;

import oodj_car_rental_system.ORMdeep.Annotations.FloatField;
import oodj_car_rental_system.ORMdeep.Annotations.IntegerField;
import oodj_car_rental_system.ORMdeep.Annotations.StringField;
import oodj_car_rental_system.ORMdeep.BaseClass;

public class CarDAO  extends BaseClass {
    @StringField
    public String name;
    @FloatField
    public float pricePerHour;
    @StringField
    public  String carType;
    @StringField
    public  String carFuel;
    @IntegerField
    public int seats;
    @StringField
    public String gearBoxType;


    public CarDAO() {
    }

    public CarDAO(String name, float pricePerHour, String carType, String carFuel, int seats, String gearBoxType) {
        this.name = name;
        this.pricePerHour = pricePerHour;
        this.carType = carType;
        this.carFuel = carFuel;
        this.seats = seats;
        this.gearBoxType = gearBoxType;
    }

}
