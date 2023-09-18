/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioasociacion;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Jairo F
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Empresa empresa = new Empresa("12345-7", "Los indestructibles");
        Direccion dir = new Direccion("Holliwood", "Usa");
        empresa.addSedes(dir);
        
        Empresa empresa2 = new Empresa("6789-0", "Los flojos");
        empresa2.addSedes(dir);
        empresa2.addSedes(new Direccion("valledupar", "Colombia"));
        
        Persona p = new Persona("12345","Jairo", "Seoanes", 38);
        p.setEmpresa(empresa2);
        p.setDomicilio(new Direccion("La paz", "Colombia"));
        p.setFechaVinculacion(LocalDate.now());
        
        Persona p2 = new Persona("5555","Bruce", "Willis",70,new Direccion("Miami", "Usa"), empresa, LocalDate.of(2023, Month.MARCH, 1));
               
        Persona p3 = new Persona("9999",
                                 "Silvestre", 
                                 "Stallone",
                                 60,
                                 new Direccion("Chicago", "Usa"),
                                 empresa,
                                 LocalDate.of(2023, 5, 15));
                
        empresa2.addEmpleado(p);
        empresa.addEmpleado(p2);
        empresa.addEmpleado(p3);
        
        
        imprimirEmpresa(empresa2);
        imprimirEmpresa(empresa);
        
        imprimirPersona(p);
        imprimirPersona(p2);
        imprimirPersona(p3);
        
        
        
        
        
        
    }
    
    public static void imprimirEmpresa(Empresa empresa){
        System.out.println("Informacion de empresa");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Nombre            : " + empresa.getNombre());
        System.out.println("Nit               : " + empresa.getNit());
        System.out.print("Sedes             : ");
        for(Direccion sede: empresa.getSedes()){
            System.out.printf("%s | ", sede.toString());
        }
        System.out.println("");
        System.out.print("Lista de empleados: ");
        for(Persona e: empresa.getEmpleados()){
            System.out.printf("( %s, %s ) | ", e.getNombre(), e.getApellido() );
        }
        System.out.println("");
        System.out.println("Total empleados   : " + empresa.getEmpleados().size());
        System.out.println("");
    
    }
    
    public static void imprimirPersona(Persona p){
            System.out.println("Informacion de Persona: ");
            System.out.println("---------------------------------");
            System.out.println(p);
            System.out.println("---------------------------------\n");
    }
    
}
