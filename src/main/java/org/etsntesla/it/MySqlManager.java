package org.etsntesla.it;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlManager {

   private  static Connection connection;

   private static final String MYSQL_STRING = "jdbc:mysql://localhost:3306/db_emocije_zeka";
   private static final String MYSQL_USER= "root";
   private static final String MYSQL_PASS= "";


    static {
        try {
            connection = DriverManager.getConnection(MYSQL_STRING,MYSQL_USER,MYSQL_PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection() {
        return connection;
    }


}
