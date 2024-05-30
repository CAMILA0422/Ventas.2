package Controlador;

import Controlador.Login;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Conexion cn = new Conexion();


    public Login log(String Correo, String Pass) {
        //REALIZA UNA CONSULTA DONDE VERIFICA SI EL DATO DE CORREO Y PASS SON IGUALES 
        // A UN REGISTRO QUE SE ENCUENTRE EN LA BASE DE DATOS
        Login l = new Login();
        String sql = "SELECT * FROM tb_usuario WHERE Correo = ? AND Pass = ?";

        try {
            //UTILIZAMOS LA EXCEPCION TRY PARA ESTABLECER UNA CONEXION A LA BASE DE DATOS
            con = cn.getConnection();
            //AQUI SE ESTA PREPARANDO UNA CONSULTA PARA SER EJECUTADA EN BASE DE DATOS
            ps = con.prepareStatement(sql);
            // SE ESTABLECIERON VALORES PARA EL CORREO Y LA CONTRASEÑA DEL USUARIO 
            //CORREO Y PASS SON LAS VARIABLES QUE CONTIENEN ESTOS VALORES
            ps.setString(1, Correo);
            ps.setString(2, Pass);
            //AQUI EL RESULTADO SE ALMACENA EN UN OBJETO ResultSet EL CUAL LLAMAMOS rs
            //UN ResultSet ES UN OBJETO QUE CONTIENE LOS RESULTADOS DE UNA CONSULTA SQL
            rs = ps.executeQuery();

            //VERIFICA SI EXISTE AL MENOS UNA FILA DE RESULTADO EN EL ResultSet
            if (rs.next()) {
                // SEI SE ENCUENTRA UN REGISTRO QUE COINCIDA CON LAS CREDENCIALES DE INICIO DE SESION
                //QUIERE DECIR QUE SE ESTA OBTENIENDO LOS VALORES DE LAS COLUMNAS 
                l.setId(rs.getInt("id_usuario"));
                l.setNombre(rs.getString("Nombre"));
                l.setCorreo(rs.getString("Correo"));
                l.setPass(rs.getString("Pass"));
            }
        } 
        //IMPRIME LA EXCEPCION DE ERROR QUE SE ENCUENTRE EN LA BASE DE DATOS
        catch (SQLException e) {
            System.out.println(e.toString());
        }

        return l;
    }
}