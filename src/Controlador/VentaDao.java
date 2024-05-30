
package Controlador;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int IdVenta(){
        int id = 0;
        String sql = "SELECT MAX(id_ventas) FROM tb_ventas";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return id;
    }
    public int RegistrarVenta (Venta v){
        //REALIZA UNA INSERCION A LA BASE DE DATOS CON LOS DATOS REQUERIDOS
        String sql = "INSERT INTO tb_ventas (total) VALUES ( ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, v.getTotal());
            ps.execute();
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
             try{
                 con.close();
             }catch (SQLException e){
                 System.out.println(e.toString());
             }
         }
        return r;
    }
    
    public int RegistrarDetalle(Detalle Dv){
        //REALIZA UNA INSERCION A LA BASE DE DATOS CON LOS DATOS REQUERIDOS
        String sql = " INSERT INTO tb_detalle (cod_producto, cantidad, precio, id_ventas) VALUES (?, ?, ?, ?)";
         try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Dv.getCod_producto());
            ps.setInt(2, Dv.getCantidad());
            ps.setDouble(3, Dv.getPrecio());
            ps.setInt(4, Dv.getId_ventas());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
             try{
                 con.close();
             }catch (SQLException e){
                 System.out.println(e.toString());
             }
         }
        return r;
    }
    
    public boolean ActualizarStock(int cant, String cod){
        String sql = "UPDATE tb_productos SET stock = ? WHERE cod_barras = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
            return false;

    }
    
    
    public List ListarVentas() {
        //SE DECLARA UNA INSTANCIA DE LA CLASE ArrayList 
        //ArrayList ES UNA IMPLEMENTACION DE LIST EN JAVA
        List<Venta> ListaVenta = new ArrayList();
        //REALIZA UNA CONSULTA A LA TABLA VENTAS
        String sql = "SELECT * FROM tb_ventas";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta vent = new Venta();
                vent.setId_ventas(rs.getInt(("id_ventas")));
                vent.setTotal(rs.getDouble("Total"));
               
                ListaVenta.add(vent);

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaVenta;
    }
}
