package main.java.com.examly.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class DBConnection{

    private static final String DbName="restaurantdb";
    private static final String username="root";
    private static final String password="1418";
    private static final String URL="jdbc:mysql://localhost:3306/"+DbName;

    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL,username,password);
        }
        catch(ClassNotFoundException e){
            throw new SQLException("MYSQL JDBC Driver not found",e);

        }
        
    }
    public static void closeConnection(Connection con){
        if(con!=null){
            try{
                con.close();
            }
            catch(SQLException e){
                e.printStackTrace();
                
            }
        }

    }
}