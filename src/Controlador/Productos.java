/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author bermu
 */
public class Productos {
     //LOS ATRIBUTOS(COLUMNAS) DE LA BASE DE DATOS
    private int id_productos;
    private String Cod_Barras;
    private String Nombre_Producto;
    private String Proveedor;
    private int Stock;
    private double Precio;

    public Productos() {
    }
    //AQUI AGREGAMOS EL CONSTRUCTOR QUE NOS PERMITE ACCEDER A LA INFORMACION
    public Productos(int id_productos, String Cod_Barras, String Nombre_Producto, String Proveedor, int Stock, double Precio) {
        this.id_productos = id_productos;
        this.Cod_Barras = Cod_Barras;
        this.Nombre_Producto = Nombre_Producto;
        this.Proveedor = Proveedor;
        this.Stock = Stock;
        this.Precio = Precio;
    }

    public int getId_productos() {
        return id_productos;
    }

    public void setId_productos(int id_productos) {
        this.id_productos = id_productos;
    }

    public String getCod_Barras() {
        return Cod_Barras;
    }

    public void setCod_Barras(String Cod_Barras) {
        this.Cod_Barras = Cod_Barras;
    }

    public String getNombre_Producto() {
        return Nombre_Producto;
    }

    public void setNombre_Producto(String Nombre_Producto) {
        this.Nombre_Producto = Nombre_Producto;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
  
    
}
