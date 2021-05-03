package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "";
        String databaseUser = "hr";
        String databasePassword = "hr";
        String url = "jdbc:oracle:thin:@localhost:1521/XE";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}
