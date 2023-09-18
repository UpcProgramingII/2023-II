/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioasociacion;

import java.time.LocalDate;

/**
 *
 * @author Jairo F
 */
public class Persona {
    
    private String documento;
    private String nombre;
    private String apellido;
    private int edad;
    private Direccion domicilio;
    private Empresa empresa;
    private LocalDate fechaVinculacion;
    
    public Persona() { }
    
    public Persona(String documento, String nombre, String apellido, int edad) {
        this.documento=documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad=edad;
    }

    public Persona(String documento,String nombre, String apellido,int edad, Direccion domicilio, Empresa empresa, LocalDate fecha) {
        this.documento=documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad=edad;
        this.domicilio = domicilio;
        this.empresa = empresa;
        this.fechaVinculacion=fecha;
    }
    
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Direccion getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Direccion domicilio) {
        this.domicilio = domicilio;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    public LocalDate getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(LocalDate fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Override
    public String toString() {
        
       String datos =  String.format("Nombre           : %s%n"+
                                     "Apellido         : %s%n"+
                                     "Documento        : %s%n"+
                                     "Edad             : %d%n"+
                                     "Direccion        : %s%n"+
                                     "Empresa          : %s%n"+
                                     "Fecha vinculacion: %s%n", 
                                     this.nombre, 
                                     this.apellido, 
                                     this.documento,
                                     this.edad,
                                     this.domicilio.toString(), 
                                     this.empresa.getNombre(), 
                                     this.fechaVinculacion);
        return datos;
    }

   

    

    
    
}
