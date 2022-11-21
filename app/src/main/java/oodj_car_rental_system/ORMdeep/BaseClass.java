package oodj_car_rental_system.ORMdeep;

import oodj_car_rental_system.ORMdeep.Annotations.IdField;


public abstract class BaseClass {
    @IdField
    private int id;


    public int getId() {
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

}

