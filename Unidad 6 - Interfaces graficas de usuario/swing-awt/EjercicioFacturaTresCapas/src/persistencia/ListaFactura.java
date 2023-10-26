/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Factura;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public class ListaFactura implements IFactura {
    private List<Factura> listaFactura;

    public ListaFactura() {
        this.listaFactura = new ArrayList();
    }

    @Override
    public void adicionarFactura(Factura f) {
        this.listaFactura.add(f);
    }

    @Override
    public ArrayList<Factura> obtenerfacturas() {
        ArrayList<Factura> lista = new ArrayList(this.listaFactura);
        return lista;
    }

    @Override
    public Factura buscarFactura(int noFactura) {
        Factura facturaBuscada = null;
        for(Factura f: this.listaFactura){
            if(f.getConsecutivo()==noFactura){
                facturaBuscada = f;
                break;
            }
        
        }
        return facturaBuscada;
    }
    
    
    
    
    
}
