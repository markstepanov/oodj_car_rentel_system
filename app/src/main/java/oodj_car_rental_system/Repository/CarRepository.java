package oodj_car_rental_system.Repository;

import oodj_car_rental_system.Entities.cars.Car;
import oodj_car_rental_system.Models.CarDAO;
import oodj_car_rental_system.ORMdeep.BaseClass;
import oodj_car_rental_system.ORMdeep.TableReader;
import oodj_car_rental_system.ORMdeep.TableRecordDeleter;
import oodj_car_rental_system.ORMdeep.TableWriter;
import oodj_car_rental_system.Serializers.CarSerializer;

import java.util.ArrayList;
import java.util.Optional;

public class CarRepository {


    private TableWriter tableWriter;

    private TableReader tableReader;
    private TableRecordDeleter tableRecordDeleter;

    public CarRepository(TableWriter tableWriter, TableReader tableReader, TableRecordDeleter tableRecordDeleter) {
        this.tableWriter = tableWriter;
        this.tableReader = tableReader;
        this.tableRecordDeleter = tableRecordDeleter;
    }


    public void  addNewCar(Car car, int count) throws Exception{
        CarDAO carDAO = CarSerializer.serializeCarEntityToCarDAO(car);
        for (int i = 0; i < count; i++){
            tableWriter.writeNew(carDAO);
        }
    }

    public Optional<ArrayList<Car>> getAllCars(){
        BaseClass[] records;
        try{
            records= tableReader.readAll(new CarDAO());
        } catch (Exception e){
            return Optional.empty();
        }

        ArrayList<Car> cars = new ArrayList<>();
        for (BaseClass record: records){
            CarDAO carDaoRecord = (CarDAO) record;
            try{
                Car finalCar = CarSerializer.serializeCarDAOtoCarEntity(carDaoRecord);
                cars.add(finalCar);
            } catch (Exception e){
                return Optional.empty();
            }
        }

        return Optional.of(cars);
    }

    public Optional<Car> getCarById(int id){

        BaseClass carDAO ;
        try{
            carDAO =  tableReader.readById(new CarDAO(), id);
        } catch (Exception e){
            return Optional.empty();
        }

        Car car;
        try{
            car = CarSerializer.serializeCarDAOtoCarEntity((CarDAO) carDAO);
        } catch (Exception e){
            return Optional.empty();
        }

        return Optional.of(car);
    }

    public boolean editCar(Car car){
        CarDAO carToWrite;
        try {
            carToWrite = CarSerializer.serializeCarEntityToCarDAO(car);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        System.out.println(carToWrite.toString());

        try{
            tableWriter.writeToID(carToWrite);
            return  true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public boolean deleteCarById(int id){
        try {
            tableRecordDeleter.deleteRecordById(new CarDAO(), id);
        } catch (Exception e){
            return false;
        }
        return  true;
    }

    public Optional<ArrayList<Car>> getAllAvailableCars(){
        BaseClass [] records;
        try{
            records = tableReader.readAll(new CarDAO());
        } catch (Exception e){
            return Optional.empty();
        }

        ArrayList<Car> cars = new ArrayList<>();

        for (BaseClass record: records){
            Car car;
            try {
                car = CarSerializer.serializeCarDAOtoCarEntity((CarDAO) record);
            } catch (Exception e){
                continue;
            }
            if (car.isInStock()){
                cars.add(car);
            }
        }
        if (cars.isEmpty()) return Optional.empty();
        return Optional.of(cars);
    }



}

