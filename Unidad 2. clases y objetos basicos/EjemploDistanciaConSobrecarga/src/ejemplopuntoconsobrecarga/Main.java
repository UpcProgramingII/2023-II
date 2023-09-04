/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplopuntoconsobrecarga;

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
        
        Punto a = new Punto();
        Punto b = new Punto(10,10);
        
        System.out.println("Distancia (a, b) = " + a.calcularDistancia(b));
        System.out.println("Distancia (b, a)=" + b.calcularDistancia(a));
        System.out.println("* Distancia (b, a)=" + b.calcularDistancia(a.getX(), a.getY()));
        
    }
    
}
