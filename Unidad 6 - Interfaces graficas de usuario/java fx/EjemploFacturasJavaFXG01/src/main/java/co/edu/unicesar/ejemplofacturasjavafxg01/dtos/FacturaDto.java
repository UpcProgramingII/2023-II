/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofacturasjavafxg01.dtos;

import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.Factura;
import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.FacturaContado;
import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.FacturaCredito;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Jairo F
 */
public class FacturaDto {

    private SimpleIntegerProperty noFactura;
    private SimpleStringProperty fechaFactura;
    private SimpleDoubleProperty valorFactura;
    private SimpleStringProperty plazoMaximo;
    private SimpleStringProperty fechaPago;
    private SimpleStringProperty medioPago;
    private SimpleDoubleProperty valorPagar;

    public FacturaDto(Factura f) {
        this.noFactura= new SimpleIntegerProperty(f.getConsecutivo());
        this.valorFactura=new SimpleDoubleProperty(f.getValorFactura());
        this.fechaFactura=new SimpleStringProperty(f.getFechaFactura().toString());
        if (f instanceof FacturaContado) {
            FacturaContado fc = (FacturaContado) f;
            this.medioPago=new SimpleStringProperty(String.valueOf(fc.getMedioPago()));
            this.fechaPago=new SimpleStringProperty(fc.getFechapago().toString());
            this.plazoMaximo=new SimpleStringProperty("");
            this.valorPagar=new SimpleDoubleProperty(fc.pagoFactura());
        } else {
            FacturaCredito fcr = (FacturaCredito) f;
            this.medioPago=new SimpleStringProperty("");
            this.fechaPago=new SimpleStringProperty("");
            this.plazoMaximo=new SimpleStringProperty(String.valueOf(fcr.getPlazoMaximo()));
            this.valorPagar=new SimpleDoubleProperty(fcr.pagoFactura());
        }

    }

    /**
     * @return the noFactura
     */
    public int getNoFactura() {
        return noFactura.get();
    }

    /**
     * @return the fechaFactura
     */
    public String getFechaFactura() {
        return fechaFactura.get();
    }

    /**
     * @return the valorFactura
     */
    public double getValorFactura() {
        return valorFactura.get();
    }

    /**
     * @return the plazoMaximo
     */
    public String getPlazoMaximo() {
        return plazoMaximo.get();
    }

    /**
     * @return the fechaPago
     */
    public String getFechaPago() {
        return fechaPago.get();
    }

    /**
     * @return the medioPago
     */
    public String getMedioPago() {
        return medioPago.get();
    }

    /**
     * @return the valorPagar
     */
    public double getValorPagar() {
        return valorPagar.get();
    }

}
