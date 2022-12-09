package oodj_car_rental_system.Serializers;

import oodj_car_rental_system.Entities.cars.Car;
import oodj_car_rental_system.Entities.cars.CarFuel;
import oodj_car_rental_system.Entities.cars.CarType;
import oodj_car_rental_system.Entities.cars.GearBoxType;
import oodj_car_rental_system.Models.CarDAO;

import java.util.Optional;

public class CarSerializer {


    public static Car serializeCarDAOtoCarEntity(CarDAO carDAO) throws Exception{

        CarType carType = deserializeCarType(carDAO.carType).orElseThrow();
        CarFuel carFuel = deserializeCarFuel(carDAO.carFuel).orElseThrow();
        GearBoxType gearBoxType = deserializeGearBox(carDAO.gearBoxType).orElseThrow();

        return new Car(carDAO.name, carDAO.pricePerHour, carType,carFuel, carDAO.seats, gearBoxType);
    }

    public static CarDAO serializeCarEntityToCarDAO(Car car) throws Exception{
        String carType = serializeCarType(car.getCarType()).orElseThrow();
        String carFuel = serializeCarFuel(car.getCarFuel()).orElseThrow();
        String gearBoxType = serializeGearBoxType(car.getGearBoxType()).orElseThrow();


        return new CarDAO(car.getName(), car.getPricePerHour(), carType, carFuel, car.getSeats(), gearBoxType);
    }

    private static Optional<String> serializeCarType(CarType carType) {
        if (carType.equals(CarType.HATCHBACK)) {
            return Optional.of("hatchback");
        } else if (carType.equals(CarType.SEDAN)) {
            return Optional.of("sedan");
        } else if (carType.equals(CarType.SUV)) {
            return Optional.of("suv");
        } else if (carType.equals(CarType.VAN)) {
            return Optional.of("van");
        }
        return Optional.empty();
    }

    private static Optional<String> serializeCarFuel(CarFuel carFuel) {
        if (carFuel.equals(CarFuel.ELECTRIC)) {
            return Optional.of("electric");
        } else if (carFuel.equals(CarFuel.GASOLINE)) {
            return Optional.of("gasoline");
        }
        return Optional.empty();
    }

    private static Optional<String> serializeGearBoxType(GearBoxType gearBoxType) {
        if (gearBoxType.equals(GearBoxType.AUTOMATIC)) {
            return Optional.of("automatic");
        } else if (gearBoxType.equals(GearBoxType.MANUAL)) {
            return Optional.of("manual");
        }
        return Optional.empty();
    }


    private static Optional<CarType> deserializeCarType(String carType) {
        if (carType.equals("hatchback")) {
            return Optional.of(CarType.HATCHBACK);
        } else if (carType.equals("sedan")) {
            return Optional.of(CarType.SEDAN);
        } else if (carType.equals("suv")) {
            return Optional.of(CarType.SUV);
        } else if (carType.equals("van")) {
            return Optional.of(CarType.VAN);
        }
        return Optional.empty();
    }


    private static Optional<CarFuel> deserializeCarFuel(String carFuel) {
        if (carFuel.equals("electric")) {
            return Optional.of(CarFuel.ELECTRIC);
        } else if (carFuel.equals("gasoline")) {
            return Optional.of(CarFuel.GASOLINE);
        }
        return Optional.empty();
    }

    private static Optional<GearBoxType> deserializeGearBox(String gearBox){

        if (gearBox.equals("automatic")){
            return Optional.of(GearBoxType.AUTOMATIC);
        } else if (gearBox.equals("manual")){
            return Optional.of(GearBoxType.MANUAL);
        }
        return Optional.empty();
    }

}
