/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofacturasjavafxg01.entidades;

import java.time.LocalDate;

/**
 *
 * @author Jairo F
 */
public abstract class Factura {
    
    private static int noConsecutivo=0;
    private int consecutivo;
    private LocalDate fechaFactura;
    private double valorFactura;

    public Factura() {
        
        noConsecutivo++;
        this.consecutivo=noConsecutivo;
    }

    public Factura(LocalDate fechaFactura, double valorFactura) {
        this.fechaFactura = fechaFactura;
        this.valorFactura = valorFactura;
        noConsecutivo++;
        this.consecutivo=noConsecutivo;
    }

    /**
     * @return the consecutivo
     */
    public int getConsecutivo() {
        return consecutivo;
    }

    /**
     * @param consecutivo the consecutivo to set
     */
    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    /**
     * @return the fechaFactura
     */
    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    /**
     * @param fechaFactura the fechaFactura to set
     */
    public void setFechaFactura(LocalDate fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    /**
     * @return the valorFactura
     */
    public double getValorFactura() {
        return valorFactura;
    }

    /**
     * @param valorFactura the valorFactura to set
     */
    public void setValorFactura(double valorFactura) {
        this.valorFactura = valorFactura;
    }

    public abstract String toString();    
    
    public abstract double pagoFactura();
    
    public String infoFactura(){
        
        return String.format("%-15s: %s\n%-15s: %.2f\n ", 
                             "Fecha factura", this.fechaFactura.toString(),
                             "Valor factura", this.valorFactura);
        
    }
   
    public abstract String getDataForFileTxt();
    
    
}
