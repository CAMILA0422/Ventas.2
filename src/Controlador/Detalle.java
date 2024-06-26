
package Controlador;

public class Detalle {
    
    //LOS ATRIBUTOS(COLUMNAS) DE LA BASE DE DATOS
    private int id_detalle;
    private int cod_producto;
    private int cantidad;
    private double precio;
    private int id_ventas;
    
    public Detalle(){
        
    }
    //AQUI AGREGAMOS EL CONSTRUCTOR QUE NOS PERMITE ACCEDER A LA INFORMACION
    public Detalle(int id_detalle, int cod_producto, int cantidad, double precio, int id_ventas) {
        this.id_detalle = id_detalle;
        this.cod_producto = cod_producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_ventas = id_ventas;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_ventas() {
        return id_ventas;
    }

    public void setId_ventas(int id_ventas) {
        this.id_ventas = id_ventas;
    }

  
}