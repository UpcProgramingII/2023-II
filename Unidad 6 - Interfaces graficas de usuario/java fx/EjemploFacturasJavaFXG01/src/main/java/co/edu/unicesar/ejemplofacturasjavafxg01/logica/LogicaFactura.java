package co.edu.unicesar.ejemplofacturasjavafxg01.logica;

import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.Factura;
import co.edu.unicesar.ejemplofacturasjavafxg01.persistencia.IFactura;
import co.edu.unicesar.ejemplofacturasjavafxg01.persistencia.ListaFactura;
import co.edu.unicesar.ejemplofacturasjavafxg01.persistencia.PersistenciaList;
import java.util.List;



/**
 *
 * @author Jairo F
 */
public class LogicaFactura {
    
    private IFactura data ;

    public LogicaFactura() {
        //this.data = new ListaFactura();
        this.data = PersistenciaList.get();
    }
    
    public void registrarFactura(Factura f){
       this.data.adicionarFactura(f);
    }
    
    public List<Factura> consultarFacturas(){
        return this.data.obtenerfacturas();
    }
    
    public List<Factura> consultarFacturasCredito(){
        return this.data.obtenerfacturasCredito();
    }
    
    public List<Factura> consultarFacturasContado(){
        return this.data.obtenerfacturasContado();
    }
    
    public Factura buscarFactura(int noFactura){
         Factura f = this.data.buscarFactura(noFactura);
         return f;
    }
    
    
    
    
}
