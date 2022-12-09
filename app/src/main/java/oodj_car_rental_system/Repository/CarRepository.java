package oodj_car_rental_system.Repository;

import oodj_car_rental_system.Entities.cars.Car;
import oodj_car_rental_system.Models.CarDAO;
import oodj_car_rental_system.ORMdeep.TableReader;
import oodj_car_rental_system.ORMdeep.TableRecordDeleter;
import oodj_car_rental_system.ORMdeep.TableWriter;
import oodj_car_rental_system.Serializers.CarSerializer;

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




}

