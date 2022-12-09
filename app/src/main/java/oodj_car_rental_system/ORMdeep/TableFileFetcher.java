package oodj_car_rental_system.ORMdeep;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TableFileFetcher {


    private String pathToDbRepo;
    private final ArrayList<TextDbTable> dbTables;

    protected TableFileFetcher(String pathToDbRepo) {
        this.dbTables = new ArrayList<>();
        this.pathToDbRepo = pathToDbRepo;
        this.createPathToDbRepoDir();
    }

    private void createPathToDbRepoDir(){
        File dir = new File(pathToDbRepo);
        dir.mkdirs();
    }

    protected void addTextDbTable(TextDbTable table) throws Exception {
        File tableFile = getOrCreateTableFile(table);
        if (checkIfMetaDataIsTheSame(tableFile, table)) {
            table.setFile(tableFile);
            dbTables.add(table);
        } else {
            throw new Exception(table.getName() + " file and table has different metadata, try to delete existing TableFile");
        }
    }

    protected List<TextDbTable> getImmutableDbTables() {
        return Collections.unmodifiableList(this.dbTables);
    }

    private File getOrCreateTableFile(TextDbTable table) throws Exception {
        Optional<File> tableFileBox = getFileIfExist(table);
        File tableFile;
        if (tableFileBox.isEmpty()) {
            tableFile = createNewTableFile(table).orElseThrow();
            writeMetadata(tableFile, table);
        } else {
            tableFile = tableFileBox.get();
        }

        return tableFile;
    }

    private boolean checkIfMetaDataIsTheSame(File tableFile, TextDbTable table) throws Exception {
        String[] fileLines = Files.readString(tableFile.toPath()).split("\n");
        int metaDataIndex = 0;

        return fileLines[metaDataIndex].equals(table.generateMeta());
    }

    private Optional<File> createNewTableFile(TextDbTable table) {
        File tableFile = new File(this.pathToDbRepo, table.getName());
        try {
            if (tableFile.createNewFile()) {
                writeMetadata(tableFile, table);
                return Optional.of(tableFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<File> getFileIfExist(TextDbTable table) {
        File test = new File(this.pathToDbRepo, table.getName());
        File tableFile = new File("databases/" + table.getName());
        if (tableFile.exists()) {
            return Optional.of(tableFile);
        }
        return Optional.empty();
    }

    private void writeMetadata(File tableFile, TextDbTable table) throws Exception {
        FileWriter fileWriter = new FileWriter(tableFile);
        fileWriter.write(table.generateMeta() + "\n");
        fileWriter.write("nextIndex:0\n");
        fileWriter.write("###\n");
        fileWriter.close();
    }

}
