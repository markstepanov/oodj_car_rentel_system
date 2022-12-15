package oodj_car_rental_system.utils;

import oodj_car_rental_system.ApplicationContext.ApplicationContext;
import oodj_car_rental_system.ORMdeep.TableReader;
import oodj_car_rental_system.ORMdeep.TableWriter;

public class PdfGenerator {

    private TableWriter tableWriter;
    private TableReader tableReader;

    public PdfGenerator(TableWriter tableWriter,TableReader tableReader) {
        this.tableWriter = tableWriter;
        this.tableReader = tableReader;
    }

    public void generatePdf(String path){
    }


}
