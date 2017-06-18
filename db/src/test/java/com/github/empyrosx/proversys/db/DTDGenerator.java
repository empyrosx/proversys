package com.github.empyrosx.proversys.db;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**
 * DTD schema generator for current database.
 */
public class DTDGenerator {

    private final String databaseURL;
    private final String dtdPath;

    public DTDGenerator(String databaseURL, String dtdPath) {
        this.databaseURL = databaseURL;
        this.dtdPath = dtdPath;
    }

    public void init() throws ClassNotFoundException {
        // database connection
//        Connection jdbcConnection;
//        try {
//            jdbcConnection = DriverManager.getConnection(databaseURL);
//            IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
//
//            // write DTD file
//            IDataSet dataSet = connection.createDataSet();
//            String[] tableNames = dataSet.getTableNames();
//            List<String> workTables = new ArrayList<>();
//            for (String tableName : tableNames) {
//                if (!tableName.equals("SCHEMA_VERSION")) {
//                    workTables.add(tableName);
//                }
//            }
//
//            dataSet = connection.createDataSet(workTables.toArray(new String[]{}));
//            FlatDtdDataSet.write(dataSet, new FileOutputStream(dtdPath));
//        } catch (Exception e) {
//            throw new RuntimeException("Exception while generating DTD schema", e);
//        }
    }
}
