/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import entidades.Factura;
import java.util.List;
import persistencia.*;

/**
 *
 * @author Jairo F
 */
public class LogicaFactura {
    
    private IFactura data ;

    public LogicaFactura() {
        this.data = new ListaFactura();
    }
    
    public void registrarFactura(Factura f){
       this.data.adicionarFactura(f);
    }
    
    public List<Factura> consultarFacturas(){
        return this.data.obtenerfacturas();
    }
    
    public Factura buscarFactura(int noFactura){
         Factura f = this.data.buscarFactura(noFactura);
         return f;
    }
    
    
    
    
}
