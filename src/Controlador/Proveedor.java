package Controlador;


public class Proveedor {
    private int id_proveedor;
    private String Nombre_Proveedor;
    private String Apellido_Proveedor;
    private int Cedula;
    private String Telefono;

    public Proveedor() {
    }

    public Proveedor(int id_proveedor, String Nombre_Proveedor, String Apellido_Proveedor, int Cedula, String Telefono) {
        this.id_proveedor = id_proveedor;
        this.Nombre_Proveedor = Nombre_Proveedor;
        this.Apellido_Proveedor = Apellido_Proveedor;
        this.Cedula = Cedula;
        this.Telefono = Telefono;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_Proveedor() {
        return Nombre_Proveedor;
    }

    public void setNombre_Proveedor(String Nombre_Proveedor) {
        this.Nombre_Proveedor = Nombre_Proveedor;
    }

    public String getApellido_Proveedor() {
        return Apellido_Proveedor;
    }

    public void setApellido_Proveedor(String Apellido_Proveedor) {
        this.Apellido_Proveedor = Apellido_Proveedor;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    
}
