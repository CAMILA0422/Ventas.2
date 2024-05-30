package Controlador;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ProveedorDao {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarProveedor(Proveedor pr) {
        //REALIZA UNA INSERCION A LA BASE DE DATOS CON LOS DATOS REQUERIDOS
        String sql = "INSERT INTO tb_proveedor (Nombre_Proveedor, Apellido_Proveedor, Cedula, Telefono) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombre_Proveedor());
            ps.setString(2, pr.getApellido_Proveedor());
            ps.setInt(3, pr.getCedula());
            ps.setString(4, pr.getTelefono());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public List ListarProveedor(){
        //SE DECLARA UNA INSTANCIA DE LA CLASE ArrayList 
        //ArrayList ES UNA IMPLEMENTACION DE LIST EN JAVA
        List<Proveedor> ListarPr = new ArrayList();
        //REALIZA UNA CONSULTA A LA TABLA PROVEEDOR
        String slq = "SELECT * FROM tb_proveedor";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(slq);
            rs = ps.executeQuery();
            while (rs.next()){
                Proveedor pr = new Proveedor();
                pr.setId_proveedor(rs.getInt("id_proveedor"));
                pr.setNombre_Proveedor(rs.getString("Nombre_Proveedor"));
                pr.setApellido_Proveedor(rs.getString("Apellido_Proveedor"));
                pr.setCedula(rs.getInt("Cedula"));
                pr.setTelefono(rs.getString("Telefono"));               
                ListarPr.add(pr);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListarPr;
    }

    public boolean EliminarProveedor(int id_proveedor) {
        //REALZIA UN DELETE EL CUAL SOLO ELIMINA EL REGISTRO DEL ID SELECCIONADO
        String sql = "DELETE FROM tb_proveedor WHERE id_proveedor = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_proveedor);
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
    
    public boolean ModificarProveedor(Proveedor pr){
        //REALIZA UN UPDATE PARA MODIFICAR AUNQUE SEA SOLO EL DATO DE UNA COLUMNA
        String sql = "UPDATE tb_proveedor SET Nombre_Proveedor=?, Apellido_Proveedor=?, cedula=?, Telefono=? WHERE id_proveedor=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombre_Proveedor());
            ps.setString(2, pr.getApellido_Proveedor());
            ps.setInt(3, pr.getCedula());
            ps.setString(4, pr.getTelefono());
            ps.setInt(5, pr.getId_proveedor());
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