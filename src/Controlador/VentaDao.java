
package Controlador;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VentaDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    int r;
    public int RegistrarVenta (Venta v){
        String sql = "INSERT INTO tb_ventas (vendedor, total) VALUES (?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getVendedor());
            ps.setDouble(2, v.getTotal());
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
}
