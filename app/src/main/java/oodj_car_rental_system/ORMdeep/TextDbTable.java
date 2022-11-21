package oodj_car_rental_system.ORMdeep;


import java.io.File;

public class TextDbTable {
    private final TableField[] fields;
    private File file;
    private final String name;

    public void setFile(File file) {
        this.file = file;
    }

    public TextDbTable(TableField[] tableFields, String name){
        this.fields = tableFields;
        this.name = name;
    }

    public TableField[] getFields() {
        return fields;
    }

    public File getFile() {
        return file;
    }

    public String getName() {
        return name;
    }

    public String generateMeta() {
        StringBuilder metaData = new StringBuilder(this.name + "&[");
        for (int i = 0; i < this.fields.length; i++) {
            metaData.append(this.fields[i].getName()).append(":").append(this.fields[i].getFieldType());
            if (i != this.fields.length - 1) {
                metaData.append(",");
            }
        }

        return metaData + "]";
    }

}