package oodj_car_rental_system.ORMdeep;

import java.util.ArrayList;

public class TextFileORM {

    private final ArrayList<BaseClass> tablesToInitialize;
    private final TableFileFetcher tableFileFetcher;
    private final TableWriter tableWriter;

    private final TableReader tableReader;

    private final TableRecordDeleter tableRecordDeleter;

    private  String pathToDBRepository;
    public TableRecordDeleter getTableRecordDeleter() {
        return tableRecordDeleter;
    }

    public TextFileORM(String pathToDBRepository) {

        this.pathToDBRepository = pathToDBRepository;
        this.tablesToInitialize = new ArrayList<>();
        this.tableFileFetcher = new TableFileFetcher(this.pathToDBRepository);
        TableFIleIOController tableFIleIOController = new TableFIleIOController(this.tableFileFetcher);
        this.tableWriter = new TableWriter(tableFIleIOController);
        this.tableReader = new TableReader(tableFIleIOController);
        this.tableRecordDeleter = new TableRecordDeleter(tableFIleIOController);

    }

    public TableWriter getTableWriter(){
        return  this.tableWriter;
    }

    public  TableReader getTableReader(){
        return this.tableReader;
    }

    public void addTable(BaseClass table) {
        this.tablesToInitialize.add(table);
    }

    public void connect() throws Exception {
        TextDbTable[] dbTables = getAllTables();
       for (TextDbTable table: dbTables){
          this.tableFileFetcher.addTextDbTable(table);
       }
    }



    private TextDbTable[] getAllTables() throws Exception {
        ArrayList<TextDbTable> dbTables = new ArrayList<>();
        TextDbTableFactory textDbTableFactory = new TextDbTableFactory();
        for (BaseClass table : this.tablesToInitialize) {
            dbTables.add(textDbTableFactory.assembleTable(table));
        }
        TextDbTable[] dbTablesArray = new TextDbTable[dbTables.size()];
        dbTablesArray = dbTables.toArray(dbTablesArray);
        return dbTablesArray;
    }


}



