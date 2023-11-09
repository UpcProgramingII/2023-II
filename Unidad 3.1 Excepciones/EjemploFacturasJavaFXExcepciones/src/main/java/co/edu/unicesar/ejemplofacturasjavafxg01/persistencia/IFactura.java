/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicesar.ejemplofacturasjavafxg01.persistencia;

import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.*;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public interface IFactura {
    
    public void adicionarFactura(Factura f);
    public ArrayList<Factura> obtenerfacturas();
    public ArrayList<Factura> obtenerfacturasCredito();
    public ArrayList<Factura> obtenerfacturasContado();
    public Factura buscarFactura(int noFactura);
    
    
}
