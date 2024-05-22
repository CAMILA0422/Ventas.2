/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//cambio
package Controlador;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class ProductosDao {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarProductos(Productos pro) {
        String sql = "INSERT INTO tb_productos (Cod_Barras, Nombre_Producto, Proveedor, Stock, Precio) VALUES (?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCod_Barras());
            ps.setString(2, pro.getNombre_Producto());
            ps.setString(3, pro.getProveedor());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public void ConsultarProveedor(JComboBox proveedor) {
        String sql = "SELECT Nombre_proveedor FROM tb_proveedor";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                proveedor.addItem(rs.getString("Nombre_proveedor"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public List ListarProductos() {
        List<Productos> ListaPro = new ArrayList();
        String sql = "SELECT * FROM tb_productos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos pro = new Productos();
                pro.setId_productos(rs.getInt(("id_productos")));
                pro.setCod_Barras(rs.getString("Cod_Barras"));
                pro.setNombre_Producto(rs.getString("Nombre_Producto"));
                pro.setProveedor(rs.getString("Proveedor"));
                pro.setStock(rs.getInt("Stock"));
                pro.setPrecio(rs.getDouble("Precio"));
                ListaPro.add(pro);

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaPro;
    }

    public boolean EliminarProductos(int id_productos) {
        String sql = "DELETE FROM tb_productos WHERE id_productos = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_productos);
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

    public boolean ModificarProductos(Productos pro) {
        String sql = " UPDATE tb_productos SET Cod_Barras=?, Nombre_Producto=?, Proveedor=?, Stock=?, Precio=? WHERE id_productos=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCod_Barras());
            ps.setString(2, pro.getNombre_Producto());
            ps.setString(3, pro.getProveedor());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());
            ps.setInt(6, pro.getId_productos());
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
    
    public Productos BuscarPro(String cod) {
        Productos producto = new Productos();
        String sql = "SELECT * FROM tb_productos WHERE Cod_Barras=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.setNombre_Producto(rs.getString("Nombre_Producto"));
                producto.setPrecio(rs.getDouble("Precio"));
                producto.setStock(rs.getInt("Stock"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return producto;
    }
}
