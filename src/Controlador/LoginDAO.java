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
        Login l = new Login(); // Assuming there is a Login class
        String sql = "SELECT * FROM tb_usuario WHERE Correo = ? AND Pass = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, Correo);
            ps.setString(2, Pass);
            rs = ps.executeQuery();

            if (rs.next()) {
                l.setId(rs.getInt("id_usuario"));
                l.setNombre(rs.getString("Nombre"));
                l.setCorreo(rs.getString("Correo"));
                l.setPass(rs.getString("Pass"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return l;
    }
}