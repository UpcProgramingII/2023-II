/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package priyectorectangulo;

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
        
        Rectangulo a= new Rectangulo();
        a.setBase(20);
        a.setAltura(30);
        System.out.println("Area a= " + a.calcularArea());
        
        Rectangulo b= new Rectangulo();
        System.out.println("Area b= " + b.calcularArea());
    }
    
}
