package Controlador;

public class Venta {
    private int id_ventas;
    private String vendedor;
    private double total;
    
    public Venta(){
        
    }

    public Venta(int id_ventas, String vendedor, double total) {
        this.id_ventas = id_ventas;
        this.vendedor = vendedor;
        this.total = total;
    }

    public int getId_ventas() {
        return id_ventas;
    }

    public void setId_ventas(int id_ventas) {
        this.id_ventas = id_ventas;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
