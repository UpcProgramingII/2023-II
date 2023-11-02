/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofacturasjavafxg01.persistencia;

/**
 *
 * @author Jairo F
 */
public class PersistenciaList {
    private static IFactura data;
    
    private PersistenciaList(){
        data = new ListaFactura();
    }
    
    public static IFactura get(){
        if(data==null){
            new PersistenciaList();
        }
        
        return data;
    }
}
