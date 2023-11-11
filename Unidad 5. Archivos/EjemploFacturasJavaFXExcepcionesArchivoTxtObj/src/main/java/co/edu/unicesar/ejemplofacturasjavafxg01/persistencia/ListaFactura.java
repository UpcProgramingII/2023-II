/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofacturasjavafxg01.persistencia;

import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.Factura;
import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.FacturaContado;
import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.FacturaCredito;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public class ListaFactura implements IFactura, Serializable {
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

    @Override
    public ArrayList<Factura> obtenerfacturasCredito() {
        ArrayList<Factura> facturasCreditos = new ArrayList();
        for(Factura f: this.listaFactura){
            if(f instanceof FacturaCredito){
                facturasCreditos.add(f);
            }
        
        }
        return facturasCreditos;
    }

    @Override
    public ArrayList<Factura> obtenerfacturasContado() {
        ArrayList<Factura> facturasContado = new ArrayList();
        for(Factura f: this.listaFactura){
            if(f instanceof FacturaContado){
                facturasContado.add(f);
            }
        
        }
        return facturasContado;
    }
    
    
    
    
    
}
