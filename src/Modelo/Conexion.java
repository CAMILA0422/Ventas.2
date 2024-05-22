package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {
    Connection con;
     //Connection  enlazar;
    String pass = "postgres";
    String usser = "postgres";
    
    public Connection getConnection(){
        try{
           con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Sistema_Venta",usser,pass);
           return con;
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return null;
    }
}

