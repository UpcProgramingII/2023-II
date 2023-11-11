package co.edu.unicesar.ejemplofacturasjavafxg01.logica;

import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.Factura;
import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.FacturaContado;
import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.FacturaCredito;
import co.edu.unicesar.ejemplofacturasjavafxg01.persistencia.ArchivoObjetoFactura;
import co.edu.unicesar.ejemplofacturasjavafxg01.persistencia.ArchivoTxtFactura;
import co.edu.unicesar.ejemplofacturasjavafxg01.persistencia.IFactura;
import co.edu.unicesar.ejemplofacturasjavafxg01.persistencia.ListaFactura;
import co.edu.unicesar.ejemplofacturasjavafxg01.persistencia.PersistenciaList;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public class LogicaFactura {

    private IFactura data;

    public LogicaFactura() {
        //this.data = new ListaFactura();
        //this.data = PersistenciaList.get();
       // this.data = new ArchivoTxtFactura();
       this.data = new ArchivoObjetoFactura();
    }

    public void registrarFactura(Factura f) {
        this.data.adicionarFactura(f);
    }

    public List<Factura> consultarFacturas() {
        return this.data.obtenerfacturas();
    }

    public List<Factura> consultarFacturasCredito() {
        return this.data.obtenerfacturasCredito();
    }

    public List<Factura> consultarFacturasContado() {
        return this.data.obtenerfacturasContado();
    }

    public Factura buscarFactura(int noFactura) {
        Factura f = this.data.buscarFactura(noFactura);
        return f;
    }

    public Factura crearFactura(String numFact, LocalDate fechaFactura, String valorFactura, String tipo, char medioPago, LocalDate fechaPago, String plazoMaximo) {

        if (numFact.isEmpty()) {
            throw new IllegalArgumentException("Se requiere un numero de factura valido");
        }

        if (fechaFactura == null) {
            throw new IllegalArgumentException("Se requiere una fecha de factura valida");
        }

        if (valorFactura.isEmpty()) {
            throw new IllegalArgumentException("Se requiere el registro del valor de factura");
        }
        
        int noFactura = Integer.valueOf(numFact);
        double valor = Double.valueOf(valorFactura);
        Factura nuevaFactura;

        if (tipo.equals("contado")) {

            if (fechaPago == null) {
                throw new IllegalArgumentException("Se requiere una fecha de pago valida");
            }
            
                        
            nuevaFactura = new FacturaContado(medioPago, fechaPago, fechaFactura, valor);

        } else {
            if (plazoMaximo.isEmpty()) {
                throw new IllegalArgumentException("Se requiere el registro del plazo maximo");
            }
            
            int plazo = Integer.valueOf(plazoMaximo);
            
            nuevaFactura = new FacturaCredito(plazo, fechaFactura, valor);
        }
        nuevaFactura.setConsecutivo(noFactura);
        return nuevaFactura;
    }

}
