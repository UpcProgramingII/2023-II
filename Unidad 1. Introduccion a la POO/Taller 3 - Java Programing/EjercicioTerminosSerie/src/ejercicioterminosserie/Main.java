/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioterminosserie;

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
        
        int n=3;
        System.out.println("Suma terminos = " + sumaTerminos(n));
    }
    
    public static double sumaTerminos(int n){
        double suma = 0;
        for(int i=1; i<=n; i++ ){
            double termino = i / Math.pow(2, i);
            suma+=termino;
        }
        return suma;
    }
    
}
