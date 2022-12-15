package oodj_car_rental_system.Entities.cars;

public class Car {

    private int id;
    private String Name;

    private float pricePerHour;


    private CarType carType;


    private CarFuel carFuel;

    private int seats;

    private GearBoxType gearBoxType;

    private boolean inStock;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInStock() {
        return inStock;
    }


    public Car(int id, String name, float pricePerHour, CarType carType, CarFuel carFuel, int seats, GearBoxType gearBoxType, boolean inStock) {
        this.id = id;
        Name = name;
        this.pricePerHour = pricePerHour;
        this.carType = carType;
        this.carFuel = carFuel;
        this.seats = seats;
        this.gearBoxType = gearBoxType;
        this.inStock = inStock;
    }

    public Car(String name, float pricePerHour, CarType carType, CarFuel carFuel, int seats, GearBoxType gearBoxType, boolean inStock) {
        Name = name;
        this.pricePerHour = pricePerHour;
        this.carType = carType;
        this.carFuel = carFuel;
        this.seats = seats;
        this.gearBoxType = gearBoxType;
        this.inStock = inStock;
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


    public CarType getCarType() {
        return carType;
    }


    public CarFuel getCarFuel() {
        return carFuel;
    }


    public int getSeats() {
        return seats;
    }


    public GearBoxType getGearBoxType() {
        return gearBoxType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Name='" + Name + '\'' +
                ", pricePerHour=" + pricePerHour +
                ", carType=" + carType +
                ", carFuel=" + carFuel +
                ", seats=" + seats +
                ", gearBoxType=" + gearBoxType +
                '}';
    }

}
