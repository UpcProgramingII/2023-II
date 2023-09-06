/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplovector3d;

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
        Vector3d u = new Vector3d(5,7,11);
        Vector3d v = new Vector3d(4,2,8);
        
        Vector3d suma_uv = u.sumaVector(v.getX(), v.getY(), v.getZ());
        Vector3d suma_vu = v.sumaVector(u);
        
        System.out.println("Vector u: "+ u.getVector());
        System.out.println("Vector v: "+ v.getVector());
        System.out.println("(u + v) : "+suma_uv.getVector());
        System.out.println("(v + u) : "+suma_vu.getVector());
        System.out.println("| u |   : "+u.moduloVector());
        System.out.println("(u * 5) : " + u.scalarMultiplication(5).getVector());
        
    }
    
}
