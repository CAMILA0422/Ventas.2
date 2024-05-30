package Controlador;

public class Venta {
     //LOS ATRIBUTOS(COLUMNAS) DE LA BASE DE DATOS
    private int id_ventas;
    private double total;
    
    public Venta(){
        
    }
    //AQUI AGREGAMOS EL CONSTRUCTOR QUE NOS PERMITE ACCEDER A LA INFORMACION
    public Venta(int id_ventas, double total) {
        this.id_ventas = id_ventas;
        this.total = total;
    }

    public int getId_ventas() {
        return id_ventas;
    }

    public void setId_ventas(int id_ventas) {
        this.id_ventas = id_ventas;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
