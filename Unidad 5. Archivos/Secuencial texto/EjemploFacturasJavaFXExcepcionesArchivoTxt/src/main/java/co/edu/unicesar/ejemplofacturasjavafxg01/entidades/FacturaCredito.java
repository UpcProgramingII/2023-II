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
public class FacturaCredito extends Factura {
    
    private int plazoMaximo;

    public FacturaCredito() {
    }

    public FacturaCredito(int plazoMaximo, LocalDate fechaFactura, double valorFactura) {
        super(fechaFactura, valorFactura);
        this.plazoMaximo = plazoMaximo;
    }

    /**
     * @return the plazoMaximo
     */
    public int getPlazoMaximo() {
        return plazoMaximo;
    }

    /**
     * @param plazoMaximo the plazoMaximo to set
     */
    public void setPlazoMaximo(int plazoMaximo) {
        this.plazoMaximo = plazoMaximo;
    }

    @Override
    public String toString() {
        
        return String.format("%10d %15s %15s %15.2f %25d %15s %15s %15.2f",
                            this.getConsecutivo(),
                            this.getFechaFactura().toString(),
                            "Credito",
                            this.getValorFactura(),
                            this.plazoMaximo,
                            "X",
                            "X",
                            this.pagoFactura());
    }

    @Override
    public double pagoFactura() {
        double incrementoFactura;
        if(this.plazoMaximo>=0 && this.plazoMaximo<=30){
            incrementoFactura = 0.05;
        }
        else if(this.plazoMaximo<=60){
            incrementoFactura = 0.1;
        }
        else{
            incrementoFactura = 0.2;
        }
        return this.getValorFactura() + this.getValorFactura()*incrementoFactura;        
    }
    
    @Override
    public String infoFactura(){
        return super.infoFactura() + 
               String.format("%-15s: %s\n%-15s: %d dias\n%-15s: %.2f\n", 
                             "Tipo factura", "Credito",
                             "Plazo maximo", this.plazoMaximo,
                             "Valor pago", this.pagoFactura());
    }
    
    
    @Override
    public String getDataForFileTxt(){
     
        return String.format("CR;%d;%s;%.2f;%d;%.2f", 
                             this.getConsecutivo(),
                             this.getFechaFactura().toString(),
                             this.getValorFactura(),
                             this.getPlazoMaximo(),
                             this.pagoFactura());
    }
    
}
