package oodj_car_rental_system.Entities.cars;

public class Car {

     private String Name;

     private float pricePerHour;


     private CarType carType;


     private CarFuel carFuel;

     private int seats;

     private GearBoxType gearBoxType;


    public Car(String name, float pricePerHour, CarType carType, CarFuel carFuel, int seats, GearBoxType gearBoxType) {
        Name = name;
        this.pricePerHour = pricePerHour;
        this.carType = carType;
        this.carFuel = carFuel;
        this.seats = seats;
        this.gearBoxType = gearBoxType;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getPricePerHour() {

        return pricePerHour;
    }

    public void setPricePerHour(float pricePerHour) throws Exception{
        if (pricePerHour < 0f){
            throw  new Exception("Price should be bigger than 0");
        }
        this.pricePerHour = pricePerHour;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public CarFuel getCarFuel() {
        return carFuel;
    }

    public void setCarFuel(CarFuel carFuel) {
        this.carFuel = carFuel;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) throws  Exception {
        if (seats < 2){
            throw  new Exception("Price should be bigger than 2");
        }
        this.seats = seats;
    }

    public GearBoxType getGearBoxType() {
        return gearBoxType;
    }

    public void setGearBoxType(GearBoxType gearBoxType) {
        this.gearBoxType = gearBoxType;
    }
}
