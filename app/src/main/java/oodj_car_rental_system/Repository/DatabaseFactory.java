package oodj_car_rental_system.Repository;

import oodj_car_rental_system.Models.CarDAO;
import oodj_car_rental_system.Models.UserApplicationDAO;
import oodj_car_rental_system.Models.UserDAO;
import oodj_car_rental_system.Models.CustomerDetailsDAO;
import oodj_car_rental_system.ORMdeep.TextFileORM;

public class DatabaseFactory {
    private String pathToDBdir;

    public DatabaseFactory(String pathToDBdir) {
        this.pathToDBdir = pathToDBdir;
    }

    public TextFileORM createDatabase(){
       TextFileORM textFileORM = new TextFileORM(this.pathToDBdir);

       textFileORM.addTable(new UserDAO());
       textFileORM.addTable(new CarDAO());
       textFileORM.addTable(new UserApplicationDAO());
       textFileORM.addTable(new CustomerDetailsDAO());

       try {
           textFileORM.connect();
       } catch (Exception e){
           e.printStackTrace();
       }

       return  textFileORM;
    }

}
