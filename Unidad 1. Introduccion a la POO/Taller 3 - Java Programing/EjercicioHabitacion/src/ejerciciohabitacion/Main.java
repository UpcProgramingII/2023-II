/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciohabitacion;

/**
 *
 * @author Jairo F
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        double longitud = 50.9;
        double anchura = 40.4;
        double superficie = calcularSuperficie(longitud, anchura);
        System.out.println("Superficie=" + superficie);
    }

    public static double calcularSuperficie(double longitud, double anchura) {

        return longitud * anchura;

    }

}
