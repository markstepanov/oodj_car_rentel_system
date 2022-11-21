package oodj_car_rental_system.Repository;

import oodj_car_rental_system.Models.UserDAO;
import oodj_car_rental_system.ORMdeep.BaseClass;
import oodj_car_rental_system.ORMdeep.TableReader;
import oodj_car_rental_system.ORMdeep.TableWriter;
import oodj_car_rental_system.ORMdeep.TextFileORM;

public class DatabaseFactory {
    private String pathToDBdir;

    public DatabaseFactory(String pathToDBdir) {
        this.pathToDBdir = pathToDBdir;
    }

    public TextFileORM createDatabase(){
       TextFileORM textFileORM = new TextFileORM(this.pathToDBdir);

       textFileORM.addTable(new UserDAO());

       try {
           textFileORM.connect();
       } catch (Exception e){
           e.printStackTrace();
       }

        TableReader tableReader = textFileORM.getTableReader();
       try {
           for (BaseClass u :tableReader.readAll(new UserDAO())){
               System.out.println(((UserDAO) u).toString());

           }
       } catch (Exception e){

           e.printStackTrace();
       }


       return  textFileORM;
    }

}
