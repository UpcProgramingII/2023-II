/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofacturasjavafxg01.entidades;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.*;

/**
 *
 * @author Jairo F
 */
public class FacturaContado extends Factura {
    
    private char medioPago;
    private LocalDate fechapago;

    public FacturaContado() {
    }

    public FacturaContado(char medioPago, LocalDate fechapago, LocalDate fechaFactura, double valorFactura) {
        super(fechaFactura, valorFactura);
        this.medioPago = medioPago;
        this.fechapago = fechapago;
    }

    /**
     * @return the medioPago
     */
    public char getMedioPago() {
        return medioPago;
    }

    /**
     * @param medioPago the medioPago to set
     */
    public void setMedioPago(char medioPago) {
        this.medioPago = medioPago;
    }

    /**
     * @return the fechapago
     */
    public LocalDate getFechapago() {
        return fechapago;
    }

    /**
     * @param fechapago the fechapago to set
     */
    public void setFechapago(LocalDate fechapago) {
        this.fechapago = fechapago;
    }

    @Override
    public String toString() {

       return String.format("%10d %15s %15s %15.2f %25s %15s %15s %15.2f",
                            this.getConsecutivo(),
                            this.getFechaFactura().toString(),
                            "Contado",
                            this.getValorFactura(),
                            "X",
                            this.fechapago,
                            this.medioPago,
                            this.pagoFactura());
    }

    @Override
    public double pagoFactura() {
        double descuentoFactura=0;
        long dias = DAYS.between(this.getFechaFactura(), this.fechapago);
        if(dias>=0 && dias <=5){
            descuentoFactura = 0.1;
        }else if(dias<=10){
            descuentoFactura = 0.05;
        }
        return this.getValorFactura() - this.getValorFactura()*descuentoFactura;
    }
    
    
    @Override
    public String infoFactura(){
        return super.infoFactura() + 
               String.format("%-15s: %s\n%-15s: %s\n%-15s: %s\n%-15s: %.2f\n",
                             "Tipo factura", "Contado", 
                             "Medio pago", this.medioPago=='T'?"Tarjeta":"Efectivo",
                             "Fecha pago", this.fechapago.toString(),
                             "Valor pago", this.pagoFactura());
    }
    
    
}
