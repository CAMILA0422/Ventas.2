/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author bermu
 */
public class Usuario {
     //LOS ATRIBUTOS(COLUMNAS) DE LA BASE DE DATOS
    private int id_usuario;
    private String Nombre;
    private String Correo;
    private String Pass;

    public Usuario() {
    }
    //AQUI AGREGAMOS EL CONSTRUCTOR QUE NOS PERMITE ACCEDER A LA INFORMACION
    public Usuario(int id_usuario, String Nombre, String Correo, String Pass) {
        this.id_usuario = id_usuario;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Pass = Pass;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    
    

}