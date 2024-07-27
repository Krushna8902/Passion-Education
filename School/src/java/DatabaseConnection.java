
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Krushna Siraskar
 */
public class DatabaseConnection {
    protected static Connection IntilizeConnection() throws SQLException ,ClassNotFoundException
    {
        String dbDriver="com.mysql.jdbc.Driver";
        String dbUrl="jdbc:mysql://localhost:3306/";
        String dbName="school";
        String dbUser="root";
        String dbPass="";
        Class.forName(dbDriver);
        Connection conn=DriverManager.getConnection(dbUrl+dbName,dbUser,dbPass);
        return conn;
    }
}
