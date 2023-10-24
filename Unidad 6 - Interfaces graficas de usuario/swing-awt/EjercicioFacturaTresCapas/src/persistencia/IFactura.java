/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.Factura;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public interface IFactura {
    
    public void adicionarFactura(Factura f);
    public ArrayList<Factura> obtenerfacturas();
    public Factura buscarFactura(int noFactura);
    
    
}
