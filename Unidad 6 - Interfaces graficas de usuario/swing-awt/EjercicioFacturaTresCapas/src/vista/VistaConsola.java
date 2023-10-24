/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import entidades.*;
import java.time.LocalDate;
import logica.LogicaFactura;

/**
 *
 * @author Jairo F
 */
public class VistaConsola {

    private LogicaFactura logica;

    public VistaConsola() {
        this.logica = new LogicaFactura();
    }

    public void mostrarMenu() {
        System.out.println("");
        System.out.println("| ## SOFTWARE GESTION DE FACTURAS ## |");
        System.out.println("--------------------------------------");
        System.out.println("1. Registrar factura");
        System.out.println("2. Listar facturas");
        System.out.println("3. Buscar factura");
        System.out.println("4. Salir\n");

    }

    public void ejecutarMenu() {
        int opcionSeleccionada;
        do {

            this.mostrarMenu();
            opcionSeleccionada = Entrada.leerInt("Seleccione una opcion");
            switch (opcionSeleccionada) {

                case 1:
                    this.opcionRegistrarFactura();
                    break;
                case 2:
                    this.opcionConsultarFactura();
                    break;
                case 3:
                    this.opcionBuscarFactura();
                    break;
                case 4:
                    System.out.println("!! Aplicacion finalizada con exito ¡¡");
                    break;
                default:
                    System.out.println("!! Opcion no valida ¡¡\n");

            }

        } while (opcionSeleccionada != 4);

    }

    public void opcionRegistrarFactura() {
        int continuar;
        do {
            System.out.println("");
            System.out.println("| ## 1. REGISTRO DE FACTURA ## |");
            System.out.println("--------------------------------");
            Factura nuevaFactura;
            LocalDate fechaFactura = Entrada.leerFecha("Fecha factura");
            double valorFactura = Entrada.leerDouble("valor factura");
            char tipoFactura = Entrada.leerChar("Tipo [C->credito][*->Contado]");
            switch (tipoFactura) {
                case 'C':
                    int plazoMaximo = Entrada.leerInt("Plazo maximo");
                    nuevaFactura = new FacturaCredito(plazoMaximo, fechaFactura, valorFactura);
                    break;
                default:
                    char medioPago = Entrada.leerChar("Medio Pago [T->Tarjeta][*->Contado]");
                    LocalDate fechaPago = Entrada.leerFecha("Fecha pago");
                    nuevaFactura = new FacturaContado(medioPago, fechaPago, fechaFactura, valorFactura);
            }

            this.logica.registrarFactura(nuevaFactura);
            System.out.println("!! Factura registrada con exito ¡¡");
            continuar = Entrada.leerInt("Desea registrar otra factura [1->Si][Otro->No]");
        } while (continuar == 1);

    }

    public void opcionConsultarFactura() {
        int continuar;

        System.out.println("");
        System.out.println("| ## 2. LISTADO DE FACTURAS ## |");
        System.out.println("--------------------------------");
        System.out.printf("%-10s %15s %15s %15s %25s %15s %15s %15s\n",
                           "No Factura", "Fecha Factura", "Tipo Factura", "Valor Factura", "plazo Maximo (dias)", "Fecha Pago", "Medio Pago", "Valor Pagado");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Factura f : this.logica.consultarFacturas()) {
            System.out.println(f);
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Total Facturas Registradas : " + this.logica.consultarFacturas().size());
        System.out.println("");
        continuar = Entrada.leerInt("Presiona cualquier numero para volver al menu ");

    }

    public void opcionBuscarFactura() {
        
        int continuar;
        do {
            System.out.println("");
            System.out.println("| ## 3. BUSQUEDA DE FACTURA ## |");
            System.out.println("--------------------------------");
            Factura facturaBuscada;
            int noFactura = Entrada.leerInt("No factura");
            
            facturaBuscada = this.logica.buscarFactura(noFactura);
            System.out.println("---------------------------------");
            if(facturaBuscada==null){
                System.out.println("!! La factura no ha sido registrada ¡¡\n ");
            }
            else{
                 System.out.println(facturaBuscada.infoFactura());
            }
            System.out.println("");     
            continuar = Entrada.leerInt("Desea registrar otra factura [1->Si][Otro->No]");
        } while (continuar == 1);

    }

}
