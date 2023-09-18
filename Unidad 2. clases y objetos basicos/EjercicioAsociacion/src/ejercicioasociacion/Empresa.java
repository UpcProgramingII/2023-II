/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioasociacion;

import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public class Empresa {
    
    private String nit;
    private String nombre;
    private ArrayList<Persona> empleados;
    private ArrayList<Direccion> sedes;

    public Empresa(String nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
        this.empleados = new ArrayList();
        this.sedes = new ArrayList();
        
    }

    public Empresa() {
         this.empleados = new ArrayList();
         this.sedes = new ArrayList();
    }
    
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Persona> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Persona> empleados) {
        this.empleados = empleados;
    }
    
    public ArrayList<Direccion> getSedes() {
        return sedes;
    }

    public void setSedes(ArrayList<Direccion> sedes) {
        this.sedes = sedes;
    }
         
    public void addEmpleado(Persona p){
    
            this.empleados.add(p);
    }
    
    public void addSedes(Direccion d){
    
            this.sedes.add(d);
    }

    
    
    
    
}
