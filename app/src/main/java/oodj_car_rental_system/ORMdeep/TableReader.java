package oodj_car_rental_system.ORMdeep;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TableReader {
    private final TableFIleIOController tableFIleIOController;


    protected TableReader(TableFIleIOController tableFIleIOController) {
        this.tableFIleIOController = tableFIleIOController;
    }

    public BaseClass readById(BaseClass table, int id) throws Exception {

        TextDbTable textDbTable = this.tableFIleIOController.createTextDbTable(table);
        TextDbTable existingDbTable = this.tableFIleIOController.getTable(textDbTable);
        ArrayList<String> rawFileContent = tableFIleIOController.getFIleContent(existingDbTable.getFile());
        if (id < 0 || id > tableFIleIOController.getMaxIndex(rawFileContent)) {
            throw new Exception("Could not parse value with " + id + " id.It's either lower than zero or bigger than maxIndex in the Table");
        }

        List<String> rawRecords = rawFileContent.subList(3, rawFileContent.size());

        String className = textDbTable.getName();
        Object recordInstance = Class.forName(className).getDeclaredConstructor().newInstance();


        for (String rawRecord : rawRecords) {
            if (rawRecord.split("`")[0].equals(String.valueOf(id))) {
                fillBaseClassInstance(rawRecord, (BaseClass) recordInstance, existingDbTable);
                return (BaseClass) recordInstance;
            }
        }

        throw new Exception("Record with id " + id + " is not exist");

    }

    public BaseClass[] readAll(BaseClass table) throws Exception {
        TextDbTable textDbTable = this.tableFIleIOController.createTextDbTable(table);
        TextDbTable existingDbTable = this.tableFIleIOController.getTable(textDbTable);
        ArrayList<String> rawFileContent = tableFIleIOController.getFIleContent(existingDbTable.getFile());
        List<String> rawRecords = rawFileContent.subList(3, rawFileContent.size());

        ArrayList<BaseClass> recordsList = new ArrayList<>();

        for (String record : rawRecords) {
            String className = textDbTable.getName();
            Object recordInstance = Class.forName(className).getDeclaredConstructor().newInstance();
            fillBaseClassInstance(record, (BaseClass) recordInstance, existingDbTable);
            recordsList.add((BaseClass) recordInstance);
        }

        BaseClass[] baseClassArray = new BaseClass[recordsList.size()];
        baseClassArray = recordsList.toArray(baseClassArray);
        return baseClassArray;

    }

    private void fillBaseClassInstance(String record, BaseClass currentInstance, TextDbTable existingTable) throws Exception {
        for (int i = 1; i < existingTable.getFields().length; i++) {
            TableField tableField = existingTable.getFields()[i];
            String fieldName = tableField.getName();
            int fieldNum = tableField.getFieldNumber();
            if (fieldName.equals("id")) {
                continue;
            }
            if (existingTable.getFields()[i].getFieldType().equals(DbField.INTFIELD)) {
                currentInstance.getClass().getDeclaredField(fieldName).set(currentInstance, Integer.valueOf(record.split("`")[fieldNum]));
            }
            else if (existingTable.getFields()[i].getFieldType().equals(DbField.BOOLEANFIELD)) {
                currentInstance.getClass().getDeclaredField(fieldName).set(currentInstance, Boolean.valueOf(record.split("`")[fieldNum]));
            }
            else if (existingTable.getFields()[i].getFieldType().equals(DbField.FLOATFIELD)) {
                currentInstance.getClass().getDeclaredField(fieldName).set(currentInstance, Float.valueOf(record.split("`")[fieldNum]));
            }
            else if (existingTable.getFields()[i].getFieldType().equals(DbField.LOCALTIMEFIELD)) {
                currentInstance.getClass().getDeclaredField(fieldName).set(currentInstance, LocalTime.parse(record.split("`")[fieldNum]));
            }
            else if (existingTable.getFields()[i].getFieldType().equals(DbField.STRINGFIELD)) {
                currentInstance.getClass().getDeclaredField(fieldName).set(currentInstance, record.split("`")[fieldNum]);
            }
        }
        currentInstance.getClass().getMethod("setId", int.class).invoke(currentInstance, Integer.valueOf(record.split("`")[0]));
    }


}
