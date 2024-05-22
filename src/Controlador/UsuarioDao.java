/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


/**
 *
 * @author bermu
 */
public class UsuarioDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarUsuario(Usuario us) {
        String sql = "INSERT INTO tb_usuario (Nombre, Correo, Pass ) VALUES (?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getCorreo());
            ps.setString(3, us.getPass());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public List ListarUsuario() {
        List<Usuario> ListaUs = new ArrayList();
        String sql = "SELECT * FROM tb_usuario";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario us = new Usuario();
                us.setId_usuario(rs.getInt(("id_usuario")));
                us.setNombre(rs.getString("Nombre"));
                us.setCorreo(rs.getString("Correo"));
                us.setPass(rs.getString("Pass"));
                ListaUs.add(us);

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaUs;
    }

    public boolean EliminarUsuario(int id_usuario) {
        String sql = "DELETE FROM tb_usuario WHERE id_usuario = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_usuario);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean ModificarUsuario(Usuario Us){
        String sql = " UPDATE tb_usuario SET Nombre=?, Correo=?, Pass=? WHERE id_usuario=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Us.getNombre());
            ps.setString(2, Us.getCorreo());
            ps.setString(3, Us.getPass());
            ps.setInt(4, Us.getId_usuario());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}

